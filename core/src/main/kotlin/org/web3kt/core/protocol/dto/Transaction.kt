package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class Transaction(
    val accessList: List<Access>? = null,
    val blockHash: String,
    val blockNumber: String,
    val chainId: Integer? = null,
    val from: String,
    val gas: Integer,
    val gasPrice: Integer,
    val hash: String,
    val input: String,
    val maxFeePerGas: Integer? = null,
    val maxPriorityFeePerGas: Integer? = null,
    val nonce: Integer,
    val r: String,
    val s: String,
    val to: String? = null,
    val transactionIndex: Integer,
    val type: String,
    val v: String,
    val value: Integer,
    val yParity: String? = null,
)
