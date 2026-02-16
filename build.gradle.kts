plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
    id("org.jetbrains.changelog") version "2.5.0"
}

group = project.property("pluginGroup") as String
version = project.property("pluginVersion") as String

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

intellij {
    version.set(project.property("intellijVersion") as String)
    type.set("IC")
    plugins.set(listOf())
}

changelog {
    groups.empty()
    repositoryUrl = project.property("pluginRepositoryUrl") as String
    versionPrefix = ""
}

tasks {
    wrapper {
        gradleVersion = project.property("gradleVersion") as String
    }

    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        sinceBuild.set(project.property("sinceBuild") as String)
        untilBuild.set("")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
        dependsOn(patchChangelog)
    }

    buildSearchableOptions {
        enabled = false
    }
}
