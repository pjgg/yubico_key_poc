plugins {
    `java-library`
    id("org.openapi.generator")
}

repositories {
    mavenCentral()
}

version = "0.1"
group = "org"

val micronautVersion: String by project

dependencies {
    // import a BOM
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.grpc:micronaut-grpc-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    // default monitoring instrumentation
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")

    testImplementation("io.micronaut:micronaut-http-client")
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

openApiGenerate {
    inputSpec.set("${projectDir}/src/main/resources/project1_swagger_v1_0.json")
    outputDir.set("$buildDir/generated/openapi")
    ignoreFileOverride.set("${projectDir}/.openapi-generator-ignore")
    generatorName.set("java-micronaut-server")
    apiPackage.set("org.pablos.swagger.poc")
    modelPackage.set("org.pablos.swagger.poc.model")
    generateApiTests.set(false)
    configOptions.set(hashMapOf(
            // abstract class controller so we can extend it
            "generateControllerAsAbstract" to "true",
            // Disable for now because it only annotates with "allow anonymous access" anyway (needs openapi spec update to work)
            "useAuth" to "false",
    ))
}

//tasks.register<Copy>("swaggerArchive") {
//    dependsOn("openApiGenerate")
//    // for example: swagger.json
//    val swaggerFileName = "swagger"
//    val swaggerFileExtension = "json"
//    val swaggerFileVersion = "v1_0"
//    val swaggerLibPath = "${projectDir}/../libs/swaggers"
//
//    val finalName = "${project.name}" + "_" + swaggerFileName + "_" + swaggerFileVersion + "." + swaggerFileExtension
//    from("${projectDir}/src/main/resources/" + swaggerFileName + "." + swaggerFileExtension)
//    into(swaggerLibPath)
//    rename("(.*)\\.$swaggerFileExtension", finalName)
//}
