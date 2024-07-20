package org.web3kt.core.protocol

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.web3kt.core.protocol.jsonRpc.JsonRpc

object Fixture {
    val jsonRpc: JsonRpc =
        JsonRpc {
            install(ContentNegotiation) {
                json(
                    Json {
                        encodeDefaults = true
                        isLenient = true
                        allowSpecialFloatingPointValues = true
                        allowStructuredMapKeys = true
                        prettyPrint = false
                        useArrayPolymorphism = false
                        ignoreUnknownKeys = true
                    },
                )
            }
            defaultRequest { url("https://ethereum-rpc.directional.io") }
        }
}
