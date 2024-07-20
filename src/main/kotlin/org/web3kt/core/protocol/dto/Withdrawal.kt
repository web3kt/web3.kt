package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class Withdrawal(
    val address: String,
    val amount: Integer,
    val index: Integer,
    val validatorIndex: Integer,
)
