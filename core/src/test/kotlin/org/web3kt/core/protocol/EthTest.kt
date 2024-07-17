package org.web3kt.core.protocol

import kotlinx.coroutines.runBlocking
import org.web3kt.core.protocol.dto.FilterOption
import org.web3kt.core.protocol.dto.Tag
import org.web3kt.core.protocol.dto.TransactionCall
import kotlin.test.Test
import kotlin.test.assertEquals

class EthTest {
    private val eth = Eth(Fixture.jsonRpc)
    private val blockNumber = 22.toBigInteger()
    private val blockHash = "0x4b0af6e07dcdc2e4c16ec2a4383cf9666ab29fb8a9d3a02f6d4002d19f1fe1e3"
    private val tag = Tag.LATEST
    private val address = "0x8023CD890dA3496370ff5A9Df9ACD6C76CFbCf5c"
    private val contract = "0xe3b1f2a9abaf551f6a9f4ec46f04af694a4276c5"
    private val transactionHash = "0x05ea30b1ae8b1dc68cf556739bd5a87abc6387111a601c2d5010afeef31b169d"

    @Test
    fun accounts(): Unit = runBlocking { eth.accounts() }

    @Test
    fun blobBaseFee(): Unit = runBlocking { eth.blobBaseFee() }

    @Test
    fun blockNumber(): Unit = runBlocking { eth.blockNumber() }

    @Test
    fun callByHash(): Unit =
        runBlocking {
            val call =
                TransactionCall(
                    from = address,
                    to = address,
                    value = 1.toBigInteger(),
                )
            eth.call(call, blockHash)
        }

    @Test
    fun callByNumber(): Unit =
        runBlocking {
            val call =
                TransactionCall(
                    from = address,
                    to = address,
                    value = 1.toBigInteger(),
                )
            eth.call(call, blockNumber)
        }

    @Test
    fun callByTag(): Unit =
        runBlocking {
            val call =
                TransactionCall(
                    from = address,
                    to = address,
                    value = 1.toBigInteger(),
                )
            eth.call(call, tag)
        }

    @Test
    fun chainId(): Unit =
        runBlocking {
            val actual = eth.chainId()
            assertEquals(3566.toBigInteger(), actual)
        }

    @Test
    fun coinbase(): Unit = runBlocking { }

    @Test
    fun createAccessListByNumber(): Unit = runBlocking { }

    @Test
    fun createAccessListByTag(): Unit = runBlocking { }

    @Test
    fun estimateGas(): Unit =
        runBlocking {
            val call =
                TransactionCall(
                    from = address,
                    to = address,
                    value = 1.toBigInteger(),
                )
            val actual = eth.estimateGas(call)
            assertEquals(21_000.toBigInteger(), actual)
        }

    @Test
    fun feeHistory(): Unit = runBlocking { }

    @Test
    fun testFeeHistory(): Unit = runBlocking { }

    @Test
    fun gasPrice(): Unit = runBlocking { eth.gasPrice() }

    @Test
    fun getBalance(): Unit = runBlocking { eth.getBalance(address, blockHash) }

    @Test
    fun testGetBalance(): Unit = runBlocking { eth.getBalance(address, blockNumber) }

    @Test
    fun testGetBalance1(): Unit = runBlocking { eth.getBalance(address, tag) }

    @Test
    fun getBlockReceipts(): Unit = runBlocking { eth.getBlockReceipts(tag) }

    @Test
    fun testGetBlockReceipts(): Unit = runBlocking { eth.getBlockReceipts(blockNumber) }

    @Test
    fun getBlockTransactionCount(): Unit = runBlocking { eth.getBlockTransactionCount(blockHash) }

    @Test
    fun testGetBlockTransactionCount(): Unit = runBlocking { eth.getBlockTransactionCount(blockNumber) }

    @Test
    fun testGetBlockTransactionCount1(): Unit = runBlocking { eth.getBlockTransactionCount(tag) }

    @Test
    fun getCode(): Unit = runBlocking { eth.getCode(contract, blockHash) }

    @Test
    fun testGetCode(): Unit = runBlocking { eth.getCode(contract, blockNumber) }

    @Test
    fun testGetCode1(): Unit = runBlocking { eth.getCode(contract, tag) }

