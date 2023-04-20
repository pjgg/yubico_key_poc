rootProject.name="project2"

pluginManagement {
    val openApiGeneratorVersion: String by settings
    plugins {
        id("org.openapi.generator") version "${openApiGeneratorVersion}"
    }
}
