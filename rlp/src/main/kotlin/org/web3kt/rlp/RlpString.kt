package org.web3kt.rlp

data class RlpString(
    val value: ByteArray,
) : RlpType {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RlpString

        return value.contentEquals(other.value)
    }

    override fun hashCode(): Int = value.contentHashCode()
}
