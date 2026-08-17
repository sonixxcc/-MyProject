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
    testImplementation("com.microsoft.playwright:playwright:1.55.0")
}

tasks.test {
    useTestNG()
}