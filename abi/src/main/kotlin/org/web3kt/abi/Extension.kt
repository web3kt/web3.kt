package org.web3kt.abi

import java.math.BigInteger

@OptIn(ExperimentalStdlibApi::class)
fun ByteArray.toHex(): String = "0x${this.toHexString()}"

fun List<Byte>.toHex(): String = this.toByteArray().toHex()

fun Boolean.toByteArray(): ByteArray = (if (this) 1 else 0).toByteArray()

fun Int.toByteArray(): ByteArray = toBigInteger().toByteArray()

fun ByteArray.toBoolean(): Boolean = last() == 0x01.toByte()

fun ByteArray.toByte(): Byte = last()

fun ByteArray.toChar(): Char = Char(last().toInt())

fun ByteArray.toShort(): Short = BigInteger(this).toShort()

fun ByteArray.toInt(): Int = BigInteger(this).toInt()

fun ByteArray.toLong(): Long = BigInteger(this).toLong()

fun ByteArray.toBigInteger(): BigInteger = BigInteger(this)

fun ByteArray.padStart(padByte: Byte = 0x00.toByte()): ByteArray = ByteArray(32 - size) { padByte } + this

fun ByteArray.padEnd(): ByteArray = this + ByteArray(32 - size) { 0 }

fun ByteArray.padEndWithSize(): ByteArray {
    val sizeByteArray = size.toByteArray().padStart()
    val size =
        if (size < 32) {
            32
        } else if (size % 32 == 0) {
            size
        } else {
            (size / 32 + 1) * 32
        }

    return sizeByteArray + this + ByteArray(size - this.size) { 0 }
}
