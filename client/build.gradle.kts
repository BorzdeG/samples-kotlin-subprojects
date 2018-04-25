import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

apply {
	plugin<KotlinPlatformJvmPlugin>()
}

dependencies {
	"compile"(project(":common"))

	"compile"(kotlin("stdlib-jdk8"))

}