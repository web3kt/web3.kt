package org.web3kt.poet

import java.math.BigInteger
import kotlin.reflect.KClass

object Util {
    fun getKClass(type: String): KClass<*> =
        when (type) {
            "address",
            "string",
            -> String::class

            "bool" -> Boolean::class

            "int8",
            "int16",
            "uint8",
            "int24",
            "int32",
            "uint16",
            "uint24",
            "int40",
            "int48",
            "int56",
            "int64",
            "uint32",
            "uint40",
            "uint48",
            "uint56",
            "int",
            "int72",
            "int80",
            "int88",
            "int96",
            "int104",
            "int112",
            "int120",
            "int128",
            "int136",
            "int144",
            "int152",
            "int160",
            "int168",
            "int176",
            "int184",
            "int192",
            "int200",
            "int208",
            "int216",
            "int224",
            "int232",
            "int240",
            "int248",
            "int256",
            "uint",
            "uint64",
            "uint72",
            "uint80",
            "uint88",
            "uint96",
            "uint104",
            "uint112",
            "uint120",
            "uint128",
            "uint136",
            "uint144",
            "uint152",
            "uint160",
            "uint168",
            "uint176",
            "uint184",
            "uint192",
            "uint200",
            "uint208",
            "uint216",
            "uint224",
            "uint232",
            "uint240",
            "uint248",
            "uint256",
            -> BigInteger::class

            "bytes",
            "bytes1",
            "bytes2",
            "bytes3",
            "bytes4",
            "bytes5",
            "bytes6",
            "bytes7",
            "bytes8",
            "bytes9",
            "bytes10",
            "bytes11",
            "bytes12",
            "bytes13",
            "bytes14",
            "bytes15",
            "bytes16",
            "bytes17",
            "bytes18",
            "bytes19",
            "bytes20",
            "bytes21",
            "bytes22",
            "bytes23",
            "bytes24",
            "bytes25",
            "bytes26",
            "bytes27",
            "bytes28",
            "bytes29",
            "bytes30",
            "bytes31",
            "bytes32",
            -> ByteArray::class

            else -> throw IllegalArgumentException("Unsupported type $type")
        }

    fun getTypeClassName(type: String): String =
        when (type) {
            "address" -> "AddressType"
            "string" -> "StringType"
            "bool" -> "BoolType"
            "int" -> "IntType"
            "int8" -> "Int8Type"
            "int16" -> "Int16Type"
            "int24" -> "Int24Type"
            "int32" -> "Int32Type"
            "int40" -> "Int40Type"
            "int48" -> "Int48Type"
            "int56" -> "Int56Type"
            "int64" -> "Int64Type"
            "int72" -> "Int72Type"
            "int80" -> "Int80Type"
            "int88" -> "Int88Type"
            "int96" -> "Int96Type"
            "int104" -> "Int104Type"
            "int112" -> "Int112Type"
            "int120" -> "Int120Type"
            "int128" -> "Int128Type"
            "int136" -> "Int136Type"
            "int144" -> "Int144Type"
            "int152" -> "Int152Type"
            "int160" -> "Int160Type"
            "int168" -> "Int168Type"
            "int176" -> "Int176Type"
            "int184" -> "Int184Type"
            "int192" -> "Int192Type"
            "int200" -> "Int200Type"
            "int208" -> "Int208Type"
            "int216" -> "Int216Type"
            "int224" -> "Int224Type"
            "int232" -> "Int232Type"
            "int240" -> "Int240Type"
            "int248" -> "Int248Type"
            "int256" -> "Int256Type"
            "uint" -> "UintType"
            "uint8" -> "Uint8Type"
            "uint16" -> "Uint16Type"
            "uint24" -> "Uint24Type"
            "uint32" -> "Uint32Type"
            "uint40" -> "Uint40Type"
            "uint48" -> "Uint48Type"
            "uint56" -> "Uint56Type"
            "uint64" -> "Uint64Type"
            "uint72" -> "Uint72Type"
            "uint80" -> "Uint80Type"
            "uint88" -> "Uint88Type"
            "uint96" -> "Uint96Type"
            "uint104" -> "Uint104Type"
            "uint112" -> "Uint112Type"
            "uint120" -> "Uint120Type"
            "uint128" -> "Uint128Type"
            "uint136" -> "Uint136Type"
            "uint144" -> "Uint144Type"
            "uint152" -> "Uint152Type"
            "uint160" -> "Uint160Type"
            "uint168" -> "Uint168Type"
            "uint176" -> "Uint176Type"
            "uint184" -> "Uint184Type"
            "uint192" -> "Uint192Type"
            "uint200" -> "Uint200Type"
            "uint208" -> "Uint208Type"
            "uint216" -> "Uint216Type"
            "uint224" -> "Uint224Type"
            "uint232" -> "Uint232Type"
            "uint240" -> "Uint240Type"
            "uint248" -> "Uint248Type"
            "uint256" -> "Uint256Type"
            "bytes" -> "BytesType"
            "bytes1" -> "Bytes1Type"
            "bytes2" -> "Bytes2Type"
            "bytes3" -> "Bytes3Type"
            "bytes4" -> "Bytes4Type"
            "bytes5" -> "Bytes5Type"
            "bytes6" -> "Bytes6Type"
            "bytes7" -> "Bytes7Type"
            "bytes8" -> "Bytes8Type"
            "bytes9" -> "Bytes9Type"
            "bytes10" -> "Bytes10Type"
            "bytes11" -> "Bytes11Type"
            "bytes12" -> "Bytes12Type"
            "bytes13" -> "Bytes13Type"
            "bytes14" -> "Bytes14Type"
            "bytes15" -> "Bytes15Type"
            "bytes16" -> "Bytes16Type"
            "bytes17" -> "Bytes17Type"
            "bytes18" -> "Bytes18Type"
            "bytes19" -> "Bytes19Type"
            "bytes20" -> "Bytes20Type"
            "bytes21" -> "Bytes21Type"
            "bytes22" -> "Bytes22Type"
            "bytes23" -> "Bytes23Type"
            "bytes24" -> "Bytes24Type"
            "bytes25" -> "Bytes25Type"
            "bytes26" -> "Bytes26Type"
            "bytes27" -> "Bytes27Type"
            "bytes28" -> "Bytes28Type"
            "bytes29" -> "Bytes29Type"
            "bytes30" -> "Bytes30Type"
            "bytes31" -> "Bytes31Type"
            "bytes32" -> "Bytes32Type"
            else -> throw IllegalArgumentException("Unsupported type $type")
        }

