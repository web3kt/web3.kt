package org.web3kt.contract

import org.web3kt.abi.Function
import org.web3kt.abi.type.Type
import org.web3kt.core.Web3

abstract class Contract(
    val web3: Web3,
    val address: String,
    val caller: String,
) {
    fun <T> call(function: Function): T = TODO()

    fun call(function: Function): List<Type<*>> = TODO()

    fun send(function: Function): String = TODO()
}
