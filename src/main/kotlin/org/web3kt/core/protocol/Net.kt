package org.web3kt.core.protocol

import org.web3kt.core.hexToBigInteger
import org.web3kt.core.protocol.jsonRpc.JsonRpc
import java.math.BigInteger

@OptIn(ExperimentalStdlibApi::class)
class Net(
    val jsonRpc: JsonRpc,
) {
    suspend fun enode(): String = jsonRpc.call("net_enode")

    suspend fun listening(): Boolean = jsonRpc.call("net_listening")

    suspend fun peerCount(): BigInteger = jsonRpc.call<String>("net_peerCount").hexToBigInteger()

    suspend fun services(): Boolean = throw NotImplementedError("net_services not implemented yet")

    suspend fun version(): Int = jsonRpc.call("net_version")
}
