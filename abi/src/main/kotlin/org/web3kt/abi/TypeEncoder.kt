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
import org.web3kt.abi.type.DynamicArray
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
import org.web3kt.abi.type.StaticArray
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.Type
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

@OptIn(ExperimentalStdlibApi::class)
object TypeEncoder {
    fun encode(types: List<Type<*>>): ByteArray {
        val builder = TypeBuilder(types.size, TypeBuilder.getOffset(types))
        types.forEach { builder.append(it) }
        return builder.build()
    }

    fun encode(type: Type<*>): ByteArray {
        val encoded =
            when (type) {
                is AddressType -> type.encode()
                is BoolType -> type.encode()
                is Bytes10Type -> type.encode()
                is Bytes11Type -> type.encode()
                is Bytes12Type -> type.encode()
                is Bytes13Type -> type.encode()
                is Bytes14Type -> type.encode()
                is Bytes15Type -> type.encode()
                is Bytes16Type -> type.encode()
                is Bytes17Type -> type.encode()
                is Bytes18Type -> type.encode()
                is Bytes19Type -> type.encode()
                is Bytes1Type -> type.encode()
                is Bytes20Type -> type.encode()
                is Bytes21Type -> type.encode()
                is Bytes22Type -> type.encode()
                is Bytes23Type -> type.encode()
                is Bytes24Type -> type.encode()
                is Bytes25Type -> type.encode()
                is Bytes26Type -> type.encode()
                is Bytes27Type -> type.encode()
                is Bytes28Type -> type.encode()
                is Bytes29Type -> type.encode()
                is Bytes2Type -> type.encode()
                is Bytes30Type -> type.encode()
                is Bytes31Type -> type.encode()
                is Bytes32Type -> type.encode()
                is Bytes3Type -> type.encode()
                is Bytes4Type -> type.encode()
                is Bytes5Type -> type.encode()
                is Bytes6Type -> type.encode()
                is Bytes7Type -> type.encode()
                is Bytes8Type -> type.encode()
                is Bytes9Type -> type.encode()
                is BytesType -> type.encode()
                is DynamicArray<*> -> type.encode()
                is Int104Type -> type.encode()
                is Int112Type -> type.encode()
                is Int120Type -> type.encode()
                is Int128Type -> type.encode()
                is Int136Type -> type.encode()
                is Int144Type -> type.encode()
                is Int152Type -> type.encode()
                is Int160Type -> type.encode()
                is Int168Type -> type.encode()
                is Int16Type -> type.encode()
                is Int176Type -> type.encode()
                is Int184Type -> type.encode()
                is Int192Type -> type.encode()
                is Int200Type -> type.encode()
                is Int208Type -> type.encode()
                is Int216Type -> type.encode()
                is Int224Type -> type.encode()
                is Int232Type -> type.encode()
                is Int240Type -> type.encode()
                is Int248Type -> type.encode()
                is Int24Type -> type.encode()
                is Int256Type -> type.encode()
                is Int32Type -> type.encode()
                is Int40Type -> type.encode()
                is Int48Type -> type.encode()
                is Int56Type -> type.encode()
                is Int64Type -> type.encode()
                is Int72Type -> type.encode()
                is Int80Type -> type.encode()
                is Int88Type -> type.encode()
                is Int8Type -> type.encode()
                is Int96Type -> type.encode()
                is IntType -> type.encode()
                is StaticArray<*> -> type.encode()
                is StringType -> type.encode()
                is Uint104Type -> type.encode()
                is Uint112Type -> type.encode()
                is Uint120Type -> type.encode()
                is Uint128Type -> type.encode()
                is Uint136Type -> type.encode()
                is Uint144Type -> type.encode()
                is Uint152Type -> type.encode()
                is Uint160Type -> type.encode()
                is Uint168Type -> type.encode()
                is Uint16Type -> type.encode()
                is Uint176Type -> type.encode()
                is Uint184Type -> type.encode()
                is Uint192Type -> type.encode()
                is Uint200Type -> type.encode()
                is Uint208Type -> type.encode()
                is Uint216Type -> type.encode()
                is Uint224Type -> type.encode()
                is Uint232Type -> type.encode()
                is Uint240Type -> type.encode()
                is Uint248Type -> type.encode()
                is Uint24Type -> type.encode()
                is Uint256Type -> type.encode()
                is Uint32Type -> type.encode()
                is Uint40Type -> type.encode()
                is Uint48Type -> type.encode()
                is Uint56Type -> type.encode()
                is Uint64Type -> type.encode()
                is Uint72Type -> type.encode()
                is Uint80Type -> type.encode()
                is Uint88Type -> type.encode()
                is Uint8Type -> type.encode()
                is Uint96Type -> type.encode()
                is UintType -> type.encode()
            }
        return encoded
    }

