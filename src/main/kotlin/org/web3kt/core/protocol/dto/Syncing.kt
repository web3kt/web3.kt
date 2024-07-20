package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class Syncing(
    val startingBlock: Integer,
    val currentBlock: Integer,
    val highestBlock: Integer,
    val pulledStates: Integer?,
    val knownStates: Integer?,
)
