package org.web3kt.abi.type

import org.web3kt.abi.Convert
import kotlin.reflect.KClass

data class DynamicArray<T : Type<*>>(
    val kClass: KClass<T>,
    override val value: List<T>,
    override val type: String = "${Convert.typeClassToType(kClass)}[]",
) : Type<List<T>> {
    val size = value.size
}