    private fun AddressType.encode(): ByteArray = value.removePrefix("0x").hexToByteArray().padStart()

    private fun BoolType.encode(): ByteArray {
        val byte = if (value) 0x01.toByte() else 0x00.toByte()
        return byteArrayOf(byte).padStart()
    }

    private fun Bytes10Type.encode(): ByteArray = value.padEnd()

    private fun Bytes11Type.encode(): ByteArray = value.padEnd()

    private fun Bytes12Type.encode(): ByteArray = value.padEnd()

    private fun Bytes13Type.encode(): ByteArray = value.padEnd()

    private fun Bytes14Type.encode(): ByteArray = value.padEnd()

    private fun Bytes15Type.encode(): ByteArray = value.padEnd()

    private fun Bytes16Type.encode(): ByteArray = value.padEnd()

    private fun Bytes17Type.encode(): ByteArray = value.padEnd()

    private fun Bytes18Type.encode(): ByteArray = value.padEnd()

    private fun Bytes19Type.encode(): ByteArray = value.padEnd()

    private fun Bytes1Type.encode(): ByteArray = value.padEnd()

    private fun Bytes20Type.encode(): ByteArray = value.padEnd()

    private fun Bytes21Type.encode(): ByteArray = value.padEnd()

    private fun Bytes22Type.encode(): ByteArray = value.padEnd()

    private fun Bytes23Type.encode(): ByteArray = value.padEnd()

    private fun Bytes24Type.encode(): ByteArray = value.padEnd()

    private fun Bytes25Type.encode(): ByteArray = value.padEnd()

    private fun Bytes26Type.encode(): ByteArray = value.padEnd()

    private fun Bytes27Type.encode(): ByteArray = value.padEnd()

    private fun Bytes28Type.encode(): ByteArray = value.padEnd()

    private fun Bytes29Type.encode(): ByteArray = value.padEnd()

    private fun Bytes2Type.encode(): ByteArray = value.padEnd()

    private fun Bytes30Type.encode(): ByteArray = value.padEnd()

    private fun Bytes31Type.encode(): ByteArray = value.padEnd()

    private fun Bytes32Type.encode(): ByteArray = value.padEnd()

    private fun Bytes3Type.encode(): ByteArray = value.padEnd()

    private fun Bytes4Type.encode(): ByteArray = value.padEnd()

    private fun Bytes5Type.encode(): ByteArray = value.padEnd()

    private fun Bytes6Type.encode(): ByteArray = value.padEnd()

    private fun Bytes7Type.encode(): ByteArray = value.padEnd()

    private fun Bytes8Type.encode(): ByteArray = value.padEnd()

    private fun Bytes9Type.encode(): ByteArray = value.padEnd()

    private fun BytesType.encode(): ByteArray = value.padEndWithSize()

    private fun DynamicArray<*>.encode(): ByteArray {
        val builder = TypeBuilder(size + 1)
        builder.append(Uint256Type(size.toBigInteger()))
        value.forEach { builder.append(it) }
        return builder.build()
    }

    private fun Int104Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int112Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int120Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int128Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int136Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int144Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int152Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int160Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int168Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int16Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int176Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int184Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int192Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int200Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int208Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int216Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int224Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int232Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int240Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int248Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int24Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int256Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int32Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int40Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int48Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int56Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int64Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int72Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int80Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int88Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int8Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun Int96Type.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun IntType.encode(): ByteArray {
        val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()
        return value.toByteArray().padStart(padByte)
    }

    private fun StaticArray<*>.encode(): ByteArray {
        val builder = TypeBuilder(size)
        value.forEach { builder.append(it) }
        return builder.build()
    }

    private fun StringType.encode(): ByteArray = value.toByteArray().padEndWithSize()

    private fun Uint104Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint112Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint120Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint128Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint136Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint144Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint152Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint160Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint168Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint16Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint176Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint184Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint192Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint200Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint208Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint216Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint224Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint232Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint240Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint248Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint24Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint256Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint32Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint40Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint48Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint56Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint64Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint72Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint80Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint88Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint8Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun Uint96Type.encode(): ByteArray = value.toByteArray().padStart()

    private fun UintType.encode(): ByteArray = value.toByteArray().padStart()
}
