/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3kt.rlp

import java.util.Arrays

/**
 * Recursive Length Prefix (RLP) encoder.
 *
 *
 * For the specification, refer to p16 of the [yellow
 * paper](http://gavwood.com/paper.pdf) and [here](https://github.com/ethereum/wiki/wiki/RLP).
 */
object RlpEncoder {
    fun encode(value: RlpType): ByteArray =
        when (value) {
            is RlpString -> encodeString(value)
            is RlpList -> encodeList(value)
        }

    private fun encode(
        bytes: ByteArray,
        offset: Int,
    ): ByteArray {
        if (bytes.size == 1 && offset == Constant.OFFSET_SHORT_STRING && bytes[0] >= 0x00.toByte() && bytes[0] <= 0x7f.toByte()) {
            return bytes
        } else if (bytes.size <= 55) {
            val result = ByteArray(bytes.size + 1)
            result[0] = (offset + bytes.size).toByte()
            System.arraycopy(bytes, 0, result, 1, bytes.size)
            return result
        } else {
            val encodedStringLength = toMinimalByteArray(bytes.size)
            val result = ByteArray(bytes.size + encodedStringLength.size + 1)

            result[0] = ((offset + 0x37) + encodedStringLength.size).toByte()
            System.arraycopy(encodedStringLength, 0, result, 1, encodedStringLength.size)
            System.arraycopy(bytes, 0, result, encodedStringLength.size + 1, bytes.size)
            return result
        }
    }

    private fun encodeString(rlpString: RlpString): ByteArray = encode(rlpString.value, Constant.OFFSET_SHORT_STRING)

    private fun toMinimalByteArray(value: Int): ByteArray {
        val encoded = toByteArray(value)

        for (i in encoded.indices) {
            if (encoded[i].toInt() != 0) {
                return Arrays.copyOfRange(encoded, i, encoded.size)
            }
        }

        return byteArrayOf()
    }

    private fun toByteArray(value: Int): ByteArray =
        byteArrayOf(
            ((value shr 24) and 0xff).toByte(),
            ((value shr 16) and 0xff).toByte(),
            ((value shr 8) and 0xff).toByte(),
            (value and 0xff).toByte(),
        )

    private fun encodeList(rlpList: RlpList): ByteArray {
        val values = rlpList.values
        if (values.isEmpty()) {
            return encode(byteArrayOf(), Constant.OFFSET_SHORT_LIST)
        } else {
            var result = ByteArray(0)
            for (entry in values) {
                result = concat(result, encode(entry))
            }
            return encode(result, Constant.OFFSET_SHORT_LIST)
        }
    }

    private fun concat(
        b1: ByteArray,
        b2: ByteArray,
    ): ByteArray {
        val result = b1.copyOf(b1.size + b2.size)
        System.arraycopy(b2, 0, result, b1.size, b2.size)
        return result
    }
}
