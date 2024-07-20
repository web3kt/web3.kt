package org.web3kt.contract

import org.web3kt.abi.Function
import org.web3kt.abi.tuple.Tuple7
import org.web3kt.abi.type.AddressType
import org.web3kt.abi.type.BoolType
import org.web3kt.abi.type.Bytes1Type
import org.web3kt.abi.type.Bytes32Type
import org.web3kt.abi.type.Bytes4Type
import org.web3kt.abi.type.DynamicArrayType
import org.web3kt.abi.type.StringType
import org.web3kt.abi.type.TypeReference
import org.web3kt.abi.type.Uint256Type
import org.web3kt.abi.type.Uint8Type
import org.web3kt.core.Web3
import java.math.BigInteger

@Suppress(
    "ktlint:standard:function-naming",
    "unchecked_cast",
    "unused",
    "FunctionName",
    "SpellCheckingInspection",
)
class Erc20(
    web3: Web3,
    address: String,
    caller: String,
) : Contract(web3, address, caller) {
    fun DEFAULT_ADMIN_ROLE(): ByteArray {
        val function = Function("DEFAULT_ADMIN_ROLE", listOf(), listOf(TypeReference<Bytes32Type>()))
        return call<ByteArray>(function)
    }

    fun DOMAIN_SEPARATOR(): ByteArray {
        val function = Function("DOMAIN_SEPARATOR", listOf(), listOf(TypeReference<Bytes32Type>()))
        return call<ByteArray>(function)
    }

    fun MINTER_ROLE(): ByteArray {
        val function = Function("MINTER_ROLE", listOf(), listOf(TypeReference<Bytes32Type>()))
        return call<ByteArray>(function)
    }

    fun PAUSER_ROLE(): ByteArray {
        val function = Function("PAUSER_ROLE", listOf(), listOf(TypeReference<Bytes32Type>()))
        return call<ByteArray>(function)
    }

    fun allowance(
        owner: String,
        spender: String,
    ): BigInteger {
        val function =
            Function(
                "allowance",
                listOf(AddressType(owner), AddressType(spender)),
                listOf(TypeReference<Uint256Type>()),
            )
        return call<BigInteger>(function)
    }

    fun approve(
        spender: String,
        `value`: BigInteger,
    ): String {
        val function =
            Function(
                "approve",
                listOf(AddressType(spender), Uint256Type(value)),
                listOf(TypeReference<BoolType>()),
            )
        return send(function)
    }

    fun balanceOf(account: String): BigInteger {
        val function =
            Function(
                "balanceOf",
                listOf(AddressType(account)),
                listOf(TypeReference<Uint256Type>()),
            )
        return call<BigInteger>(function)
    }

    fun burn(`value`: BigInteger): String {
        val function = Function("burn", listOf(Uint256Type(value)), listOf())
        return send(function)
    }

    fun burnFrom(
        account: String,
        `value`: BigInteger,
    ): String {
        val function = Function("burnFrom", listOf(AddressType(account), Uint256Type(value)), listOf())
        return send(function)
    }

    fun decimals(): BigInteger {
        val function = Function("decimals", listOf(), listOf(TypeReference<Uint8Type>()))
        return call<BigInteger>(function)
    }

    fun eip712Domain(): Tuple7<ByteArray, String, String, BigInteger, String, ByteArray, List<BigInteger>> {
        val function =
            Function(
                "eip712Domain",
                listOf(),
                listOf(
                    TypeReference<Bytes1Type>(),
                    TypeReference<StringType>(),
                    TypeReference<StringType>(),
                    TypeReference<Uint256Type>(),
                    TypeReference<AddressType>(),
                    TypeReference<Bytes32Type>(),
                    TypeReference<DynamicArrayType<Uint256Type>>(),
                ),
            )
        val types = call(function)
        return Tuple7(
            types[0].value as ByteArray,
            types[1].value as String,
            types[2].value as String,
            types[3].value as BigInteger,
            types[4].value as String,
            types[5].value as ByteArray,
            types[6].value as List<BigInteger>,
        )
    }

    fun getRoleAdmin(role: ByteArray): ByteArray {
        val function =
            Function(
                "getRoleAdmin",
                listOf(Bytes32Type(role)),
                listOf(TypeReference<Bytes32Type>()),
            )
        return call<ByteArray>(function)
    }

    fun grantRole(
        role: ByteArray,
        account: String,
    ): String {
        val function = Function("grantRole", listOf(Bytes32Type(role), AddressType(account)), listOf())
        return send(function)
    }

    fun hasRole(
        role: ByteArray,
        account: String,
    ): Boolean {
        val function =
            Function(
                "hasRole",
                listOf(Bytes32Type(role), AddressType(account)),
                listOf(TypeReference<BoolType>()),
            )
        return call<Boolean>(function)
    }

    fun mint(
        to: String,
        amount: BigInteger,
    ): String {
        val function = Function("mint", listOf(AddressType(to), Uint256Type(amount)), listOf())
        return send(function)
    }

    fun name(): String {
        val function = Function("name", listOf(), listOf(TypeReference<StringType>()))
        return call<String>(function)
    }

    fun nonces(owner: String): BigInteger {
        val function =
            Function(
                "nonces",
                listOf(AddressType(owner)),
                listOf(TypeReference<Uint256Type>()),
            )
        return call<BigInteger>(function)
    }

    fun pause(): String {
        val function = Function("pause", listOf(), listOf())
        return send(function)
    }

    fun paused(): Boolean {
        val function = Function("paused", listOf(), listOf(TypeReference<BoolType>()))
        return call<Boolean>(function)
    }

    fun permit(
        owner: String,
        spender: String,
        `value`: BigInteger,
        deadline: BigInteger,
        v: BigInteger,
        r: ByteArray,
        s: ByteArray,
    ): String {
        val function =
            Function(
                "permit",
                listOf(
                    AddressType(owner),
                    AddressType(spender),
                    Uint256Type(value),
                    Uint256Type(deadline),
                    Uint8Type(v),
                    Bytes32Type(r),
                    Bytes32Type(s),
                ),
                listOf(),
            )
        return send(function)
    }

    fun renounceRole(
        role: ByteArray,
        callerConfirmation: String,
    ): String {
        val function =
            Function(
                "renounceRole",
                listOf(
                    Bytes32Type(role),
                    AddressType(callerConfirmation),
                ),
                listOf(),
            )
        return send(function)
    }

    fun revokeRole(
        role: ByteArray,
        account: String,
    ): String {
        val function = Function("revokeRole", listOf(Bytes32Type(role), AddressType(account)), listOf())
        return send(function)
    }

    fun supportsInterface(interfaceId: ByteArray): Boolean {
        val function =
            Function(
                "supportsInterface",
                listOf(Bytes4Type(interfaceId)),
                listOf(TypeReference<BoolType>()),
            )
        return call<Boolean>(function)
    }

    fun symbol(): String {
        val function = Function("symbol", listOf(), listOf(TypeReference<StringType>()))
        return call<String>(function)
    }

    fun totalSupply(): BigInteger {
        val function = Function("totalSupply", listOf(), listOf(TypeReference<Uint256Type>()))
        return call<BigInteger>(function)
    }

    fun transfer(
        to: String,
        `value`: BigInteger,
    ): String {
        val function =
            Function(
                "transfer",
                listOf(AddressType(to), Uint256Type(value)),
                listOf(TypeReference<BoolType>()),
            )
        return send(function)
    }

    fun transferFrom(
        from: String,
        to: String,
        `value`: BigInteger,
    ): String {
        val function =
            Function(
                "transferFrom",
                listOf(
                    AddressType(from),
                    AddressType(to),
                    Uint256Type(value),
                ),
                listOf(TypeReference<BoolType>()),
            )
        return send(function)
    }

    fun unpause(): String {
        val function = Function("unpause", listOf(), listOf())
        return send(function)
    }
}
