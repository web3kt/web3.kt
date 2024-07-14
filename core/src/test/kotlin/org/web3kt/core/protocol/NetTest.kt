package org.web3kt.core.protocol

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class NetTest {
    private val net = Net(Fixture.jsonRpc)

    @Test
    fun enode(): Unit = runBlocking { }

    @Test
    fun listening(): Unit = runBlocking { net.listening() }

    @Test
    fun peerCount(): Unit = runBlocking { net.peerCount() }

    @Test
    fun services(): Unit = runBlocking { }

    @Test
    fun version(): Unit = runBlocking { net.version() }
}
