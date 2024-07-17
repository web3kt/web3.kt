package org.web3kt.abi.type

sealed interface Type<T> {
    val value: T
    val type: String
}
