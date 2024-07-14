package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TransactionCall(
    val from: String? = null,
    val to: String? = null,
    val gas: Integer? = null,
    val gasPrice: Integer? = null,
    val maxPriorityFeePerGas: Integer? = null,
    val maxFeePerGas: Integer? = null,
    val maxFeePerBlobGas: Integer? = null,
    val value: Integer? = null,
    val data: String? = null,
    val input: String? = null,
    val accessList: List<Access>? = null,
    val blockHash: String? = null,
    val blockNumber: String? = null,
    val strict: Boolean? = null,
    val blobVersionedHashes: List<String>? = null,
)
