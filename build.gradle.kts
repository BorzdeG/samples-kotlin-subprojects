import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<Wrapper> {
	distributionType = Wrapper.DistributionType.BIN
	gradleVersion = "4.7"
}

buildscript {
	val kotlinVersion: String by extra
	val kotlinxSerializationVersion: String by extra

	repositories {
		jcenter()
		maven(url = "https://kotlin.bintray.com/kotlinx")
	}

	dependencies {
		classpath(kotlin("gradle-plugin", kotlinVersion))
		classpath("org.jetbrains.kotlinx:kotlinx-gradle-serialization-plugin:$kotlinxSerializationVersion")
		classpath("org.akhikhl.gretty:gretty:latest.release")
	}
}

allprojects {
	apply {
		from("$rootDir/gradle/dependencies.gradle.kts")
		plugin<BasePlugin>()
	}

	repositories {
		jcenter()
		maven(url = "https://kotlin.bintray.com/kotlinx")
	}

	afterEvaluate {
		plugins.withType(JavaBasePlugin::class.java) {
			configure<JavaPluginConvention> {
				sourceCompatibility = JavaVersion.VERSION_1_8
			}
		}
		tasks.withType(KotlinCompile::class.java) {
			kotlinOptions {
				jvmTarget = JavaVersion.VERSION_1_8.toString()
			}
		}
	}
}