plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0"
    kotlin("jvm") version "1.4.31"
}

group = "de.kolpa.mc"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
}

tasks {
    processResources {
        expand("version" to project.version)
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
    implementation("org.koin:koin-core:2.2.2")
}