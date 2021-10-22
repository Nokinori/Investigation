plugins {
    java
}

group = "com.nokinori.research"

dependencies {
    implementation("org.projectlombok:lombok:1.18.6")
    annotationProcessor("org.projectlombok:lombok:1.18.6")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.6")

    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.slf4j:slf4j-api:1.7.25")
}