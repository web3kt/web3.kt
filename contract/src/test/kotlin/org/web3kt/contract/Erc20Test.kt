package org.web3kt.contract

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.web3kt.core.Web3
import kotlin.test.Test

class Erc20Test {
    val web3 =
        Web3 {
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
            defaultRequest { url("https://testnet.directional.io") }
        }

    @Test
    fun name() {
        val erc20 =
            Erc20(
                web3,
                "0x9c7339697914476182eb6a52f2fa2db2b051d173",
                "0x8023cd890da3496370ff5a9df9acd6c76cfbcf5c",
            )
        runBlocking { println(erc20.name()) }
    }

    @Test
    fun eip712Domain() {
        val erc20 =
            Erc20(
                web3,
                "0x9c7339697914476182eb6a52f2fa2db2b051d173",
                "0x8023cd890da3496370ff5a9df9acd6c76cfbcf5c",
            )
        runBlocking { println(erc20.eip712Domain()) }
    }
}
