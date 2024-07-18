package org.web3kt.poet

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

object PrimitiveTypeGenerator {
    fun generate(type: String) {
        val className = ClassName("org.web3kt.abi.type", "${type.replaceFirstChar { it.uppercase() }}Type")
        val valueClass = Util.getTypeName(type)

        val classSpec =
            TypeSpec
                .classBuilder(className)
                .addSuperinterface(ClassName("org.web3kt.abi.type", "Type").parameterizedBy(valueClass))
                .addModifiers(KModifier.DATA)
                .primaryConstructor(
                    FunSpec
                        .constructorBuilder()
                        .addParameter("value", valueClass)
                        .build(),
                ).addProperty(
                    PropertySpec
                        .builder("value", Util.getTypeName(type), KModifier.OVERRIDE)
                        .initializer("value")
                        .build(),
                ).addProperty(
                    PropertySpec
                        .builder("type", String::class, KModifier.OVERRIDE)
                        .initializer("%S", type)
                        .build(),
                ).build()

        val fileSpec =
            FileSpec
                .builder(className)
                .addType(classSpec)
                .build()

        fileSpec.writeTo(File("abi/src/main/kotlin"))
    }
}

fun main() {
    Util.types.forEach { PrimitiveTypeGenerator.generate(it) }
}
