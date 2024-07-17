// package org.web3kt.abi
//
// import kotlin.test.Test
// import kotlin.test.assertEquals
//
// class AbiEncoderTest {
//     @Test
//     fun encode() {
//         val expected =
//             "0000000000000000000000008023cd890da3496370ff5a9df9acd6c76cfbcf5c0000000000000000000000000000000000000000000000000de0b6b3a7640000"
//         val actual =
//             AbiEncoder.encode(
//                 AddressType("0x8023CD890dA3496370ff5A9Df9ACD6C76CFbCf5c"),
//                 Uint256Type(1000000000000000000.toBigInteger()),
//             )
//         assertEquals(expected, actual)
//     }
//
//     @Test
//     fun encode_empty() {
//         val expected = ""
//         val actual = AbiEncoder.encode()
//         assertEquals(expected, actual)
//     }
// }
