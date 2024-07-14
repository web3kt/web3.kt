plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.0.0"
}

group = "org.web3kt"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    api("io.ktor:ktor-client-core:2.3.12")
    api("io.ktor:ktor-client-cio:2.3.12")
    api("io.ktor:ktor-client-logging:2.3.12")
    api("io.ktor:ktor-client-logging-jvm:2.3.12")
    api("io.ktor:ktor-client-content-negotiation:2.3.12")
    api("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
