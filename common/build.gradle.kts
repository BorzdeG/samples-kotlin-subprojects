import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformCommonPlugin

apply {
	plugin<KotlinPlatformCommonPlugin>()
}

dependencies {
	"compile"(kotlin("stdlib-common"))
}