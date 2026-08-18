plugins {
    id("java")
}

group = "qa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.11.0")

    implementation("com.microsoft.playwright:playwright:1.55.0")

    implementation("io.qameta.allure:allure-testng:2.29.1")

    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("ch.qos.logback:logback-classic:1.5.18")
}

tasks.test {
    useTestNG()
}