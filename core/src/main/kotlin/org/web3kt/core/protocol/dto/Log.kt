package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class Log(
    val logIndex: Integer,
    val removed: Boolean,
    val blockNumber: Integer,
    val blockHash: String,
    val transactionHash: String,
    val transactionIndex: Integer,
    val address: String,
    val data: String,
    val topics: List<String>,
)
