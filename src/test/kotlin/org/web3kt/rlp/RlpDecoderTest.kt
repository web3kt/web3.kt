package org.web3kt.rlp

import kotlin.test.Test

class RlpDecoderTest {
    @Test
    fun decode() {
        val bytes = byteArrayOf(0x83.toByte(), 0x64.toByte(), 0x6f.toByte(), 0x67.toByte())
        val rlpString = RlpDecoder.decode(bytes).values[0] as RlpString
        println(rlpString.value.toString(Charsets.UTF_8))
    }
}
