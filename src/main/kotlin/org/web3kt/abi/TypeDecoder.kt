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
import java.math.BigInteger
import kotlin.reflect.KClass

@OptIn(ExperimentalStdlibApi::class)
@Suppress("UNCHECKED_CAST")
object TypeDecoder {
    fun <T : Type<*>> decode(
        bytes: ByteArray,
        kClass: KClass<T>,
    ): T =
        when (kClass) {
            AddressType::class -> bytes.decodeAddressType() as T
            BoolType::class -> bytes.decodeBoolType() as T
            Bytes10Type::class -> bytes.decodeBytes10Type() as T
            Bytes11Type::class -> bytes.decodeBytes11Type() as T
            Bytes12Type::class -> bytes.decodeBytes12Type() as T
            Bytes13Type::class -> bytes.decodeBytes13Type() as T
            Bytes14Type::class -> bytes.decodeBytes14Type() as T
            Bytes15Type::class -> bytes.decodeBytes15Type() as T
            Bytes16Type::class -> bytes.decodeBytes16Type() as T
            Bytes17Type::class -> bytes.decodeBytes17Type() as T
            Bytes18Type::class -> bytes.decodeBytes18Type() as T
            Bytes19Type::class -> bytes.decodeBytes19Type() as T
            Bytes1Type::class -> bytes.decodeBytes1Type() as T
            Bytes20Type::class -> bytes.decodeBytes20Type() as T
            Bytes21Type::class -> bytes.decodeBytes21Type() as T
            Bytes22Type::class -> bytes.decodeBytes22Type() as T
            Bytes23Type::class -> bytes.decodeBytes23Type() as T
            Bytes24Type::class -> bytes.decodeBytes24Type() as T
            Bytes25Type::class -> bytes.decodeBytes25Type() as T
            Bytes26Type::class -> bytes.decodeBytes26Type() as T
            Bytes27Type::class -> bytes.decodeBytes27Type() as T
            Bytes28Type::class -> bytes.decodeBytes28Type() as T
            Bytes29Type::class -> bytes.decodeBytes29Type() as T
            Bytes2Type::class -> bytes.decodeBytes2Type() as T
            Bytes30Type::class -> bytes.decodeBytes30Type() as T
            Bytes31Type::class -> bytes.decodeBytes31Type() as T
            Bytes32Type::class -> bytes.decodeBytes32Type() as T
            Bytes3Type::class -> bytes.decodeBytes3Type() as T
            Bytes4Type::class -> bytes.decodeBytes4Type() as T
            Bytes5Type::class -> bytes.decodeBytes5Type() as T
            Bytes6Type::class -> bytes.decodeBytes6Type() as T
            Bytes7Type::class -> bytes.decodeBytes7Type() as T
            Bytes8Type::class -> bytes.decodeBytes8Type() as T
            Bytes9Type::class -> bytes.decodeBytes9Type() as T
            BytesType::class -> bytes.decodeBytesType() as T
            Int104Type::class -> bytes.decodeInt104Type() as T
            Int112Type::class -> bytes.decodeInt112Type() as T
            Int120Type::class -> bytes.decodeInt120Type() as T
            Int128Type::class -> bytes.decodeInt128Type() as T
            Int136Type::class -> bytes.decodeInt136Type() as T
            Int144Type::class -> bytes.decodeInt144Type() as T
            Int152Type::class -> bytes.decodeInt152Type() as T
            Int160Type::class -> bytes.decodeInt160Type() as T
            Int168Type::class -> bytes.decodeInt168Type() as T
            Int16Type::class -> bytes.decodeInt16Type() as T
            Int176Type::class -> bytes.decodeInt176Type() as T
            Int184Type::class -> bytes.decodeInt184Type() as T
            Int192Type::class -> bytes.decodeInt192Type() as T
            Int200Type::class -> bytes.decodeInt200Type() as T
            Int208Type::class -> bytes.decodeInt208Type() as T
            Int216Type::class -> bytes.decodeInt216Type() as T
            Int224Type::class -> bytes.decodeInt224Type() as T
            Int232Type::class -> bytes.decodeInt232Type() as T
            Int240Type::class -> bytes.decodeInt240Type() as T
            Int248Type::class -> bytes.decodeInt248Type() as T
            Int24Type::class -> bytes.decodeInt24Type() as T
            Int256Type::class -> bytes.decodeInt256Type() as T
            Int32Type::class -> bytes.decodeInt32Type() as T
            Int40Type::class -> bytes.decodeInt40Type() as T
            Int48Type::class -> bytes.decodeInt48Type() as T
            Int56Type::class -> bytes.decodeInt56Type() as T
            Int64Type::class -> bytes.decodeInt64Type() as T
            Int72Type::class -> bytes.decodeInt72Type() as T
            Int80Type::class -> bytes.decodeInt80Type() as T
            Int88Type::class -> bytes.decodeInt88Type() as T
            Int8Type::class -> bytes.decodeInt8Type() as T
            Int96Type::class -> bytes.decodeInt96Type() as T
            IntType::class -> bytes.decodeIntType() as T
            StringType::class -> bytes.decodeStringType() as T
            Uint104Type::class -> bytes.decodeUint104Type() as T
            Uint112Type::class -> bytes.decodeUint112Type() as T
            Uint120Type::class -> bytes.decodeUint120Type() as T
            Uint128Type::class -> bytes.decodeUint128Type() as T
            Uint136Type::class -> bytes.decodeUint136Type() as T
            Uint144Type::class -> bytes.decodeUint144Type() as T
            Uint152Type::class -> bytes.decodeUint152Type() as T
            Uint160Type::class -> bytes.decodeUint160Type() as T
            Uint168Type::class -> bytes.decodeUint168Type() as T
            Uint16Type::class -> bytes.decodeUint16Type() as T
            Uint176Type::class -> bytes.decodeUint176Type() as T
            Uint184Type::class -> bytes.decodeUint184Type() as T
            Uint192Type::class -> bytes.decodeUint192Type() as T
            Uint200Type::class -> bytes.decodeUint200Type() as T
            Uint208Type::class -> bytes.decodeUint208Type() as T
            Uint216Type::class -> bytes.decodeUint216Type() as T
            Uint224Type::class -> bytes.decodeUint224Type() as T
            Uint232Type::class -> bytes.decodeUint232Type() as T
            Uint240Type::class -> bytes.decodeUint240Type() as T
            Uint248Type::class -> bytes.decodeUint248Type() as T
            Uint24Type::class -> bytes.decodeUint24Type() as T
            Uint256Type::class -> bytes.decodeUint256Type() as T
            Uint32Type::class -> bytes.decodeUint32Type() as T
            Uint40Type::class -> bytes.decodeUint40Type() as T
            Uint48Type::class -> bytes.decodeUint48Type() as T
            Uint56Type::class -> bytes.decodeUint56Type() as T
            Uint64Type::class -> bytes.decodeUint64Type() as T
            Uint72Type::class -> bytes.decodeUint72Type() as T
            Uint80Type::class -> bytes.decodeUint80Type() as T
            Uint88Type::class -> bytes.decodeUint88Type() as T
            Uint8Type::class -> bytes.decodeUint8Type() as T
            Uint96Type::class -> bytes.decodeUint96Type() as T
            UintType::class -> bytes.decodeUintType() as T
            else -> throw IllegalArgumentException("Unsupported type ${kClass.simpleName}")
        }

