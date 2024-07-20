package org.web3kt.core.protocol

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.web3kt.core.protocol.dto.TxPoolFilter
import org.web3kt.core.protocol.dto.TxPoolPendingTransaction
import org.web3kt.core.protocol.dto.TxPoolStatistics
import org.web3kt.core.protocol.dto.TxPoolTransaction
import org.web3kt.core.protocol.jsonRpc.JsonRpc

class TxPool(
    val jsonRpc: JsonRpc,
) {
    suspend fun besuPendingTransactions(
        numResults: Int,
        fields: TxPoolFilter,
    ): List<TxPoolPendingTransaction> =
        jsonRpc.call(
            "txpool_besuPendingTransactions",
            numResults,
            Json.encodeToJsonElement(fields),
        )

    suspend fun besuStatistics(): TxPoolStatistics = jsonRpc.call("txpool_besuStatistics")

    suspend fun besuTransactions(): List<TxPoolTransaction> = jsonRpc.call("txpool_besuTransactions")
}
