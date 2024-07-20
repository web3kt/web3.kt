package org.web3kt.core.protocol.jsonRpc.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Response<T>(
    val result: T? = null,
    val error: Error? = null,
    val id: JsonPrimitive,
) {
    val jsonrpc = "2.0"
}
