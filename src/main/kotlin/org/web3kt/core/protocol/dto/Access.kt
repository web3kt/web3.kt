package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable

@Serializable
data class Access(
    val address: String,
    val storageKeys: List<String>,
)
