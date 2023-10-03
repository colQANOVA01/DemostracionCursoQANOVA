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
    implementation("org.seleniumhq.selenium:selenium-java:4.13.0")

}

tasks.test {
    useJUnitPlatform()
    useTestNG()
}
