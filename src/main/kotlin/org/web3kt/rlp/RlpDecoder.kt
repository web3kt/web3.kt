package org.web3kt.rlp

object RlpDecoder {
    fun decode(bytes: ByteArray): RlpList {
        val rlpList = RlpList(ArrayList())
        traverse(bytes, 0, bytes.size, rlpList)
        return rlpList
    }

    private fun traverse(
        data: ByteArray?,
        startPos: Int,
        endPos: Int,
        rlpList: RlpList,
    ) {
        var start = startPos
        try {
            if (data == null || data.isEmpty()) {
                return
            }

            if (endPos < 0 || endPos > data.size) {
                throw RuntimeException("RLP invalid parameters while decoding")
            }

            while (start < endPos) {
                val prefix = data[start].toInt() and 0xff

                if (prefix < Constant.OFFSET_SHORT_STRING) {
                    val rlpData = byteArrayOf(prefix.toByte())
                    rlpList.values.add(RlpString(rlpData))
                    start += 1
                } else if (prefix == Constant.OFFSET_SHORT_STRING) {
                    rlpList.values.add(RlpString(ByteArray(0)))
                    start += 1
                } else if (prefix <= Constant.OFFSET_LONG_STRING) {
                    val strLen = (prefix - Constant.OFFSET_SHORT_STRING).toByte()

                    if (strLen > endPos - (start + 1)) {
                        throw RuntimeException("RLP length mismatch")
                    }

                    val rlpData = ByteArray(strLen.toInt())
                    System.arraycopy(data, start + 1, rlpData, 0, strLen.toInt())

                    rlpList.values.add(RlpString(rlpData))
                    start += 1 + strLen
                } else if (prefix < Constant.OFFSET_SHORT_LIST) {
                    val lenOfStrLen = (prefix - Constant.OFFSET_LONG_STRING).toByte()
                    val strLen = calcLength(lenOfStrLen.toInt(), data, start)

                    if (strLen > endPos - (start + lenOfStrLen + 1)) {
                        throw RuntimeException("RLP length mismatch")
                    }

                    val rlpData = ByteArray(strLen)
                    System.arraycopy(data, start + lenOfStrLen + 1, rlpData, 0, strLen)

                    rlpList.values.add(RlpString(rlpData))
                    start += lenOfStrLen + strLen + 1
                } else if (prefix <= Constant.OFFSET_LONG_LIST) {
                    val listLen = (prefix - Constant.OFFSET_SHORT_LIST).toByte()

                    val newLevelList = RlpList(ArrayList())
                    traverse(data, start + 1, start + listLen + 1, newLevelList)
                    rlpList.values.add(newLevelList)

                    start += 1 + listLen
                } else {
                    val lenOfListLen = (prefix - Constant.OFFSET_LONG_LIST).toByte()
                    val listLen = calcLength(lenOfListLen.toInt(), data, start)

                    val newLevelList = RlpList(ArrayList())
                    traverse(data, start + lenOfListLen + 1, start + lenOfListLen + listLen + 1, newLevelList)
                    rlpList.values.add(newLevelList)

                    start += lenOfListLen + listLen + 1
                }
            }
        } catch (e: Exception) {
            throw RuntimeException("RLP wrong encoding", e)
        }
    }

    private fun calcLength(
        lengthOfLength: Int,
        data: ByteArray,
        pos: Int,
    ): Int {
        var pow = (lengthOfLength - 1).toByte()
        var length: Long = 0
        for (i in 1..lengthOfLength) {
            length += ((data[pos + i].toInt() and 0xff).toLong()) shl (8 * pow)
            pow--
        }
        if (length < 0 || length > Int.MAX_VALUE) {
            throw RuntimeException("RLP too many bytes to decode")
        }
        return length.toInt()
    }
}
