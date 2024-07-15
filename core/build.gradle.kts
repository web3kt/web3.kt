group = "org.web3kt"
version = "0.1.0"

plugins {
    id("maven-publish")
    id("signing")
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.0.0"
}

java {
    withJavadocJar()
    withSourcesJar()
}

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
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.web3kt"
            artifactId = "core"

            from(components["java"])

            pom {
                name.set("Web3.kt")
                description.set("Web3.kt is a Kotlin implementation of the Besu API.")
                url.set("https://github.com/web3kt/web3.kt")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/web3kt/web3.kt/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("junsung")
                        name.set("Junsung Cho")
                        email.set("junsung.dev@gmail.com")
                    }
                }
                scm {
                    url.set("https://github.com/web3kt/web3.kt.git")
                }
            }
        }
    }

    repositories {
        maven {
            setUrl(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}

signing {
    sign(publishing.publications)
}
