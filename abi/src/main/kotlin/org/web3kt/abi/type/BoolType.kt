package org.web3kt.abi.type

import kotlin.Boolean
import kotlin.String

public data class BoolType(
  override val `value`: Boolean,
) : Type<Boolean> {
  override val type: String = "bool"
}
