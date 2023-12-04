plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.allopen") version "1.9.21"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-container-image-jib")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-jsonb")
    implementation("io.quarkus:quarkus-mongodb-client")
    implementation("io.quarkus:quarkus-container-image-jib")

    implementation("org.jobrunr:quarkus-jobrunr:6.3.3")

    runtimeOnly("io.quarkus:quarkus-credentials")
}

group = "org.acme"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allOpen {
    annotation("jakarta.enterprise.context.ApplicationScoped")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}
