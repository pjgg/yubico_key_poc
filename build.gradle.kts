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

//tasks.register("archiveSwagger") {
//        println(allprojects.stream().forEach() { p -> println(p.name) })
//
//        project.subprojects.mapNotNull {
//            println(it.name)
//            when (it.name) {
//                "project1","project2" -> it.tasks.findByName("archiveSwagger")
//                else -> null
//            }
//        }
//
//        println("archiveSwagger done.")
//}

