package org.web3kt.poet

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

object TupleGenerator {
    fun generate(int: Int) {
        val className = ClassName("org.web3kt.abi.tuple", "Tuple$int")
        val fileSpecBuilder = FileSpec.builder(className)

        val typeVariables = (1..int).map { TypeVariableName("T$it") }
        val classBuilder =
            TypeSpec
                .classBuilder(className)
                .addTypeVariables(typeVariables)
        val constructorBuilder = FunSpec.constructorBuilder()

        typeVariables.forEach {
            constructorBuilder.addParameter(it.name.lowercase(), it)
            classBuilder.addProperty(
                PropertySpec.builder(it.name.lowercase(), it).initializer(it.name.lowercase()).build(),
            )
        }

        classBuilder
            .primaryConstructor(constructorBuilder.build())

        fileSpecBuilder
            .addType(classBuilder.build())
            .build()
            .writeTo(File("abi/src/main/kotlin"))
    }
}

fun main() {
    (2..10).forEach {
        TupleGenerator.generate(it)
    }
}
