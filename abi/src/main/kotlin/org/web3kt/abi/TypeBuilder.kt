package org.web3kt.abi

import org.web3kt.abi.type.BytesType
import org.web3kt.abi.type.DynamicArrayType
import org.web3kt.abi.type.StaticArrayType
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.Type

class TypeBuilder(
    size: Int,
    private val offset: Int = 0,
) {
    private val byteArrayMap =
        (0 until size)
            .associateWith { ByteArray(32) }
            .toMutableMap()

    private val size: Int
        get() = byteArrayMap.size

    private fun offset(): Int = byteArrayMap.values.sumOf { it.size } + offset

    private var index = 0

    fun append(type: Type<*>) {
        if (type is BytesType || type is StringType || type is DynamicArrayType<*>) {
            set(index, offset().toByteArray().padStart())
            set(size, TypeEncoder.encode(type))
        } else {
            set(index, TypeEncoder.encode(type))
        }
        index++
    }

    private fun set(
        index: Int,
        bytes: ByteArray,
    ): TypeBuilder = this.also { byteArrayMap[index] = bytes }

    fun build(): ByteArray =
        byteArrayMap.keys
            .sorted()
            .mapNotNull { byteArrayMap[it] }
            .fold(ByteArray(0)) { acc, bytes -> acc + bytes }

    companion object {
        fun getOffset(types: List<Type<*>>): Int =
            types
                .filterIsInstance<StaticArrayType<*>>()
                .let { it.sumOf { it.size } - it.size } * 32
    }
}
