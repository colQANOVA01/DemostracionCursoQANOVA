plugins {
    id("java")
    id("org.openrewrite.rewrite") version("6.3.18")
}

rewrite {
    activeRecipe("org.openrewrite.staticanalysis.ReplaceDeprecatedRuntimeExecMethods")
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
    implementation("com.itextpdf:itextpdf:5.5.13.3")
    implementation("net.coobird:thumbnailator:0.4.20")
    implementation("javax.mail:javax.mail-api:1.6.2")
    rewrite("org.openrewrite.recipe:rewrite-static-analysis:1.0.8")
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.test {
    useJUnitPlatform()
    useTestNG()
}