    private fun ByteArray.decodeAddressType(): AddressType = AddressType("0x${takeLast(20).toByteArray().toHexString()}")

    private fun ByteArray.decodeBoolType(): BoolType = BoolType(last() == 0x01.toByte())

    private fun ByteArray.decodeBytes10Type(): Bytes10Type = Bytes10Type(take(10).toByteArray())

    private fun ByteArray.decodeBytes11Type(): Bytes11Type = Bytes11Type(take(11).toByteArray())

    private fun ByteArray.decodeBytes12Type(): Bytes12Type = Bytes12Type(take(12).toByteArray())

    private fun ByteArray.decodeBytes13Type(): Bytes13Type = Bytes13Type(take(13).toByteArray())

    private fun ByteArray.decodeBytes14Type(): Bytes14Type = Bytes14Type(take(14).toByteArray())

    private fun ByteArray.decodeBytes15Type(): Bytes15Type = Bytes15Type(take(15).toByteArray())

    private fun ByteArray.decodeBytes16Type(): Bytes16Type = Bytes16Type(take(16).toByteArray())

    private fun ByteArray.decodeBytes17Type(): Bytes17Type = Bytes17Type(take(17).toByteArray())

    private fun ByteArray.decodeBytes18Type(): Bytes18Type = Bytes18Type(take(18).toByteArray())

