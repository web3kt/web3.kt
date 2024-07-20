package org.web3kt.abi.type

sealed interface ArrayType<T : Type<*>> : Type<List<T>>
