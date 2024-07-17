package org.web3kt.abi

import org.web3kt.abi.type.AddressType
import org.web3kt.abi.type.BoolType
import org.web3kt.abi.type.Bytes10Type
import org.web3kt.abi.type.Bytes11Type
import org.web3kt.abi.type.Bytes12Type
import org.web3kt.abi.type.Bytes32Type
import org.web3kt.abi.type.BytesType
import org.web3kt.abi.type.DynamicArray
import org.web3kt.abi.type.Int104Type
import org.web3kt.abi.type.Int112Type
import org.web3kt.abi.type.Int256Type
import org.web3kt.abi.type.StaticArray
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.Uint104Type
import org.web3kt.abi.type.Uint256Type
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalStdlibApi::class)
class TypeEncoderTest {
    @Test
    fun encode() {
        val types =
            listOf(
                DynamicArray(
                    Bytes32Type::class,
                    listOf(
                        Bytes32Type("a3663fb46581988ec773c70141c0cff477fc216c56bd4118fc0e9143f7203db7".hexToByteArray()),
                        Bytes32Type("794513d2bdb74332ca05b893bd46beb2c15ccc77f9b56d6501c32e0e1de07946".hexToByteArray()),
                        Bytes32Type("20686c568d05864aa8b74edec90981a6d540b03c49c021a676c3b999fe5d5d8a".hexToByteArray()),
                    ),
                ),
                Int256Type((-1).toBigInteger()),
                StringType("Hello, World"),
                Uint256Type(1.toBigInteger()),
                BytesType(
                    "a04333460f27a100a8e4d4d65d3f02e738917c5b2b7bca617f672c5c80e2fd68a8fddaf05bb38de2a7e0231b1616d08abbb90aedc6eec2fb7c7bfed0a06eeb41"
                        .hexToByteArray(),
                ),
                Bytes32Type("d4df5dbf1e6675fe99c4254750a64cc795901bb13f5dfd9b56e9009a9942e463".hexToByteArray()),
                BoolType(true),
                StaticArray(
                    Uint256Type::class,
                    listOf(
                        Uint256Type(42.toBigInteger()),
                        Uint256Type(43.toBigInteger()),
                        Uint256Type(44.toBigInteger()),
                    ),
                ),
            )
        val expected =
            "0000000000000000000000000000000000000000000000000000000000000140ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff00000000000000000000000000000000000000000000000000000000000001c000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000200d4df5dbf1e6675fe99c4254750a64cc795901bb13f5dfd9b56e9009a9942e4630000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000002a000000000000000000000000000000000000000000000000000000000000002b000000000000000000000000000000000000000000000000000000000000002c0000000000000000000000000000000000000000000000000000000000000003a3663fb46581988ec773c70141c0cff477fc216c56bd4118fc0e9143f7203db7794513d2bdb74332ca05b893bd46beb2c15ccc77f9b56d6501c32e0e1de0794620686c568d05864aa8b74edec90981a6d540b03c49c021a676c3b999fe5d5d8a000000000000000000000000000000000000000000000000000000000000000c48656c6c6f2c20576f726c6400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000040a04333460f27a100a8e4d4d65d3f02e738917c5b2b7bca617f672c5c80e2fd68a8fddaf05bb38de2a7e0231b1616d08abbb90aedc6eec2fb7c7bfed0a06eeb41"
        val actual = TypeEncoder.encode(types).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeAddressType() {
        val value = Random.Default.nextBytes(20)
        val expected = value.padStart().toHexString()
        val actual = TypeEncoder.encode(AddressType("0x" + value.toHexString())).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeBoolType() {
        val value = Random.nextBoolean()
        val expected = value.toByteArray().padStart().toHexString()
        val actual = TypeEncoder.encode(BoolType(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeBytes10Type() {
        val value = Random.Default.nextBytes(10)
        val expected = value.padEnd().toHexString()
        val actual = TypeEncoder.encode(Bytes10Type(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeBytes11Type() {
        val value = Random.Default.nextBytes(11)
        val expected = value.padEnd().toHexString()
        val actual = TypeEncoder.encode(Bytes11Type(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeBytes12Type() {
        val value = Random.Default.nextBytes(12)
        val expected = value.padEnd().toHexString()
        val actual = TypeEncoder.encode(Bytes12Type(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeBytesType() {
        val value = "2b18df6e6f6350357378d3968cab15b2b3355fa149f5ecf7b62f50091376ce3f".hexToByteArray()
        val expected =
            "00000000000000000000000000000000000000000000000000000000000000202b18df6e6f6350357378d3968cab15b2b3355fa149f5ecf7b62f50091376ce3f"
        val actual = TypeEncoder.encode(BytesType(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun `encodeBytesType - long bytes`() {
        val value =
            "70b6972f6154f5afc863adbeb4efd543c95c9e5b26271030561e77f9b4ee70470cfef89f6ce9dce3e29e1e39cbad66915f8af4a4bf50ab050000000000000000"
                .hexToByteArray()
        val expected =
            "000000000000000000000000000000000000000000000000000000000000004070b6972f6154f5afc863adbeb4efd543c95c9e5b26271030561e77f9b4ee70470cfef89f6ce9dce3e29e1e39cbad66915f8af4a4bf50ab050000000000000000"
        val actual = TypeEncoder.encode(BytesType(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeDynamicArray() {
        val value =
            DynamicArray(
                Uint256Type::class,
                listOf(
                    Uint256Type(1.toBigInteger()),
                    Uint256Type(2.toBigInteger()),
                    Uint256Type(3.toBigInteger()),
                    Uint256Type(4.toBigInteger()),
                ),
            )
        val expected =
            "00000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000000000000000000000000000000004"
        val actual = TypeEncoder.encode(value).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeInt104Type() {
        val value = (-1).toBigInteger()
        val expected = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
        val actual = TypeEncoder.encode(Int104Type(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeInt112Type() {
        val value = 1.toBigInteger()
        val expected = "0000000000000000000000000000000000000000000000000000000000000001"
        val actual = TypeEncoder.encode(Int112Type(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeStaticArray() {
        val value =
            StaticArray(
                Uint256Type::class,
                listOf(
                    Uint256Type(1.toBigInteger()),
                    Uint256Type(2.toBigInteger()),
                    Uint256Type(3.toBigInteger()),
                    Uint256Type(4.toBigInteger()),
                ),
            )
        val expected =
            "0000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000000000000000000000000000000004"
        val actual = TypeEncoder.encode(value).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeStringType() {
        val value = "Hello, World!"
        val expected =
            "000000000000000000000000000000000000000000000000000000000000000d48656c6c6f2c20576f726c642100000000000000000000000000000000000000"
        val actual = TypeEncoder.encode(StringType(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun `encodeStringType - long string`() {
        val value =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. Volutpat odio facilisis mauris sit. Tincidunt nunc pulvinar sapien et ligula ullamcorper. Proin fermentum leo vel orci porta non. Scelerisque eu ultrices vitae auctor eu augue ut lectus arcu. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Sed felis eget velit aliquet sagittis id consectetur. Magnis dis parturient montes nascetur ridiculus mus mauris vitae."
        val expected =
            "00000000000000000000000000000000000000000000000000000000000002344c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73656374657475722061646970697363696e6720656c69742c2073656420646f20656975736d6f642074656d706f7220696e6369646964756e74207574206c61626f726520657420646f6c6f7265206d61676e6120616c697175612e20457469616d206469676e697373696d206469616d207175697320656e696d206c6f626f72746973207363656c65726973717565206665726d656e74756d206475692e20566f6c7574706174206f64696f20666163696c69736973206d6175726973207369742e2054696e636964756e74206e756e632070756c76696e61722073617069656e206574206c6967756c6120756c6c616d636f727065722e2050726f696e206665726d656e74756d206c656f2076656c206f72636920706f727461206e6f6e2e205363656c6572697371756520657520756c74726963657320766974616520617563746f72206575206175677565207574206c656374757320617263752e2041632074696e636964756e742076697461652073656d7065722071756973206c6563747573206e756c6c6120617420766f6c7574706174206469616d2e205365642066656c697320656765742076656c697420616c697175657420736167697474697320696420636f6e73656374657475722e204d61676e6973206469732070617274757269656e74206d6f6e746573206e61736365747572207269646963756c7573206d7573206d61757269732076697461652e000000000000000000000000"
        val actual = TypeEncoder.encode(StringType(value)).toHexString()
        assertEquals(expected, actual)
    }

    @Test
    fun encodeUint104Type() {
        val value = 1.toBigInteger()
        val expected = "0000000000000000000000000000000000000000000000000000000000000001"
        val actual = TypeEncoder.encode(Uint104Type(value)).toHexString()
        assertEquals(expected, actual)
    }
}
