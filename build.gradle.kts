plugins {
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.dependency.management)
  alias(libs.plugins.lombok)
  alias(libs.plugins.spotless)
  java
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(21)) } }

dependencies {
  implementation(libs.spring.doc.ui)

  implementation(libs.spring.boot.starter.data.jpa)
  implementation(libs.spring.boot.starter.validation)
  implementation(libs.spring.boot.starter.web)

  runtimeOnly(libs.h2)
  runtimeOnly(libs.postgresql)

  annotationProcessor(libs.spring.boot.configuration.processor)
  testImplementation(libs.spring.boot.starter.test)
}

tasks {
  jar { enabled = false }
  test {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "test")
  }
}

spotless {
  java {
    prettier(mapOf("prettier-plugin-java" to "2.3.0"))
        .config(
            mapOf(
                "parser" to "java",
                "plugins" to
                    listOf(
                        "prettier-plugin-java",
                    ),
            ),
        )
    removeUnusedImports()
  }

  kotlinGradle { ktfmt() }
}