    private fun ByteArray.decodeBytes19Type(): Bytes19Type = Bytes19Type(take(19).toByteArray())

    private fun ByteArray.decodeBytes1Type(): Bytes1Type = Bytes1Type(take(1).toByteArray())

    private fun ByteArray.decodeBytes20Type(): Bytes20Type = Bytes20Type(take(20).toByteArray())

    private fun ByteArray.decodeBytes21Type(): Bytes21Type = Bytes21Type(take(21).toByteArray())

    private fun ByteArray.decodeBytes22Type(): Bytes22Type = Bytes22Type(take(22).toByteArray())

    private fun ByteArray.decodeBytes23Type(): Bytes23Type = Bytes23Type(take(23).toByteArray())

    private fun ByteArray.decodeBytes24Type(): Bytes24Type = Bytes24Type(take(24).toByteArray())

    private fun ByteArray.decodeBytes25Type(): Bytes25Type = Bytes25Type(take(25).toByteArray())

    private fun ByteArray.decodeBytes26Type(): Bytes26Type = Bytes26Type(take(26).toByteArray())

    private fun ByteArray.decodeBytes27Type(): Bytes27Type = Bytes27Type(take(27).toByteArray())

    private fun ByteArray.decodeBytes28Type(): Bytes28Type = Bytes28Type(take(28).toByteArray())

    private fun ByteArray.decodeBytes29Type(): Bytes29Type = Bytes29Type(take(29).toByteArray())

    private fun ByteArray.decodeBytes2Type(): Bytes2Type = Bytes2Type(take(2).toByteArray())

    private fun ByteArray.decodeBytes30Type(): Bytes30Type = Bytes30Type(take(30).toByteArray())

    private fun ByteArray.decodeBytes31Type(): Bytes31Type = Bytes31Type(take(31).toByteArray())

    private fun ByteArray.decodeBytes32Type(): Bytes32Type = Bytes32Type(take(32).toByteArray())

    private fun ByteArray.decodeBytes3Type(): Bytes3Type = Bytes3Type(take(3).toByteArray())

    private fun ByteArray.decodeBytes4Type(): Bytes4Type = Bytes4Type(take(4).toByteArray())

    private fun ByteArray.decodeBytes5Type(): Bytes5Type = Bytes5Type(take(5).toByteArray())

    private fun ByteArray.decodeBytes6Type(): Bytes6Type = Bytes6Type(take(6).toByteArray())

    private fun ByteArray.decodeBytes7Type(): Bytes7Type = Bytes7Type(take(7).toByteArray())

    private fun ByteArray.decodeBytes8Type(): Bytes8Type = Bytes8Type(take(8).toByteArray())

    private fun ByteArray.decodeBytes9Type(): Bytes9Type = Bytes9Type(take(9).toByteArray())

    private fun ByteArray.decodeBytesType(): BytesType {
        val size = BigInteger(take(32).toByteArray()).toInt()
        return BytesType(drop(32).take(size).toByteArray())
    }

