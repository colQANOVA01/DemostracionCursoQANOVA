plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("org.seleniumhq.selenium:selenium-java:4.13.0")
    implementation("org.slf4j:log4j-over-slf4j:2.0.9")
}

tasks.test {
    useJUnitPlatform()
    useTestNG()
}
