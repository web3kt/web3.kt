package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class FilterOption(
    val fromBlock: Integer? = null,
    val toBlock: Integer? = null,
    val address: String? = null,
    val topics: List<String>? = null,
    val blockHash: String? = null,
)
