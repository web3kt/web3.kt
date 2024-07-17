package org.web3kt.contract

import org.web3kt.abi.AbiEncoder
import org.web3kt.core.Web3
import org.web3kt.core.protocol.dto.Tag
import org.web3kt.core.protocol.dto.TransactionCall
import java.math.BigInteger
import kotlin.ByteArray
import kotlin.Short
import kotlin.String

public class Erc20(
    public val web3: Web3,
    public val address: String,
    public val caller: String,
) {
    public suspend fun DEFAULT_ADMIN_ROLE(): String {
        val selector = "0xa217fddf"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun DOMAIN_SEPARATOR(): String {
        val selector = "0x3644e515"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun MINTER_ROLE(): String {
        val selector = "0xd5391393"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun PAUSER_ROLE(): String {
        val selector = "0xe63ab1e9"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun allowance(
        owner: String,
        spender: String,
    ): String {
        val selector = "0xdd62ed3e"
        val data = selector + AbiEncoder.encode(AddressType(owner), AddressType(spender))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun approve(
        spender: String,
        `value`: BigInteger,
    ): String {
        val selector = "0x095ea7b3"
        TODO("approve")
    }

    public suspend fun balanceOf(account: String): String {
        val selector = "0x70a08231"
        val data = selector + AbiEncoder.encode(AddressType(account))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun burn(`value`: BigInteger): String {
        val selector = "0x42966c68"
        TODO("burn")
    }

    public suspend fun burnFrom(
        account: String,
        `value`: BigInteger,
    ): String {
        val selector = "0x79cc6790"
        TODO("burnFrom")
    }

    public suspend fun decimals(): String {
        val selector = "0x313ce567"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun eip712Domain(): String {
        val selector = "0x84b0196e"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun getRoleAdmin(role: ByteArray): String {
        val selector = "0x248a9ca3"
        val data = selector + AbiEncoder.encode(Bytes32Type(role))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun grantRole(
        role: ByteArray,
        account: String,
    ): String {
        val selector = "0x2f2ff15d"
        TODO("grantRole")
    }

    public suspend fun hasRole(
        role: ByteArray,
        account: String,
    ): String {
        val selector = "0x91d14854"
        val data = selector + AbiEncoder.encode(Bytes32Type(role), AddressType(account))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun mint(
        to: String,
        amount: BigInteger,
    ): String {
        val selector = "0x40c10f19"
        TODO("mint")
    }

    public suspend fun name(): String {
        val selector = "0x06fdde03"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun nonces(owner: String): String {
        val selector = "0x7ecebe00"
        val data = selector + AbiEncoder.encode(AddressType(owner))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun pause(): String {
        val selector = "0x8456cb59"
        TODO("pause")
    }

    public suspend fun paused(): String {
        val selector = "0x5c975abb"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun permit(
        owner: String,
        spender: String,
        `value`: BigInteger,
        deadline: BigInteger,
        v: Short,
        r: ByteArray,
        s: ByteArray,
    ): String {
        val selector = "0xd505accf"
        TODO("permit")
    }

    public suspend fun renounceRole(
        role: ByteArray,
        callerConfirmation: String,
    ): String {
        val selector = "0x36568abe"
        TODO("renounceRole")
    }

    public suspend fun revokeRole(
        role: ByteArray,
        account: String,
    ): String {
        val selector = "0xd547741f"
        TODO("revokeRole")
    }

    public suspend fun supportsInterface(interfaceId: ByteArray): String {
        val selector = "0x01ffc9a7"
        val data = selector + AbiEncoder.encode(Bytes4Type(interfaceId))
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun symbol(): String {
        val selector = "0x95d89b41"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun totalSupply(): String {
        val selector = "0x18160ddd"
        val data = selector + AbiEncoder.encode()
        return web3.eth.call(TransactionCall(from = caller, to = address, data = data), Tag.LATEST)
    }

    public suspend fun transfer(
        to: String,
        `value`: BigInteger,
    ): String {
        val selector = "0xa9059cbb"
        TODO("transfer")
    }

    public suspend fun transferFrom(
        from: String,
        to: String,
        `value`: BigInteger,
    ): String {
        val selector = "0x23b872dd"
        TODO("transferFrom")
    }

    public suspend fun unpause(): String {
        val selector = "0x3f4ba83a"
        TODO("unpause")
    }
}
