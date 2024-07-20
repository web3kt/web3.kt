package org.web3kt.abi.type

import kotlin.String

public data class AddressType(
    override val `value`: String,
) : Type<String> {
    override val type: String = "address"
}
