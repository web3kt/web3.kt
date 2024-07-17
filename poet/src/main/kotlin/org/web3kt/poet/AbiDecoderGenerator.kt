// package org.web3kt.poet
//
// import com.squareup.kotlinpoet.AnnotationSpec
// import com.squareup.kotlinpoet.ClassName
// import com.squareup.kotlinpoet.FileSpec
// import com.squareup.kotlinpoet.FunSpec
// import com.squareup.kotlinpoet.ParameterSpec
// import com.squareup.kotlinpoet.TypeSpec
// import java.io.File
//
// object AbiDecoderGenerator {
//     fun generate() {
//         val fileSpecBuilder =
//             FileSpec
//                 .builder("org.web3kt.abi", "AbiDecoder")
//
//         val objectBuilder =
//             TypeSpec
//                 .objectBuilder("AbiDecoder")
//
//         val annotationSpec =
//             AnnotationSpec
//                 .builder(ClassName("kotlin", "OptIn"))
//                 .addMember("ExperimentalStdlibApi::class")
//                 .build()
//         objectBuilder.addAnnotation(annotationSpec)
//
//         Util.typeClasses.forEach {
//             val funSpec =
//                 FunSpec
//                     .builder("decode$it".removeSuffix("<*>"))
//                     .addParameter(ParameterSpec.builder("bytes", ByteArray::class).build())
//                     .addStatement("return $it.fromByteArray(bytes)")
//                     .returns(ClassName("org.web3kt.abi.type", it))
//                     .build()
//             objectBuilder.addFunction(funSpec)
//         }
//
//         val objectSpec =
//             objectBuilder
//                 .build()
//
//         val fileSpec =
//             fileSpecBuilder
//                 .addType(objectSpec)
//                 .build()
//
//         fileSpec.writeTo(File("abi/src/main/kotlin"))
//     }
// }
//
// fun main() {
//     AbiDecoderGenerator.generate()
// }
