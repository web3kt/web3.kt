package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TxPoolPendingTransaction(
    val accessList: List<Access>? = null,
    val from: String,
    val gas: Integer,
    val gasPrice: Integer? = null,
    val maxFeePerGas: Integer? = null,
    val maxPriorityFeePerGas: Integer? = null,
    val hash: String,
    val input: String,
    val nonce: Integer,
    val to: String? = null,
    val transactionType: String,
    val value: Integer,
    val v: String,
    val r: String,
    val s: String,
)
