plugins {
    java
}

allprojects {

    repositories {
        mavenCentral()
    }

    apply(plugin = "java")
    java.sourceCompatibility = JavaVersion.toVersion("17")
    java.targetCompatibility = JavaVersion.toVersion("17")
}


