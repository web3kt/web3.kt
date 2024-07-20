package org.web3kt.abi.type

import kotlin.ByteArray
import kotlin.String

public data class Bytes25Type(
    override val `value`: ByteArray,
) : Type<ByteArray> {
    override val type: String = "bytes25"
}