    // private fun ByteArray.decodeDynamicArray(typeReference: TypeReference<*>): DynamicArrayType<*> {
    //     val value = drop(32).toList().chunked(32).map { decode(it.toByteArray(), typeReference.kClass) }
    //     return DynamicArrayType(typeReference.kClass, value)
    // }
    //
    // private fun ByteArray.decodeStaticArray(typeReference: TypeReference<*>): StaticArrayType<*> {
    //     val value = toList().chunked(32).map { decode(it.toByteArray(), typeReference.kClass) }
    //     return StaticArrayType(typeReference.kClass, value)
    // }

    private fun ByteArray.decodeInt104Type(): Int104Type = Int104Type(BigInteger(this))

    private fun ByteArray.decodeInt112Type(): Int112Type = Int112Type(BigInteger(this))

    private fun ByteArray.decodeInt120Type(): Int120Type = Int120Type(BigInteger(this))

    private fun ByteArray.decodeInt128Type(): Int128Type = Int128Type(BigInteger(this))

    private fun ByteArray.decodeInt136Type(): Int136Type = Int136Type(BigInteger(this))

    private fun ByteArray.decodeInt144Type(): Int144Type = Int144Type(BigInteger(this))

    private fun ByteArray.decodeInt152Type(): Int152Type = Int152Type(BigInteger(this))

    private fun ByteArray.decodeInt160Type(): Int160Type = Int160Type(BigInteger(this))

    private fun ByteArray.decodeInt168Type(): Int168Type = Int168Type(BigInteger(this))

    private fun ByteArray.decodeInt16Type(): Int16Type = Int16Type(BigInteger(this))

    private fun ByteArray.decodeInt176Type(): Int176Type = Int176Type(BigInteger(this))

    private fun ByteArray.decodeInt184Type(): Int184Type = Int184Type(BigInteger(this))

    private fun ByteArray.decodeInt192Type(): Int192Type = Int192Type(BigInteger(this))

    private fun ByteArray.decodeInt200Type(): Int200Type = Int200Type(BigInteger(this))

    private fun ByteArray.decodeInt208Type(): Int208Type = Int208Type(BigInteger(this))

    private fun ByteArray.decodeInt216Type(): Int216Type = Int216Type(BigInteger(this))

    private fun ByteArray.decodeInt224Type(): Int224Type = Int224Type(BigInteger(this))

    private fun ByteArray.decodeInt232Type(): Int232Type = Int232Type(BigInteger(this))

    private fun ByteArray.decodeInt240Type(): Int240Type = Int240Type(BigInteger(this))

    private fun ByteArray.decodeInt248Type(): Int248Type = Int248Type(BigInteger(this))

    private fun ByteArray.decodeInt24Type(): Int24Type = Int24Type(BigInteger(this))

    private fun ByteArray.decodeInt256Type(): Int256Type = Int256Type(BigInteger(this))

    private fun ByteArray.decodeInt32Type(): Int32Type = Int32Type(BigInteger(this))

    private fun ByteArray.decodeInt40Type(): Int40Type = Int40Type(BigInteger(this))

    private fun ByteArray.decodeInt48Type(): Int48Type = Int48Type(BigInteger(this))

    private fun ByteArray.decodeInt56Type(): Int56Type = Int56Type(BigInteger(this))

    private fun ByteArray.decodeInt64Type(): Int64Type = Int64Type(BigInteger(this))

    private fun ByteArray.decodeInt72Type(): Int72Type = Int72Type(BigInteger(this))

    private fun ByteArray.decodeInt80Type(): Int80Type = Int80Type(BigInteger(this))

    private fun ByteArray.decodeInt88Type(): Int88Type = Int88Type(BigInteger(this))

    private fun ByteArray.decodeInt8Type(): Int8Type = Int8Type(BigInteger(this))

    private fun ByteArray.decodeInt96Type(): Int96Type = Int96Type(BigInteger(this))

