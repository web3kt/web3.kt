package org.web3kt.rlp

import kotlin.test.Test

class RlpEncoderTest {
    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun encode() {
        val encoded = RlpEncoder.encode(RlpString("dog".toByteArray()))
        println(encoded.toHexString())
    }
}
