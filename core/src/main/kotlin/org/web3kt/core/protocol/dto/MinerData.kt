package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class MinerData(
    val netBlockReward: Integer,
    val statusBlockReward: Integer,
    val transactionFee: Integer,
    val uncleInclusionReward: Integer,
    val uncleRewards: Map<String, String>,
    val coinbase: String,
    val extraData: String,
    val difficulty: Integer,
    val totalDifficulty: Integer,
)
