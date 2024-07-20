package org.web3kt.core

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIOEngineConfig
import org.web3kt.core.protocol.Eth
import org.web3kt.core.protocol.Net
import org.web3kt.core.protocol.Trace
import org.web3kt.core.protocol.TxPool
import org.web3kt.core.protocol.Web3
import org.web3kt.core.protocol.jsonRpc.JsonRpc

class Web3(
    block: HttpClientConfig<CIOEngineConfig>.() -> Unit = { },
) : JsonRpc(block) {
    val eth = Eth(this)
    val net = Net(this)
    val web3 = Web3(this)
    val txPool = TxPool(this)
    val trace = Trace(this)
}
