package org.web3kt.core.protocol.dto

enum class Tag(
    val value: String,
) {
    EARLIEST("earliest"),
    LATEST("latest"),
    PENDING("pending"),
    FINALIZED("finalized"),
    SAFE("safe"),
}