    val typeClasses =
        listOf(
            "AddressType",
            "BoolType",
            "StringType",
            "BytesType",
            "IntType",
            "Int8Type",
            "Int16Type",
            "Int24Type",
            "Int32Type",
            "Int40Type",
            "Int48Type",
            "Int56Type",
            "Int64Type",
            "Int72Type",
            "Int80Type",
            "Int88Type",
            "Int96Type",
            "Int104Type",
            "Int112Type",
            "Int120Type",
            "Int128Type",
            "Int136Type",
            "Int144Type",
            "Int152Type",
            "Int160Type",
            "Int168Type",
            "Int176Type",
            "Int184Type",
            "Int192Type",
            "Int200Type",
            "Int208Type",
            "Int216Type",
            "Int224Type",
            "Int232Type",
            "Int240Type",
            "Int248Type",
            "Int256Type",
            "UintType",
            "Uint8Type",
            "Uint16Type",
            "Uint24Type",
            "Uint32Type",
            "Uint40Type",
            "Uint48Type",
            "Uint56Type",
            "Uint64Type",
            "Uint72Type",
            "Uint80Type",
            "Uint88Type",
            "Uint96Type",
            "Uint104Type",
            "Uint112Type",
            "Uint120Type",
            "Uint128Type",
            "Uint136Type",
            "Uint144Type",
            "Uint152Type",
            "Uint160Type",
            "Uint168Type",
            "Uint176Type",
            "Uint184Type",
            "Uint192Type",
            "Uint200Type",
            "Uint208Type",
            "Uint216Type",
            "Uint224Type",
            "Uint232Type",
            "Uint240Type",
            "Uint248Type",
            "Uint256Type",
            "Bytes1Type",
            "Bytes2Type",
            "Bytes3Type",
            "Bytes4Type",
            "Bytes5Type",
            "Bytes6Type",
            "Bytes7Type",
            "Bytes8Type",
            "Bytes9Type",
            "Bytes10Type",
            "Bytes11Type",
            "Bytes12Type",
            "Bytes13Type",
            "Bytes14Type",
            "Bytes15Type",
            "Bytes16Type",
            "Bytes17Type",
            "Bytes18Type",
            "Bytes19Type",
            "Bytes20Type",
            "Bytes21Type",
            "Bytes22Type",
            "Bytes23Type",
            "Bytes24Type",
            "Bytes25Type",
            "Bytes26Type",
            "Bytes27Type",
            "Bytes28Type",
            "Bytes29Type",
            "Bytes30Type",
            "Bytes31Type",
            "Bytes32Type",
            "StaticArray<*>",
            "DynamicArray<*>",
        ).sorted()
    val types =
        listOf(
            "address",
            "bool",
            "string",
            "bytes",
            "int",
            "int8",
            "int16",
            "int24",
            "int32",
            "int40",
            "int48",
            "int56",
            "int64",
            "int72",
            "int80",
            "int88",
            "int96",
            "int104",
            "int112",
            "int120",
            "int128",
            "int136",
            "int144",
            "int152",
            "int160",
            "int168",
            "int176",
            "int184",
            "int192",
            "int200",
            "int208",
            "int216",
            "int224",
            "int232",
            "int240",
            "int248",
            "int256",
            "uint",
            "uint8",
            "uint16",
            "uint24",
            "uint32",
            "uint40",
            "uint48",
            "uint56",
            "uint64",
            "uint72",
            "uint80",
            "uint88",
            "uint96",
            "uint104",
            "uint112",
            "uint120",
            "uint128",
            "uint136",
            "uint144",
            "uint152",
            "uint160",
            "uint168",
            "uint176",
            "uint184",
            "uint192",
            "uint200",
            "uint208",
            "uint216",
            "uint224",
            "uint232",
            "uint240",
            "uint248",
            "uint256",
            "bytes1",
            "bytes2",
            "bytes3",
            "bytes4",
            "bytes5",
            "bytes6",
            "bytes7",
            "bytes8",
            "bytes9",
            "bytes10",
            "bytes11",
            "bytes12",
            "bytes13",
            "bytes14",
            "bytes15",
            "bytes16",
            "bytes17",
            "bytes18",
            "bytes19",
            "bytes20",
            "bytes21",
            "bytes22",
            "bytes23",
            "bytes24",
            "bytes25",
            "bytes26",
            "bytes27",
            "bytes28",
            "bytes29",
            "bytes30",
            "bytes31",
            "bytes32",
        ).sorted()
}
