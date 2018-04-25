import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<Wrapper> {
	distributionType = Wrapper.DistributionType.BIN
	gradleVersion = "4.7"
}

buildscript {
	val kotlinVersion: String by extra

	repositories {
		jcenter()
	}

	dependencies {
		classpath(kotlin("gradle-plugin", kotlinVersion))
	}
}

allprojects {
	apply {
		from("$rootDir/gradle/dependencies.gradle.kts")
		plugin<BasePlugin>()
	}

	repositories {
		jcenter()
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