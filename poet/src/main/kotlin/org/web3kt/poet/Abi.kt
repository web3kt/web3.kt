package org.web3kt.poet

import kotlinx.serialization.Serializable

@Serializable
data class Abi(
    val type: String,
    val name: String? = null,
    val stateMutability: String? = null,
    val anonymous: Boolean? = null,
    val inputs: List<Input> = emptyList(),
    val outputs: List<Output> = emptyList(),
) {
    @Serializable
    data class Input(
        val internalType: String,
        val type: String,
        val indexed: Boolean? = null,
        val name: String,
    )

    @Serializable
    data class Output(
        val internalType: String,
        val type: String,
        val name: String,
    )
}
