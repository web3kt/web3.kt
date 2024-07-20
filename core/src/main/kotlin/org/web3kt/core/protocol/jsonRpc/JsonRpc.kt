package org.web3kt.core.protocol.jsonRpc

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive
import org.web3kt.core.protocol.jsonRpc.dto.Request
import org.web3kt.core.protocol.jsonRpc.dto.Response

open class JsonRpc(
    block: HttpClientConfig<CIOEngineConfig>.() -> Unit = { },
) {
    var id: Long = 0

    val httpClient =
        HttpClient(CIO, block).config {
            install(ContentNegotiation) { json() }
            defaultRequest { contentType(ContentType.Application.Json) }
        }

    open fun requestBuilder(builder: HttpRequestBuilder) {}

    suspend inline fun <reified T> call(
        method: String,
        vararg params: Any?,
    ): T = call(Request(method, JsonArray(params.map { it.toJsonElement() }), JsonPrimitive(++id)))

    suspend inline fun <reified T, reified R> call(request: Request<R>): T =
        httpClient
            .post {
                requestBuilder(this)
                setBody(request)
            }.body<Response<T>>()
            .let { it.result ?: throw JsonRpcException(it.error) }

    fun Any?.toJsonElement(): JsonElement =
        when (this) {
            is Boolean -> JsonPrimitive(this)
            is Number -> JsonPrimitive(this)
            is String -> JsonPrimitive(this)
            is JsonElement -> this
            is List<*> -> JsonArray(this.map { it.toJsonElement() })
            null -> JsonNull
            else -> throw IllegalArgumentException("Unsupported type: ${this::class}")
        }
}
