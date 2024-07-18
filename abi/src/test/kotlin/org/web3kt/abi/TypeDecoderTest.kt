package org.web3kt.abi

import org.web3kt.abi.type.AddressType
import org.web3kt.abi.type.BoolType
import org.web3kt.abi.type.Bytes10Type
import org.web3kt.abi.type.BytesType
import org.web3kt.abi.type.Int104Type
import org.web3kt.abi.type.Int112Type
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.Uint104Type
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalStdlibApi::class)
class TypeDecoderTest {
    @Test
    fun decodeAddressTypeTest() {
        val value = "00000000000000000000000041c0cff477fc216c56bd4118fc0e9143f7203db7".hexToByteArray()
        val expected = AddressType("0x41c0cff477fc216c56bd4118fc0e9143f7203db7")
        val actual = TypeDecoder.decode(value, AddressType::class)
        assertEquals(expected, actual)
    }

    @Test
    fun decodeBoolTypeTest() {
        val value = "0000000000000000000000000000000000000000000000000000000000000001".hexToByteArray()
        val expected = BoolType(true)
        val actual = TypeDecoder.decode(value, BoolType::class)
        assertEquals(expected, actual)
    }

    @Test
    fun decodeBytes10TypeTest() {
        val value = "0102030405060708091000000000000000000000000000000000000000000001".hexToByteArray()
        val expected = Bytes10Type("01020304050607080910".hexToByteArray())
        val actual = TypeDecoder.decode(value, Bytes10Type::class)
        assertEquals(expected.toString(), actual.toString())
    }

    @Test
    fun decodeBytesTypeTest() {
        val value =
            "00000000000000000000000000000000000000000000000000000000000000202b18df6e6f6350357378d3968cab15b2b3355fa149f5ecf7b62f50091376ce3f"
                .hexToByteArray()
        val expected = BytesType("2b18df6e6f6350357378d3968cab15b2b3355fa149f5ecf7b62f50091376ce3f".hexToByteArray())
        val actual = TypeDecoder.decode(value, BytesType::class)
        assertEquals(expected.toString(), actual.toString())
    }

    @Test
    fun `decodeBytesTypeTest - long bytes`() {
        val value =
            "000000000000000000000000000000000000000000000000000000000000004070b6972f6154f5afc863adbeb4efd543c95c9e5b26271030561e77f9b4ee70470cfef89f6ce9dce3e29e1e39cbad66915f8af4a4bf50ab050000000000000000"
                .hexToByteArray()
        val expected =
            BytesType(
                "70b6972f6154f5afc863adbeb4efd543c95c9e5b26271030561e77f9b4ee70470cfef89f6ce9dce3e29e1e39cbad66915f8af4a4bf50ab050000000000000000"
                    .hexToByteArray(),
            )
        val actual = TypeDecoder.decode(value, BytesType::class)
        assertEquals(expected.toString(), actual.toString())
    }

    // @Test
    //  fun decodeDynamicArrayTypeTest() {
    //     val value =
    //         "00000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000000000000000000000000000000004"
    //             .hexToByteArray()
    //     val expected =
    //         DynamicArrayType(
    //             Uint256Type::class,
    //             listOf(
    //                 Uint256Type(1.toBigInteger()),
    //                 Uint256Type(2.toBigInteger()),
    //                 Uint256Type(3.toBigInteger()),
    //                 Uint256Type(4.toBigInteger()),
    //             ),
    //         )
    //     val actual = TypeDecoder.decode(value, DynamicArrayType::class)
    //     assertEquals(expected, actual)
    // }

    @Test
    fun decodeInt104TypeTest() {
        val value = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff".hexToByteArray()
        val expected = Int104Type((-1).toBigInteger())
        val actual = TypeDecoder.decode(value, Int104Type::class)
        assertEquals(expected, actual)
    }

    @Test
    fun decodeInt112TypeTest() {
        val value = "0000000000000000000000000000000000000000000000000000000000000001".hexToByteArray()
        val expected = Int112Type(1.toBigInteger())
        val actual = TypeDecoder.decode(value, Int112Type::class)
        assertEquals(expected, actual)
    }

    // @Test
    //  fun decodeStaticArrayTypeTest() {
    //     val value =
    //         "0000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000000000000000000000000000000004"
    //             .hexToByteArray()
    //     val expected =
    //         StaticArrayType(
    //             Uint256Type::class,
    //             listOf(
    //                 Uint256Type(1.toBigInteger()),
    //                 Uint256Type(2.toBigInteger()),
    //                 Uint256Type(3.toBigInteger()),
    //                 Uint256Type(4.toBigInteger()),
    //             ),
    //         )
    //     val actual = TypeDecoder.decode(value, StaticArrayType::class)
    //     assertEquals(expected, actual)
    // }

    @Test
    fun decodeStringTypeTest() {
        val value =
            "000000000000000000000000000000000000000000000000000000000000000d48656c6c6f2c20576f726c642100000000000000000000000000000000000000"
                .hexToByteArray()
        val expected = StringType("Hello, World!")
        val actual = TypeDecoder.decode(value, StringType::class)
        assertEquals(expected, actual)
    }

    @Test
    fun `decodeStringTypeTest - long string`() {
        val value =
            "00000000000000000000000000000000000000000000000000000000000002344c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73656374657475722061646970697363696e6720656c69742c2073656420646f20656975736d6f642074656d706f7220696e6369646964756e74207574206c61626f726520657420646f6c6f7265206d61676e6120616c697175612e20457469616d206469676e697373696d206469616d207175697320656e696d206c6f626f72746973207363656c65726973717565206665726d656e74756d206475692e20566f6c7574706174206f64696f20666163696c69736973206d6175726973207369742e2054696e636964756e74206e756e632070756c76696e61722073617069656e206574206c6967756c6120756c6c616d636f727065722e2050726f696e206665726d656e74756d206c656f2076656c206f72636920706f727461206e6f6e2e205363656c6572697371756520657520756c74726963657320766974616520617563746f72206575206175677565207574206c656374757320617263752e2041632074696e636964756e742076697461652073656d7065722071756973206c6563747573206e756c6c6120617420766f6c7574706174206469616d2e205365642066656c697320656765742076656c697420616c697175657420736167697474697320696420636f6e73656374657475722e204d61676e6973206469732070617274757269656e74206d6f6e746573206e61736365747572207269646963756c7573206d7573206d61757269732076697461652e000000000000000000000000"
                .hexToByteArray()
        val expected =
            StringType(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. Volutpat odio facilisis mauris sit. Tincidunt nunc pulvinar sapien et ligula ullamcorper. Proin fermentum leo vel orci porta non. Scelerisque eu ultrices vitae auctor eu augue ut lectus arcu. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Sed felis eget velit aliquet sagittis id consectetur. Magnis dis parturient montes nascetur ridiculus mus mauris vitae.",
            )
        val actual = TypeDecoder.decode(value, StringType::class)
        assertEquals(expected, actual)
    }

    @Test
    fun decodeUint104TypeTest() {
        val value = "0000000000000000000000000000000000000000000000000000000000000001".hexToByteArray()
        val expected = Uint104Type(1.toBigInteger())
        val actual = TypeDecoder.decode(value, Uint104Type::class)
        assertEquals(expected, actual)
    }
}
