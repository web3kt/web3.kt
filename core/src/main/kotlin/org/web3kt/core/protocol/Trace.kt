package org.web3kt.core.protocol

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import org.web3kt.core.WEB3_HEX_FORMAT
import org.web3kt.core.protocol.dto.Tag
import org.web3kt.core.protocol.dto.TraceFilterOption
import org.web3kt.core.protocol.dto.TraceOption
import org.web3kt.core.protocol.dto.TransactionCall
import org.web3kt.core.protocol.dto.TransactionTrace
import org.web3kt.core.protocol.jsonRpc.JsonRpc
import org.web3kt.core.toHexString
import java.math.BigInteger

@OptIn(ExperimentalStdlibApi::class)
class Trace(
    val jsonRpc: JsonRpc,
) {
    suspend fun block(blockNumber: BigInteger): List<TransactionTrace> = jsonRpc.call("trace_block", blockNumber.toHexString())

    suspend fun block(tag: Tag): List<TransactionTrace> = jsonRpc.call("trace_block", tag.value)

    suspend fun call(
        call: TransactionCall,
        options: List<TraceOption>,
        blockNumber: BigInteger,
    ): JsonElement =
        jsonRpc.call(
            "trace_call",
            Json.encodeToJsonElement(call),
            options.map { it.value },
            blockNumber.toHexString(),
        )

    suspend fun call(
        call: TransactionCall,
        options: List<TraceOption>,
        tag: Tag,
    ): JsonElement =
        jsonRpc.call(
            "trace_call",
            Json.encodeToJsonElement(call),
            options.map { it.value },
            tag.value,
        )

    suspend fun callMany(): Boolean = throw NotImplementedError("trace_callMany not implemented yet")

    suspend fun filter(traceFilterOptions: TraceFilterOption): List<TransactionTrace> =
        jsonRpc.call("trace_filter", Json.encodeToJsonElement(traceFilterOptions))

    suspend fun get(
        transaction: String,
        indexPositions: List<Int>,
    ): TransactionTrace = jsonRpc.call("trace_get", transaction, indexPositions.map { it.toHexString(WEB3_HEX_FORMAT) })

    suspend fun rawTransaction(): Boolean = throw NotImplementedError("trace_rawTransaction not implemented yet")

    suspend fun replayBlockTransactions(): Boolean = throw NotImplementedError("trace_replayBlockTransactions not implemented yet")

    suspend fun transaction(transaction: String): List<TransactionTrace> = jsonRpc.call("trace_transaction", transaction)
}
