plugins {
    java
}

group = "com.nokinori.research"

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-engine:5.4.0")
    implementation("org.projectlombok:lombok:1.18.6")
    annotationProcessor("org.projectlombok:lombok:1.18.6")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.6")

    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.slf4j:slf4j-api:1.7.25")
    testImplementation("org.assertj:assertj-core:3.11.1")
}