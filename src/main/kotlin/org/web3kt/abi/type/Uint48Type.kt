package org.web3kt.abi.type

import java.math.BigInteger
import kotlin.String

public data class Uint48Type(
    override val `value`: BigInteger,
) : Type<BigInteger> {
    override val type: String = "uint48"
}
