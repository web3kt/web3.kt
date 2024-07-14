package org.web3kt.core

import java.math.BigInteger

@OptIn(ExperimentalStdlibApi::class)
val WEB3_HEX_FORMAT =
    HexFormat {
        bytes { bytePrefix = "0x" }
        number {
            prefix = "0x"
            removeLeadingZeros = true
        }
    }

@OptIn(ExperimentalStdlibApi::class)
fun String.hexToBigInteger(format: HexFormat = WEB3_HEX_FORMAT): BigInteger = BigInteger(removePrefix(format.bytes.bytePrefix), 16)

@OptIn(ExperimentalStdlibApi::class)
fun BigInteger.toHexString(format: HexFormat = WEB3_HEX_FORMAT): String = format.number.prefix + toString(16)
