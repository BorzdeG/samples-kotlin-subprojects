import org.akhikhl.gretty.GrettyPlugin
import org.akhikhl.gretty.JettyStartTask
import org.jetbrains.kotlin.gradle.plugin.Kotlin2JsPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.KotlinJsDcePlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJsPlugin
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

apply {
	plugin<KotlinPlatformJsPlugin>()
	plugin<KotlinJsDcePlugin>()
	plugin<GrettyPlugin>()
}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
		moduleKind = "amd"
		sourceMap = true
	}
}

tasks[JavaPlugin.CLASSES_TASK_NAME].apply {
	finalizedBy(tasks["runDceKotlinJs"])

	doLast {
		configurations[JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME].onEach { file ->
			copy {
				includeEmptyDirs = false

				from(zipTree(file.absolutePath))
				into("$buildDir/resources/web")
				include { fileTreeElement ->
					val path = fileTreeElement.path
					return@include path.endsWith(".js") && (path.startsWith("META-INF/resources/") || !path.startsWith("META-INF/"))
				}
				eachFile {
					path = name
				}
			}
		}
	}
}

tasks.withType<JettyStartTask> {
	contextPath = "/"
	extraResourceBases("src/main/web", "build/kotlin-js-min/main", "build/resources/web")
	reloadOnClassChange = false
	scanDir("src/main/kotlin")

	dependsOn(tasks.withType<KotlinJsDce>())
}

dependencies {
	"expectedBy"(project(":common"))

	"compile"(kotlin("reflect"))
	"compile"(kotlin("stdlib-js"))
	"compile"(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime-js")

	"compileOnly"(group = "org.webjars", name = "requirejs", version = "2.3.5")

	"testCompile"(kotlin("test-js"))
}