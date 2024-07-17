package org.web3kt.poet

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import java.io.File

object PrimitiveTypeGenerator {
    fun generate(type: String) {
        val className = ClassName("org.web3kt.abi.type", "${type.replaceFirstChar { it.uppercase() }}Type")
        val valueClass = Util.getKClass(type)

        val fileSpecBuilder = FileSpec.builder(className)

        val classSpecBuilder =
            TypeSpec
                .classBuilder(className)
                .addSuperinterface(ClassName("org.web3kt.abi.type", "Type").parameterizedBy(valueClass.asClassName()))
                .addModifiers(KModifier.DATA)

        // if (type == "address") {
        //     classSpecBuilder.addAnnotation(
        //         AnnotationSpec
        //             .builder(ClassName("kotlin", "OptIn"))
        //             .addMember("ExperimentalStdlibApi::class")
        //             .build(),
        //     )
        // }

        val constructor =
            FunSpec
                .constructorBuilder()
                .addParameter("value", valueClass)
                .build()
        classSpecBuilder.primaryConstructor(constructor)

        classSpecBuilder.addProperty(
            PropertySpec
                .builder("value", Util.getKClass(type), KModifier.OVERRIDE)
                .initializer("value")
                .build(),
        )
        classSpecBuilder.addProperty(
            PropertySpec
                .builder("type", String::class, KModifier.OVERRIDE)
                .initializer("%S", type)
                .build(),
        )

        // val funSpecBuilder =
        //     FunSpec
        //         .builder("toByteArray")
        //         .addModifiers(KModifier.OVERRIDE)
        //         .returns(ByteArray::class)
        // if (type == "address") {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "padStart")
        //     funSpecBuilder.addStatement("return value.removePrefix(\"0x\").hexToByteArray().padStart()")
        // } else if (type == "bytes") {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "padEndWithSize")
        //     funSpecBuilder.addStatement("return value.padEndWithSize()")
        // } else if (type == "string") {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "padEndWithSize")
        //     funSpecBuilder.addStatement("return value.toByteArray().padEndWithSize()")
        // } else if (type.startsWith("int") || type == "short" || type == "long") {
        //     if (Util.getKClass(type) == BigInteger::class) {
        //         funSpecBuilder.addStatement("val padByte = if (value < 0.toBigInteger()) 0xff.toByte() else 0x00.toByte()")
        //     } else {
        //         funSpecBuilder.addStatement("val padByte = if (value < 0) 0xff.toByte() else 0x00.toByte()")
        //     }
        //     fileSpecBuilder.addImport("org.web3kt.abi", "toByteArray", "padStart")
        //     funSpecBuilder.addStatement("return value.toByteArray().padStart(padByte)")
        // } else if (type.startsWith("bytes")) {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "padEnd")
        //     funSpecBuilder.addStatement("return value.padEnd()")
        // } else {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "toByteArray", "padStart")
        //     funSpecBuilder.addStatement("return value.toByteArray().padStart()")
        // }
        //
        // val companionFunSpecBuilder =
        //     FunSpec
        //         .builder("fromByteArray")
        //         .addParameter("bytes", ByteArray::class)
        //         .returns(ClassName("org.web3kt.abi.type", className))
        //
        // if (type == "address") {
        //     companionFunSpecBuilder.addStatement("return AddressType(\"0x\${bytes.toHexString().takeLast(40)}\")")
        // } else if (type == "bytes") {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "toInt")
        //     companionFunSpecBuilder.addStatement("val size = bytes.take(32).toByteArray().toInt()")
        //     companionFunSpecBuilder.addStatement("return BytesType(bytes.drop(32).take(size).toByteArray())")
        // } else if (type == "string") {
        //     fileSpecBuilder.addImport("org.web3kt.abi", "toInt")
        //     companionFunSpecBuilder.addStatement("val size = bytes.take(32).toByteArray().toInt()")
        //     companionFunSpecBuilder.addStatement("val data = bytes.drop(32).take(size).toByteArray()")
        //     companionFunSpecBuilder.addStatement("return StringType(data.toString(Charsets.UTF_8))")
        // } else if (type.startsWith("bytes")) {
        //     val size = type.drop(5)
        //     companionFunSpecBuilder.addStatement("return $className(bytes.take($size).toByteArray())")
        // } else {
        //     val toClassName = Util.getKClass(type).simpleName
        //     fileSpecBuilder.addImport("org.web3kt.abi", "to$toClassName")
        //     companionFunSpecBuilder.addStatement("return $className(bytes.to$toClassName())")
        // }
        //
        // val companion =
        //     TypeSpec
        //         .companionObjectBuilder()
        //         .addFunction(companionFunSpecBuilder.build())
        //         .build()

        val classSpec =
            classSpecBuilder
                .build()

        val fileSpec =
            fileSpecBuilder
                .addType(classSpec)
                .build()

        fileSpec.writeTo(File("abi/src/main/kotlin"))
    }
}

fun main() {
    Util.types.forEach { PrimitiveTypeGenerator.generate(it) }
}
