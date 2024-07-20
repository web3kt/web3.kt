package org.web3kt.core.protocol.jsonRpc.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Error(
    val code: Int,
    val message: String,
    val data: JsonElement? = null,
)
