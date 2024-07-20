package org.web3kt.abi.type

import java.math.BigInteger
import kotlin.String

public data class Int40Type(
    override val `value`: BigInteger,
) : Type<BigInteger> {
    override val type: String = "int40"
}
