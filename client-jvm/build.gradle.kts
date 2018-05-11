import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlinx.serialization.gradle.SerializationGradleSubplugin

apply {
	plugin<KotlinPlatformJvmPlugin>()
	plugin<SerializationGradleSubplugin>()
}

tasks.withType(Test::class.java).all {
	testLogging {
		showStandardStreams = true
	}
}

dependencies {
	"expectedBy"(project(":common"))

	"compile"(kotlin("stdlib-jdk8"))
	"compile"(kotlin("reflect"))
	"compile"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime")

	"testCompile"(kotlin("test"))
	"testCompile"(kotlin("test-junit"))
}