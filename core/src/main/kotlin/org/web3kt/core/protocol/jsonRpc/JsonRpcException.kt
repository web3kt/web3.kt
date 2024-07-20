package org.web3kt.core.protocol.jsonRpc

import org.web3kt.core.protocol.jsonRpc.dto.Error

class JsonRpcException(
    error: Error?,
) : RuntimeException(error.toString())
