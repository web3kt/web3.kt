package org.web3kt.core.protocol.dto

import kotlinx.serialization.Serializable
import org.web3kt.core.protocol.serializer.Integer

@Serializable
data class TxPoolFilter(
    val from: OperatorFrom? = null,
    val to: OperatorTo? = null,
    val gas: OperatorQuantity? = null,
    val gasPrice: OperatorQuantity? = null,
    val value: OperatorQuantity? = null,
    val nonce: OperatorQuantity? = null,
)

@Serializable
data class OperatorFrom(
    val eq: String? = null,
)

@Serializable
data class OperatorTo(
    val eq: String? = null,
    val action: String? = null,
)

@Serializable
data class OperatorQuantity(
    val eq: Integer? = null,
    val gt: Integer? = null,
    val lt: Integer? = null,
)
