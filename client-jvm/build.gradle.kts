import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

apply {
	plugin<KotlinPlatformJvmPlugin>()
}

dependencies {
	"expectedBy"(project(":common"))

	"compile"(kotlin("stdlib-jdk8"))
	"compile"(kotlin("reflect"))
	"compile"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime")
}