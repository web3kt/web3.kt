package org.web3kt.abi

import org.bouncycastle.jcajce.provider.digest.Keccak

object MessageDigest {
    fun digest(input: ByteArray): ByteArray = Keccak.Digest256().digest(input)
}
