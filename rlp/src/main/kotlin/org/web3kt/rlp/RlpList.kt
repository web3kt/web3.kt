package org.web3kt.rlp

data class RlpList(
    val values: MutableList<RlpType>,
) : RlpType
