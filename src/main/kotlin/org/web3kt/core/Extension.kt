@file:OptIn(ExperimentalStdlibApi::class)

package org.web3kt.core

import java.math.BigInteger

val WEB3_HEX_FORMAT =
    HexFormat {
        bytes { bytePrefix = "0x" }
        number {
            prefix = "0x"
            removeLeadingZeros = true
        }
    }

fun String.hexToBigInteger(format: HexFormat = WEB3_HEX_FORMAT): BigInteger = BigInteger(removePrefix(format.bytes.bytePrefix), 16)

fun BigInteger.toHexString(format: HexFormat = WEB3_HEX_FORMAT): String = format.number.prefix + toString(16)
