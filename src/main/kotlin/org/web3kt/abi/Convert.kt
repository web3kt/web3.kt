package org.web3kt.abi

import org.web3kt.abi.type.AddressType
import org.web3kt.abi.type.BoolType
import org.web3kt.abi.type.Bytes10Type
import org.web3kt.abi.type.Bytes11Type
import org.web3kt.abi.type.Bytes12Type
import org.web3kt.abi.type.Bytes13Type
import org.web3kt.abi.type.Bytes14Type
import org.web3kt.abi.type.Bytes15Type
import org.web3kt.abi.type.Bytes16Type
import org.web3kt.abi.type.Bytes17Type
import org.web3kt.abi.type.Bytes18Type
import org.web3kt.abi.type.Bytes19Type
import org.web3kt.abi.type.Bytes1Type
import org.web3kt.abi.type.Bytes20Type
import org.web3kt.abi.type.Bytes21Type
import org.web3kt.abi.type.Bytes22Type
import org.web3kt.abi.type.Bytes23Type
import org.web3kt.abi.type.Bytes24Type
import org.web3kt.abi.type.Bytes25Type
import org.web3kt.abi.type.Bytes26Type
import org.web3kt.abi.type.Bytes27Type
import org.web3kt.abi.type.Bytes28Type
import org.web3kt.abi.type.Bytes29Type
import org.web3kt.abi.type.Bytes2Type
import org.web3kt.abi.type.Bytes30Type
import org.web3kt.abi.type.Bytes31Type
import org.web3kt.abi.type.Bytes32Type
import org.web3kt.abi.type.Bytes3Type
import org.web3kt.abi.type.Bytes4Type
import org.web3kt.abi.type.Bytes5Type
import org.web3kt.abi.type.Bytes6Type
import org.web3kt.abi.type.Bytes7Type
import org.web3kt.abi.type.Bytes8Type
import org.web3kt.abi.type.Bytes9Type
import org.web3kt.abi.type.BytesType
import org.web3kt.abi.type.Int104Type
import org.web3kt.abi.type.Int112Type
import org.web3kt.abi.type.Int120Type
import org.web3kt.abi.type.Int128Type
import org.web3kt.abi.type.Int136Type
import org.web3kt.abi.type.Int144Type
import org.web3kt.abi.type.Int152Type
import org.web3kt.abi.type.Int160Type
import org.web3kt.abi.type.Int168Type
import org.web3kt.abi.type.Int16Type
import org.web3kt.abi.type.Int176Type
import org.web3kt.abi.type.Int184Type
import org.web3kt.abi.type.Int192Type
import org.web3kt.abi.type.Int200Type
import org.web3kt.abi.type.Int208Type
import org.web3kt.abi.type.Int216Type
import org.web3kt.abi.type.Int224Type
import org.web3kt.abi.type.Int232Type
import org.web3kt.abi.type.Int240Type
import org.web3kt.abi.type.Int248Type
import org.web3kt.abi.type.Int24Type
import org.web3kt.abi.type.Int256Type
import org.web3kt.abi.type.Int32Type
import org.web3kt.abi.type.Int40Type
import org.web3kt.abi.type.Int48Type
import org.web3kt.abi.type.Int56Type
import org.web3kt.abi.type.Int64Type
import org.web3kt.abi.type.Int72Type
import org.web3kt.abi.type.Int80Type
import org.web3kt.abi.type.Int88Type
import org.web3kt.abi.type.Int8Type
import org.web3kt.abi.type.Int96Type
import org.web3kt.abi.type.IntType
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.Uint104Type
import org.web3kt.abi.type.Uint112Type
import org.web3kt.abi.type.Uint120Type
import org.web3kt.abi.type.Uint128Type
import org.web3kt.abi.type.Uint136Type
import org.web3kt.abi.type.Uint144Type
import org.web3kt.abi.type.Uint152Type
import org.web3kt.abi.type.Uint160Type
import org.web3kt.abi.type.Uint168Type
import org.web3kt.abi.type.Uint16Type
import org.web3kt.abi.type.Uint176Type
import org.web3kt.abi.type.Uint184Type
import org.web3kt.abi.type.Uint192Type
import org.web3kt.abi.type.Uint200Type
import org.web3kt.abi.type.Uint208Type
import org.web3kt.abi.type.Uint216Type
import org.web3kt.abi.type.Uint224Type
import org.web3kt.abi.type.Uint232Type
import org.web3kt.abi.type.Uint240Type
import org.web3kt.abi.type.Uint248Type
import org.web3kt.abi.type.Uint24Type
import org.web3kt.abi.type.Uint256Type
import org.web3kt.abi.type.Uint32Type
import org.web3kt.abi.type.Uint40Type
import org.web3kt.abi.type.Uint48Type
import org.web3kt.abi.type.Uint56Type
import org.web3kt.abi.type.Uint64Type
import org.web3kt.abi.type.Uint72Type
import org.web3kt.abi.type.Uint80Type
import org.web3kt.abi.type.Uint88Type
import org.web3kt.abi.type.Uint8Type
import org.web3kt.abi.type.Uint96Type
import org.web3kt.abi.type.UintType
import kotlin.reflect.KClass

