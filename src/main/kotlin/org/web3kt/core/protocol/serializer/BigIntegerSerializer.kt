package org.web3kt.core.protocol.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.web3kt.core.hexToBigInteger
import org.web3kt.core.toHexString
import java.math.BigInteger

typealias Integer =
    @Serializable(with = BigIntegerSerializer::class)
    BigInteger

@OptIn(ExperimentalStdlibApi::class)
object BigIntegerSerializer : KSerializer<BigInteger> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("java.math.BigInteger", PrimitiveKind.LONG)

    override fun serialize(
        encoder: Encoder,
        value: BigInteger,
    ) = encoder.encodeString(value.toHexString())

    override fun deserialize(decoder: Decoder): BigInteger = decoder.decodeString().hexToBigInteger()
}
