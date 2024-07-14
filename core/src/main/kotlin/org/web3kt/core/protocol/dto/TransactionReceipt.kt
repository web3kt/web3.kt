package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TransactionReceipt(
    val blockHash: String,
    val blockNumber: Integer,
    val contractAddress: String? = null,
    val cumulativeGasUsed: Integer,
    val from: String,
    val gasUsed: Integer,
    val effectiveGasPrice: Integer,
    val logs: List<Log>,
    val logsBloom: String,
    val status: String? = null,
    val to: String? = null,
    val transactionHash: String,
    val transactionIndex: Integer,
    val revertReason: String? = null,
    val type: String,
)
