package org.web3kt.core.protocol

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive
import java.math.BigInteger

fun Any?.toJsonElement(): JsonElement =
    when (this) {
        is Boolean -> JsonPrimitive(this)
        is Number -> JsonPrimitive(this)
        is String -> JsonPrimitive(this)
        is JsonElement -> this
        null -> JsonNull
        else -> throw IllegalArgumentException("Unsupported type: ${this::class}")
    }

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
