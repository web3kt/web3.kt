package org.web3kt.core.protocol

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.web3kt.core.protocol.dto.Block
import org.web3kt.core.protocol.dto.CreateAccessList
import org.web3kt.core.protocol.dto.FilterOption
import org.web3kt.core.protocol.dto.Log
import org.web3kt.core.protocol.dto.MinerData
import org.web3kt.core.protocol.dto.Syncing
import org.web3kt.core.protocol.dto.Tag
import org.web3kt.core.protocol.dto.Transaction
import org.web3kt.core.protocol.dto.TransactionCall
import org.web3kt.core.protocol.dto.TransactionReceipt
import org.web3kt.core.protocol.jsonRpc.JsonRpc
import java.math.BigInteger

@OptIn(ExperimentalStdlibApi::class)
class Eth(
    val jsonRpc: JsonRpc,
) {
    suspend fun accounts(): List<String> = jsonRpc.call("eth_accounts")

    suspend fun blobBaseFee(): BigInteger = jsonRpc.call<String>("eth_blobBaseFee").hexToBigInteger()

    suspend fun blockNumber(): BigInteger = jsonRpc.call<String>("eth_blockNumber").hexToBigInteger()

    suspend fun call(
        call: TransactionCall,
        tag: Tag,
    ): String =
        jsonRpc.call(
            "eth_call",
            Json.encodeToJsonElement(call),
            tag.value,
        )

    suspend fun call(
        call: TransactionCall,
        blockNumber: BigInteger,
    ): String =
        jsonRpc.call(
            "eth_call",
            Json.encodeToJsonElement(call),
            blockNumber.toHexString(),
        )

    suspend fun call(
        call: TransactionCall,
        blockHash: String,
    ): String =
        jsonRpc.call(
            "eth_call",
            Json.encodeToJsonElement(call),
            blockHash,
        )

    suspend fun chainId(): BigInteger = jsonRpc.call<String>("eth_chainId").hexToBigInteger()

    suspend fun coinbase(): String = jsonRpc.call("eth_coinbase")

    suspend fun createAccessList(
        call: TransactionCall,
        tag: Tag,
    ): CreateAccessList =
        jsonRpc.call(
            "eth_createAccessList",
            Json.encodeToJsonElement(call),
            tag.value,
        )

    suspend fun createAccessList(
        call: TransactionCall,
        blockNumber: BigInteger,
    ): CreateAccessList =
        jsonRpc.call(
            "eth_createAccessList",
            Json.encodeToJsonElement(call),
            blockNumber.toHexString(),
        )

    suspend fun estimateGas(call: TransactionCall): BigInteger =
        jsonRpc
            .call<String>(
                "eth_estimateGas",
                Json.encodeToJsonElement(call),
            ).hexToBigInteger()

    suspend fun feeHistory(): Unit = throw NotImplementedError("eth_feeHistory not implemented yet")

    suspend fun gasPrice(): BigInteger = jsonRpc.call<String>("eth_gasPrice").hexToBigInteger()

    suspend fun getBalance(
        address: String,
        tag: Tag,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBalance",
                address,
                tag.value,
            ).hexToBigInteger()

    suspend fun getBalance(
        address: String,
        blockNumber: BigInteger,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBalance",
                address,
                blockNumber.toHexString(),
            ).hexToBigInteger()

    suspend fun getBalance(
        address: String,
        blockHash: String,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBalance",
                address,
                blockHash,
            ).hexToBigInteger()

    suspend inline fun <reified T> getBlock(hash: String): Block<T> =
        jsonRpc.call(
            "eth_getBlockByHash",
            hash,
            T::class.java.isAssignableFrom(Transaction::class.java),
        )

    suspend inline fun <reified T> getBlock(blockNumber: BigInteger): Block<T> =
        jsonRpc.call(
            "eth_getBlockByNumber",
            blockNumber.toHexString(),
            T::class.java.isAssignableFrom(Transaction::class.java),
        )

    suspend inline fun <reified T> getBlock(tag: Tag): Block<T> =
        jsonRpc.call(
            "eth_getBlockByNumber",
            tag.value,
            T::class.java.isAssignableFrom(Transaction::class.java),
        )

    suspend fun getBlockReceipts(blockNumber: BigInteger): List<TransactionReceipt> =
        jsonRpc.call(
            "eth_getBlockReceipts",
            blockNumber.toHexString(),
        )

    suspend fun getBlockReceipts(tag: Tag): List<TransactionReceipt> =
        jsonRpc.call(
            "eth_getBlockReceipts",
            tag.value,
        )

    suspend fun getBlockTransactionCount(hash: String): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBlockTransactionCountByHash",
                hash,
            ).hexToBigInteger()

    suspend fun getBlockTransactionCount(blockNumber: BigInteger): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBlockTransactionCountByNumber",
                blockNumber.toHexString(),
            ).hexToBigInteger()

    suspend fun getBlockTransactionCount(tag: Tag): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getBlockTransactionCountByNumber",
                tag.value,
            ).hexToBigInteger()

    suspend fun getCode(
        address: String,
        hash: String,
    ): String =
        jsonRpc.call<String>(
            "eth_getCode",
            address,
            hash,
        )

    suspend fun getCode(
        address: String,
        blockNumber: BigInteger,
    ): String =
        jsonRpc.call(
            "eth_getCode",
            address,
            blockNumber.toHexString(),
        )

    suspend fun getCode(
        address: String,
        tag: Tag,
    ): String =
        jsonRpc.call(
            "eth_getCode",
            address,
            tag.value,
        )

    suspend fun getFilterChanges(filterId: String): Unit = throw NotImplementedError("getFilterChanges not implemented yet")

    suspend fun getFilterLogs(filterId: String): List<Log> =
        jsonRpc.call(
            "eth_getFilterLogs",
            filterId,
        )

    suspend fun getLogs(filterOption: FilterOption): List<Log> =
        jsonRpc.call(
            "eth_getLogs",
            Json.encodeToJsonElement(filterOption),
        )

    suspend fun getMinerData(hash: String): MinerData =
        jsonRpc.call(
            "eth_getMinerDataByBlockHash",
            hash,
        )

    suspend fun getMinerData(blockNumber: BigInteger): MinerData =
        jsonRpc.call(
            "eth_getMinerDataByBlockNumber",
            blockNumber.toHexString(),
        )

    suspend fun getMinerData(tag: Tag): MinerData =
        jsonRpc.call(
            "eth_getMinerDataByBlockNumber",
            tag.value,
        )

    suspend fun getProof(): Unit = throw NotImplementedError("eth_getProof not implemented yet")

    suspend fun getStorageAt(): Unit = throw NotImplementedError("eth_getStorageAt not implemented yet")

    suspend fun getTransaction(
        block: String,
        index: BigInteger,
    ): Transaction =
        jsonRpc.call(
            "eth_getTransactionByBlockHashAndIndex",
            block,
            index.toHexString(),
        )

    suspend fun getTransaction(
        blockNumber: BigInteger,
        index: BigInteger,
    ): Transaction =
        jsonRpc.call(
            "eth_getTransactionByBlockNumberAndIndex",
            blockNumber.toHexString(),
            index.toHexString(),
        )

    suspend fun getTransaction(
        tag: Tag,
        index: BigInteger,
    ): Transaction =
        jsonRpc.call(
            "eth_getTransactionByBlockNumberAndIndex",
            tag.value,
            index.toHexString(),
        )

    suspend fun getTransaction(hash: String): Transaction =
        jsonRpc.call(
            "eth_getTransactionByHash",
            hash,
        )

    suspend fun getTransactionCount(
        address: String,
        blockHash: String,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getTransactionCount",
                address,
                blockHash,
            ).hexToBigInteger()

    suspend fun getTransactionCount(
        address: String,
        blockNumber: BigInteger,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getTransactionCount",
                address,
                blockNumber.toHexString(),
            ).hexToBigInteger()

    suspend fun getTransactionCount(
        address: String,
        tag: Tag,
    ): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getTransactionCount",
                address,
                tag.value,
            ).hexToBigInteger()

    suspend fun getTransactionReceipt(transaction: String): TransactionReceipt =
        jsonRpc.call(
            "eth_getTransactionReceipt",
            transaction,
        )

    suspend fun getUncle(
        block: String,
        uncleIndex: BigInteger,
    ): Block<String>? =
        jsonRpc.call(
            "eth_getUncleByBlockHashAndIndex",
            block,
            uncleIndex.toHexString(),
        )

    suspend fun getUncle(
        blockNumber: BigInteger,
        uncleIndex: BigInteger,
    ): Block<String>? =
        jsonRpc.call(
            "eth_getUncleByBlockNumberAndIndex",
            blockNumber.toHexString(),
            uncleIndex.toHexString(),
        )

    suspend fun getUncle(
        tag: Tag,
        uncleIndex: BigInteger,
    ): Block<String>? =
        jsonRpc.call(
            "eth_getUncleByBlockNumberAndIndex",
            tag.value,
            uncleIndex.toHexString(),
        )

    suspend fun getUncleCount(block: String): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getUncleCountByBlockHash",
                block,
            ).hexToBigInteger()

    suspend fun getUncleCount(blockNumber: BigInteger): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getUncleCountByBlockNumber",
                blockNumber.toHexString(),
            ).hexToBigInteger()

    suspend fun getUncleCount(tag: Tag): BigInteger =
        jsonRpc
            .call<String>(
                "eth_getUncleCountByBlockNumber",
                tag.value,
            ).hexToBigInteger()

    suspend fun getWork(): List<String> = jsonRpc.call<List<String>>("eth_getWork")

    suspend fun hashrate(): BigInteger = jsonRpc.call<String>("eth_hashrate").hexToBigInteger()

    suspend fun maxPriorityFeePerGas(): BigInteger = jsonRpc.call<String>("eth_maxPriorityFeePerGas").hexToBigInteger()

    suspend fun mining(): Boolean = jsonRpc.call("eth_mining")

    suspend fun newBlockFilter(): String = jsonRpc.call("eth_newBlockFilter")

    suspend fun newFilter(filterOption: FilterOption): String = jsonRpc.call("eth_newFilter", Json.encodeToJsonElement(filterOption))

    suspend fun newPendingTransactionFilter(): String = jsonRpc.call("eth_newPendingTransactionFilter")

    suspend fun protocolVersion(): String = jsonRpc.call("eth_protocolVersion")

    suspend fun sendRawTransaction(transaction: String): String = jsonRpc.call("eth_sendRawTransaction", transaction)

    suspend fun submitHashrate(): Unit = throw NotImplementedError("eth_submitHashrate not implemented yet")

    suspend fun submitWork(): Unit = throw NotImplementedError("eth_submitWork not implemented yet")

    suspend fun syncing(): Syncing = jsonRpc.call("eth_syncing")

    suspend fun uninstallFilter(filterId: String): Boolean = jsonRpc.call("eth_uninstallFilter", filterId)
}