    private fun ByteArray.decodeIntType(): IntType = IntType(BigInteger(this))

    private fun ByteArray.decodeStringType(): StringType {
        val size = BigInteger(take(32).toByteArray()).toInt()
        return StringType(drop(32).take(size).toByteArray().toString(Charsets.UTF_8))
    }

    private fun ByteArray.decodeUint104Type(): Uint104Type = Uint104Type(BigInteger(this))

    private fun ByteArray.decodeUint112Type(): Uint112Type = Uint112Type(BigInteger(this))

    private fun ByteArray.decodeUint120Type(): Uint120Type = Uint120Type(BigInteger(this))

    private fun ByteArray.decodeUint128Type(): Uint128Type = Uint128Type(BigInteger(this))

    private fun ByteArray.decodeUint136Type(): Uint136Type = Uint136Type(BigInteger(this))

    private fun ByteArray.decodeUint144Type(): Uint144Type = Uint144Type(BigInteger(this))

    private fun ByteArray.decodeUint152Type(): Uint152Type = Uint152Type(BigInteger(this))

    private fun ByteArray.decodeUint160Type(): Uint160Type = Uint160Type(BigInteger(this))

    private fun ByteArray.decodeUint168Type(): Uint168Type = Uint168Type(BigInteger(this))

    private fun ByteArray.decodeUint16Type(): Uint16Type = Uint16Type(BigInteger(this))

    private fun ByteArray.decodeUint176Type(): Uint176Type = Uint176Type(BigInteger(this))

    private fun ByteArray.decodeUint184Type(): Uint184Type = Uint184Type(BigInteger(this))

    private fun ByteArray.decodeUint192Type(): Uint192Type = Uint192Type(BigInteger(this))

    private fun ByteArray.decodeUint200Type(): Uint200Type = Uint200Type(BigInteger(this))

    private fun ByteArray.decodeUint208Type(): Uint208Type = Uint208Type(BigInteger(this))

    private fun ByteArray.decodeUint216Type(): Uint216Type = Uint216Type(BigInteger(this))

    private fun ByteArray.decodeUint224Type(): Uint224Type = Uint224Type(BigInteger(this))

    private fun ByteArray.decodeUint232Type(): Uint232Type = Uint232Type(BigInteger(this))

    private fun ByteArray.decodeUint240Type(): Uint240Type = Uint240Type(BigInteger(this))

    private fun ByteArray.decodeUint248Type(): Uint248Type = Uint248Type(BigInteger(this))

    private fun ByteArray.decodeUint24Type(): Uint24Type = Uint24Type(BigInteger(this))

    private fun ByteArray.decodeUint256Type(): Uint256Type = Uint256Type(BigInteger(this))

    private fun ByteArray.decodeUint32Type(): Uint32Type = Uint32Type(BigInteger(this))

    private fun ByteArray.decodeUint40Type(): Uint40Type = Uint40Type(BigInteger(this))

    private fun ByteArray.decodeUint48Type(): Uint48Type = Uint48Type(BigInteger(this))

    private fun ByteArray.decodeUint56Type(): Uint56Type = Uint56Type(BigInteger(this))

    private fun ByteArray.decodeUint64Type(): Uint64Type = Uint64Type(BigInteger(this))

    private fun ByteArray.decodeUint72Type(): Uint72Type = Uint72Type(BigInteger(this))

    private fun ByteArray.decodeUint80Type(): Uint80Type = Uint80Type(BigInteger(this))

    private fun ByteArray.decodeUint88Type(): Uint88Type = Uint88Type(BigInteger(this))

    private fun ByteArray.decodeUint8Type(): Uint8Type = Uint8Type(BigInteger(this))

    private fun ByteArray.decodeUint96Type(): Uint96Type = Uint96Type(BigInteger(this))

    private fun ByteArray.decodeUintType(): UintType = UintType(BigInteger(this))
}
