import org.gradle.plugins.ide.idea.model.IdeaModel

val kotlinVersion: String by extra
val kotlinxSerializationVersion: String by extra

configurations.all {
	resolutionStrategy.apply {
		failOnVersionConflict()
		eachDependency {
			when (requested.group) {
				"org.jetbrains.kotlin" -> useVersion(kotlinVersion)
				"org.jetbrains.kotlinx" -> {
					val requestedName = requested.name
					when {
						requestedName.startsWith("kotlinx-io") -> useVersion("0.0.10")
						requestedName.startsWith("kotlinx-coroutines-") -> useVersion("0.22.5")
						requestedName.startsWith("kotlinx-serialization-") -> useVersion(kotlinxSerializationVersion)
						else -> useVersion("0.6.9")
					}
				}
			}
		}
	}
}

apply {
	plugin<IdeaPlugin>()
}

configure<IdeaModel> {
	module {
		isDownloadJavadoc = false
		isDownloadSources = false
	}
}
