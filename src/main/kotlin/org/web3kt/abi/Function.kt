package org.web3kt.abi

import org.web3kt.abi.type.Type
import org.web3kt.abi.type.TypeReference

data class Function(
    val name: String,
    val inputs: List<Type<*>>,
    val outputs: List<TypeReference<*>>,
) {
    fun getSignature(): String = "$name(${inputs.joinToString(separator = ",") { it.type }})"

    fun getSelector(): String =
        MessageDigest
            .digest(getSignature().toByteArray())
            .take(4)
            .toHex()
}
