import org.jetbrains.kotlin.gradle.plugin.Kotlin2JsPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.KotlinJsDcePlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJsPlugin
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

apply {
	plugin<KotlinPlatformJsPlugin>()
	plugin<KotlinJsDcePlugin>()
}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
		moduleKind = "plain"
		sourceMap = true
	}
}

tasks[JavaPlugin.CLASSES_TASK_NAME].finalizedBy(tasks["runDceKotlinJs"])

dependencies {
	"expectedBy"(project(":common"))

	"compile"(kotlin("stdlib-js"))
	"compile"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime-js")

	"testCompile"(kotlin("test-js"))
}