object Convert {
    fun typeClassToType(kClass: KClass<*>): String =
        when (kClass) {
            AddressType::class -> "address"
            StringType::class -> "string"
            BoolType::class -> "bool"
            IntType::class -> "int"
            Int8Type::class -> "int8"
            Int16Type::class -> "int16"
            Int24Type::class -> "int24"
            Int32Type::class -> "int32"
            Int40Type::class -> "int40"
            Int48Type::class -> "int48"
            Int56Type::class -> "int56"
            Int64Type::class -> "int64"
            Int72Type::class -> "int72"
            Int80Type::class -> "int80"
            Int88Type::class -> "int88"
            Int96Type::class -> "int96"
            Int104Type::class -> "int104"
            Int112Type::class -> "int112"
            Int120Type::class -> "int120"
            Int128Type::class -> "int128"
            Int136Type::class -> "int136"
            Int144Type::class -> "int144"
            Int152Type::class -> "int152"
            Int160Type::class -> "int160"
            Int168Type::class -> "int168"
            Int176Type::class -> "int176"
            Int184Type::class -> "int184"
            Int192Type::class -> "int192"
            Int200Type::class -> "int200"
            Int208Type::class -> "int208"
            Int216Type::class -> "int216"
            Int224Type::class -> "int224"
            Int232Type::class -> "int232"
            Int240Type::class -> "int240"
            Int248Type::class -> "int248"
            Int256Type::class -> "int256"
            UintType::class -> "uint"
            Uint8Type::class -> "uint8"
            Uint16Type::class -> "uint16"
            Uint24Type::class -> "uint24"
            Uint32Type::class -> "uint32"
            Uint40Type::class -> "uint40"
            Uint48Type::class -> "uint48"
            Uint56Type::class -> "uint56"
            Uint64Type::class -> "uint64"
            Uint72Type::class -> "uint72"
            Uint80Type::class -> "uint80"
            Uint88Type::class -> "uint88"
            Uint96Type::class -> "uint96"
            Uint104Type::class -> "uint104"
            Uint112Type::class -> "uint112"
            Uint120Type::class -> "uint120"
            Uint128Type::class -> "uint128"
            Uint136Type::class -> "uint136"
            Uint144Type::class -> "uint144"
            Uint152Type::class -> "uint152"
            Uint160Type::class -> "uint160"
            Uint168Type::class -> "uint168"
            Uint176Type::class -> "uint176"
            Uint184Type::class -> "uint184"
            Uint192Type::class -> "uint192"
            Uint200Type::class -> "uint200"
            Uint208Type::class -> "uint208"
            Uint216Type::class -> "uint216"
            Uint224Type::class -> "uint224"
            Uint232Type::class -> "uint232"
            Uint240Type::class -> "uint240"
            Uint248Type::class -> "uint248"
            Uint256Type::class -> "uint256"
            BytesType::class -> "bytes"
            Bytes1Type::class -> "bytes1"
            Bytes2Type::class -> "bytes2"
            Bytes3Type::class -> "bytes3"
            Bytes4Type::class -> "bytes4"
            Bytes5Type::class -> "bytes5"
            Bytes6Type::class -> "bytes6"
            Bytes7Type::class -> "bytes7"
            Bytes8Type::class -> "bytes8"
            Bytes9Type::class -> "bytes9"
            Bytes10Type::class -> "bytes10"
            Bytes11Type::class -> "bytes11"
            Bytes12Type::class -> "bytes12"
            Bytes13Type::class -> "bytes13"
            Bytes14Type::class -> "bytes14"
            Bytes15Type::class -> "bytes15"
            Bytes16Type::class -> "bytes16"
            Bytes17Type::class -> "bytes17"
            Bytes18Type::class -> "bytes18"
            Bytes19Type::class -> "bytes19"
            Bytes20Type::class -> "bytes20"
            Bytes21Type::class -> "bytes21"
            Bytes22Type::class -> "bytes22"
            Bytes23Type::class -> "bytes23"
            Bytes24Type::class -> "bytes24"
            Bytes25Type::class -> "bytes25"
            Bytes26Type::class -> "bytes26"
            Bytes27Type::class -> "bytes27"
            Bytes28Type::class -> "bytes28"
            Bytes29Type::class -> "bytes29"
            Bytes30Type::class -> "bytes30"
            Bytes31Type::class -> "bytes31"
            Bytes32Type::class -> "bytes32"
            else -> throw IllegalArgumentException("Unsupported type ${javaClass.name}")
        }
}
