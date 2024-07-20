package org.web3kt.abi.type

import kotlin.String

public data class StringType(
    override val `value`: String,
) : Type<String> {
    override val type: String = "string"
}
