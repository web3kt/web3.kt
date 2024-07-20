package org.web3kt.core.protocol.dto

enum class TraceOption(
    val value: String,
) {
    TRACE("trace"),
    VM_TRACE("vmTrace"),
    STATE_DIFF("stateDiff"),
}
