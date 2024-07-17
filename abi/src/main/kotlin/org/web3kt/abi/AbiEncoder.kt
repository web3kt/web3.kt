// package org.web3kt.abi
//
// import org.web3kt.abi.type.Type
//
// @OptIn(ExperimentalStdlibApi::class)
// object AbiEncoder {
//     fun encode(vararg types: Type): String {
//         val byteArrays = types.map { it.toByteArray() }
//         val byteArrayMap =
//             types
//                 .mapIndexed { index, type ->
//                     if (type is BytesType || type is StringType) {
//                         index to ByteArray(32)
//                     } else {
//                         index to byteArrays[index]
//                     }
//                 }.toMap()
//                 .toMutableMap()
//
//         types.forEachIndexed { index, type ->
//             if (type is BytesType || type is StringType) {
//                 val nextIndex = byteArrayMap.keys.max() + 1
//                 val size = byteArrayMap.values.sumOf { it.size }
//                 byteArrayMap[index] = size.toByteArray().padStart()
//                 byteArrayMap[nextIndex] = byteArrays[index]
//             }
//         }
//
//         return byteArrayMap
//             .toList()
//             .sortedBy { it.first }
//             .map { it.second }
//             .fold(byteArrayOf()) { acc, it -> acc + it }
//             .toHexString()
//     }
// }
