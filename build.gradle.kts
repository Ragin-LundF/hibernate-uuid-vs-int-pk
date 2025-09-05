plugins {
    kotlin("jvm") version "2.2.10"
    kotlin("plugin.spring") version "2.2.10"
    kotlin("plugin.jpa") version "2.2.10"
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "test.dbinsert"
version = "0.0.1-SNAPSHOT"
description = "db-insert"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.shell:spring-shell-dependencies:3.4.1"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.shell:spring-shell-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("net.ttddyy:datasource-proxy:1.11.0")

    implementation("com.github.f4b6a3:uuid-creator:6.1.1")

    runtimeOnly("org.postgresql:postgresql")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}
