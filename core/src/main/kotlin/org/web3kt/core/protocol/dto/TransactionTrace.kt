package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TransactionTrace(
    val action: Action,
    val blockHash: String,
    val blockNumber: Int,
    val result: Result? = null,
    val subtraces: Int,
    val traceAddress: List<Int>,
    val transactionHash: String? = null,
    val transactionPosition: Int? = null,
    val type: String,
) {
    @Serializable
    data class Action(
        val callType: String? = null,
        val from: String? = null,
        val gas: Integer? = null,
        val input: String? = null,
        val to: String? = null,
        val value: Integer,
        val author: String? = null,
        val rewardType: String? = null,
    )

    @Serializable
    data class Result(
        val gasUsed: Integer,
        val output: String,
    )
}
