package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class CreateAccessList(
    val accessList: List<Access>,
    val gasUse: Integer,
)
