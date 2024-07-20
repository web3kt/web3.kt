package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable

@Serializable
data class TxPoolTransaction(
    val hash: String,
    val isReceivedFromLocalSource: Boolean,
    val addedToPoolAt: String,
)
