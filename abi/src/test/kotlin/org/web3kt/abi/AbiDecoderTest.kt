// package org.web3kt.abi
//
// import kotlin.test.Test
// import kotlin.test.assertEquals
//
// @OptIn(ExperimentalStdlibApi::class)
// class AbiDecoderTest {
//     @Test
//     fun decode() {
//         val data =
//             "0x0f0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000e000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000dee0000000000000000000000009c7339697914476182eb6a52f2fa2db2b051d173000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001600000000000000000000000000000000000000000000000000000000000000008496e766573746172000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000131000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
//         val types = AbiDecoder.decode(data, "bytes1", "string", "string", "uint256", "address", "bytes32", "bytes")
//         println(types)
//     }
//
//     @Test
//     fun encode_decode() {
//         val actual =
//             listOf(
//                 AddressType("0x9c7339697914476182eb6a52f2fa2db2b051d173"),
//                 StringType(
//                     "This is very long text which has size over 256 bytes. In order to generate very long text, I use Lorem Ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor purus justo, ac viverra magna mollis id. Nunc vulputate posuere lacinia. Mauris eleifend nisi massa, eu tempus justo sodales at. Etiam varius ligula in rutrum maximus. Mauris ac ligula ut purus venenatis vestibulum. Nulla dignissim pharetra aliquet. Maecenas pharetra et justo ut consequat. In hac habitasse platea dictumst. Nulla pulvinar libero at enim elementum, at tincidunt enim bibendum. Nunc sodales enim eget tempor semper. Donec non nunc malesuada, aliquet lacus et, elementum mi.",
//                 ),
//                 Int256Type(42.toBigInteger()),
//                 StringType("Hello, World!"),
//                 Bytes1Type(byteArrayOf(0x42.toByte())),
//             )
//
//         val result = AbiEncoder.encode(*actual.toTypedArray())
//
//         val expected = AbiDecoder.decode(result, "address", "string", "int256", "string", "bytes1")
//
//         expected.zip(actual).forEach { (e, a) ->
//             assertEquals(e.toString(), a.toString())
//         }
//     }
// }
