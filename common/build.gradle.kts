import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformCommonPlugin
import org.jetbrains.kotlinx.serialization.gradle.SerializationGradleSubplugin

apply {
	plugin<KotlinPlatformCommonPlugin>()
	plugin<SerializationGradleSubplugin>()
}

dependencies {
	"compile"(kotlin("stdlib-common"))
	"compile"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime")

	"testCompile"(kotlin("test-annotations-common"))
	"testCompile"(kotlin("test"))
	"testCompile"(kotlin("test-junit"))
}

tasks["compileKotlinCommon"].enabled = false