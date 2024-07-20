package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TransactionTrace(
    val action: Action,
    val blockHash: String,
    val blockNumber: Long,
    val result: Result? = null,
    val subtraces: Int? = null,
    val traceAddress: List<Long>,
    val transactionHash: String? = null,
    val transactionPosition: Long? = null,
    val type: String? = null,
) {
    @Serializable
    data class Action(
        val callType: String? = null,
        val from: String? = null,
        val gas: Integer? = null,
        val input: String? = null,
        val to: String? = null,
        val value: Integer? = null,
        val author: String? = null,
        val rewardType: String? = null,
    )

    @Serializable
    data class Result(
        val gasUsed: Integer? = null,
        val output: String? = null,
    )
}
