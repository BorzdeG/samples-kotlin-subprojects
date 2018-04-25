import org.gradle.plugins.ide.idea.model.IdeaModel

val kotlinVersion: String by extra

configurations.all {
	resolutionStrategy.apply {
		failOnVersionConflict()
		eachDependency {
			when (requested.group) {
				"org.jetbrains.kotlin" -> useVersion(kotlinVersion)
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
