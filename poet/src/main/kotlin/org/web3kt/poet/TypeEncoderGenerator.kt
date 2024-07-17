package org.web3kt.poet

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

object TypeEncoderGenerator {
    fun generate() {
        val className = ClassName("org.web3kt.abi", "TypeEncoder")
        val fileSpecBuilder =
            FileSpec
                .builder(className)

        val objectBuilder =
            TypeSpec
                .objectBuilder(className)
                .addAnnotation(
                    AnnotationSpec
                        .builder(ClassName("kotlin", "OptIn"))
                        .addMember("ExperimentalStdlibApi::class")
                        .build(),
                )

        val funSpecBuilder =
            FunSpec
                .builder("encode")
                .addParameter("type", ClassName("org.web3kt.abi.type", "Type").parameterizedBy(STAR))

        funSpecBuilder.addStatement("val encoded = when (type) {")
        Util.typeClasses.forEach {
            funSpecBuilder.addStatement("\tis $it -> type.encode()")
        }
        funSpecBuilder
            .addStatement("}")
            .addStatement("return encoded")
            .returns(ByteArray::class)

        objectBuilder.addFunction(funSpecBuilder.build())

        Util.typeClasses.forEach {
            val funSpecBuilder =
                FunSpec
                    .builder("encode")
                    .addModifiers(KModifier.PRIVATE)
                    .returns(ByteArray::class)

            if (it == "StaticArray<*>") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", "StaticArray").parameterizedBy(STAR))
                    .addStatement("val builder = TypeBuilder(size)")
                    .addStatement("value.forEach { builder.append(it) }")
                    .addStatement("return builder.build()")
            } else if (it == "DynamicArray<*>") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", "DynamicArray").parameterizedBy(STAR))
                    .addStatement("val builder = TypeBuilder(size + 1)")
                    .addStatement("builder.append(Uint256Type(size.toBigInteger()))")
                    .addStatement("value.forEach { builder.append(it) }")
                    .addStatement("return builder.build()")
            } else if (it == "AddressType") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("return value.removePrefix(\"0x\").hexToByteArray().padStart()")
            } else if (it == "BoolType") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("val byte = if (value) 0x01.toByte() else 0x00.toByte()")
                    .addStatement("return byteArrayOf(byte).padStart()")
            } else if (it == "BytesType") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("return value.padEndWithSize()")
            } else if (it == "StringType") {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("return value.toByteArray().padEndWithSize()")
            } else if (it.startsWith("Bytes")) {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("return value.padEnd()")
            } else if (it.startsWith("Int")) {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("val padByte = if (value.signum() < 0) 0xff.toByte() else 0x00.toByte()")
                    .addStatement("return value.toByteArray().padStart(padByte)")
            } else if (it.startsWith("Uint")) {
                funSpecBuilder
                    .receiver(ClassName("org.web3kt.abi.type", it))
                    .addStatement("return value.toByteArray().padStart()")
            }
            objectBuilder.addFunction(funSpecBuilder.build())
        }

        val objectSpec = objectBuilder.build()

        val fileSpec =
            fileSpecBuilder
                .addType(objectSpec)
                .build()

        fileSpec.writeTo(File("abi/src/main/kotlin"))
    }
}

fun main() {
    TypeEncoderGenerator.generate()
}
