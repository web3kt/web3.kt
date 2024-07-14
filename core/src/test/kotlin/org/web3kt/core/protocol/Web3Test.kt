package org.web3kt.core.protocol

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class Web3Test {
    private val web3 = Web3(Fixture.jsonRpc)

    @Test
    fun clientVersion(): Unit = runBlocking { web3.clientVersion() }

    @Test
    fun sha3(): Unit =
        runBlocking {
            val expected = "0x5e39a0a66544c0668bde22d61c47a8710000ece931f13b84d3b2feb44ec96d3f"
            val actual = web3.sha3("0x68656c6c6f20776f726c00")
            assertEquals(expected, actual)
        }
}
