package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TraceFilterOption(
    val fromBlock: Integer? = null,
    val toBlock: Integer? = null,
    val fromAddress: String? = null,
    val toAddress: String? = null,
    val after: Int? = null,
    val count: Int? = null,
)
