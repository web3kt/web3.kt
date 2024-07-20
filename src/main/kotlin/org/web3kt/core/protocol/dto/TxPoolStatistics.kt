package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable

@Serializable
data class TxPoolStatistics(
    val maxSize: Int,
    val localCount: Int,
    val remoteCount: Int,
)
