package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class Block<T>(
    val baseFeePerGas: Integer? = null,
    val blobGasUsed: Integer? = null,
    val difficulty: Integer,
    val excessBlobGas: Integer? = null,
    val extraData: String,
    val gasLimit: Integer,
    val gasUsed: Integer,
    val hash: String,
    val logsBloom: String,
    val miner: String,
    val mixHash: String,
    val nonce: Integer,
    val number: Integer,
    val parentBeaconBlockRoot: String? = null,
    val parentHash: String,
    val receiptsRoot: String,
    val sha3Uncles: String,
    val size: Integer,
    val stateRoot: String,
    val timestamp: Integer,
    val totalDifficulty: Integer,
    val transactions: List<T>,
    val transactionsRoot: String,
    val uncles: List<String>,
    val withdrawals: List<Withdrawal>? = null,
    val withdrawalsRoot: String? = null,
)
