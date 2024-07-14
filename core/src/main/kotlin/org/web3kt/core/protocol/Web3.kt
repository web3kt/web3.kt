package org.web3kt.core.protocol

import org.web3kt.core.protocol.jsonRpc.JsonRpc

class Web3(
    val jsonRpc: JsonRpc,
) {
    suspend fun clientVersion(): String = jsonRpc.call("web3_clientVersion")

    suspend fun sha3(data: String): String = jsonRpc.call("web3_sha3", data)
}
