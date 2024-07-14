package org.web3kt.core.protocol

import kotlinx.coroutines.runBlocking
import org.web3kt.core.protocol.dto.Tag
import org.web3kt.core.protocol.dto.TraceFilterOption
import org.web3kt.core.protocol.dto.TraceOption
import kotlin.test.Test

class TraceTest {
    private val trace: Trace = Trace(Fixture.jsonRpc)

    private val blockNumber = 35540.toBigInteger()
    private val blockHash = "0xac423be3c9eacd72f1a71874b0585beee7208962ebc5286aeda3d9c75f015079"
    private val tag = Tag.LATEST
    private val address = "0x8023cd890da3496370ff5a9df9acd6c76cfbcf5c"
    private val contract = "0xb531770bf535bb1bce4c26dd02c9beb10c889b73"
    private val transactionHash = "0x2ad59ab049825253df03c685f2fe9a6c3e8ae6e01eb1a81cfb84c2e0d521a804"
    private val traceOptions: List<TraceOption> = TraceOption.entries

    @Test
    fun blockByNumber(): Unit = runBlocking { trace.block(blockNumber) }

    fun blockByTag(): Unit = runBlocking { trace.block(tag) }

    @Test
    fun call(): Unit = runBlocking { }

    @Test
    fun testCall(): Unit = runBlocking { }

    @Test
    fun callMany(): Unit = runBlocking { }

    @Test
    fun filter(): Unit =
        runBlocking {
            val option =
                TraceFilterOption(
                    fromBlock = blockNumber,
                    toBlock = blockNumber,
                    fromAddress = address,
                    toAddress = contract,
                )
            trace.filter(option)
        }

    @Test
    fun get(): Unit = runBlocking { trace.get(transactionHash, listOf(0)) }

    @Test
    fun rawTransaction(): Unit = runBlocking { }

    @Test
    fun replayBlockTransactions(): Unit = runBlocking { }

    @Test
    fun testReplayBlockTransactions(): Unit = runBlocking { }

    @Test
    fun transaction(): Unit = runBlocking { trace.transaction(transactionHash) }
}