    @Test
    fun getFilterChanges(): Unit = runBlocking { }

    @Test
    fun getFilterLogs(): Unit = runBlocking { }

    @Test
    fun getLogs(): Unit =
        runBlocking {
            val filterOption =
                FilterOption(
                    fromBlock = blockNumber,
                    toBlock = blockNumber,
                    address = contract,
                )
            val actual = eth.getLogs(filterOption).size
            assertEquals(3, actual)
        }

    @Test
    fun getMinerData(): Unit = runBlocking { }

    @Test
    fun testGetMinerData(): Unit = runBlocking { }

    @Test
    fun testGetMinerData1(): Unit = runBlocking { }

    @Test
    fun getProof(): Unit = runBlocking { }

    @Test
    fun getStorageAt(): Unit = runBlocking { }

    @Test
    fun getTransaction(): Unit =
        runBlocking {
            val actual = eth.getTransaction(blockHash, 0).hash
            assertEquals(transactionHash, actual)
        }

    @Test
    fun testGetTransaction(): Unit =
        runBlocking {
            val actual = eth.getTransaction(blockNumber, 0).hash
            assertEquals(transactionHash, actual)
        }

    @Test
    fun testGetTransaction1(): Unit =
        runBlocking {
            // eth.getTransaction(tag, 1.toBigInteger())
        }

    @Test
    fun testGetTransaction2(): Unit =
        runBlocking {
            val actual = eth.getTransaction(transactionHash).hash
            assertEquals(transactionHash, actual)
        }

    @Test
    fun getTransactionCount(): Unit =
        runBlocking {
            val expected = 2.toBigInteger()
            val actual = eth.getTransactionCount(address, blockHash)
            assertEquals(expected, actual)
        }

    @Test
    fun testGetTransactionCount(): Unit =
        runBlocking {
            val expected = 2.toBigInteger()
            val actual = eth.getTransactionCount(address, blockNumber)
            assertEquals(expected, actual)
        }

    @Test
    fun testGetTransactionCount1(): Unit =
        runBlocking {
            eth.getTransactionCount(address, tag)
        }

    @Test
    fun getTransactionReceipt(): Unit =
        runBlocking {
            val actual = eth.getTransactionReceipt(transactionHash).transactionHash
            assertEquals(transactionHash, actual)
        }

    @Test
    fun getUncle(): Unit = runBlocking { }

    @Test
    fun testGetUncle(): Unit = runBlocking { }

    @Test
    fun testGetUncle1(): Unit = runBlocking { }

    @Test
    fun getUncleCount(): Unit =
        runBlocking {
            val actual = eth.getUncleCount(blockHash)
            assertEquals(0.toBigInteger(), actual)
        }

    @Test
    fun testGetUncleCount(): Unit =
        runBlocking {
            val actual = eth.getUncleCount(blockNumber)
            assertEquals(0.toBigInteger(), actual)
        }

    @Test
    fun testGetUncleCount1(): Unit =
        runBlocking {
            eth.getUncleCount(tag)
        }

    @Test
    fun getWork(): Unit = runBlocking { }

    @Test
    fun hashrate(): Unit = runBlocking { eth.hashrate() }

    @Test
    fun maxPriorityFeePerGas(): Unit = runBlocking { eth.maxPriorityFeePerGas() }

    @Test
    fun mining(): Unit = runBlocking { eth.mining() }

    @Test
    fun newBlockFilter(): Unit = runBlocking { eth.newBlockFilter() }

    @Test
    fun newFilter(): Unit =
        runBlocking {
            val filterOption =
                FilterOption(
                    fromBlock = blockNumber,
                    toBlock = blockNumber,
                    address = contract,
                )
            eth.newFilter(filterOption)
        }

    @Test
    fun newPendingTransactionFilter(): Unit = runBlocking { }

    @Test
    fun protocolVersion(): Unit = runBlocking { eth.protocolVersion() }

    @Test
    fun sendRawTransaction(): Unit = runBlocking { }

    @Test
    fun submitHashrate(): Unit = runBlocking { }

    @Test
    fun submitWork(): Unit = runBlocking { }

    @Test
    fun syncing(): Unit = runBlocking { }

    @Test
    fun uninstallFilter(): Unit = runBlocking { }
}
