import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformCommonPlugin
import org.jetbrains.kotlinx.serialization.gradle.SerializationGradleSubplugin

apply {
	plugin<KotlinPlatformCommonPlugin>()
	plugin<SerializationGradleSubplugin>()
}

dependencies {
	"compile"(kotlin("stdlib-common"))
	"implementation"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime")
}

tasks["compileKotlinCommon"].enabled = false