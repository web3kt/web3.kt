package org.web3kt.core.protocol.jsonRpc.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Request<T>(
    val method: String,
    val params: T,
    val id: JsonPrimitive = JsonNull,
) {
    val jsonrpc = "2.0"
}
