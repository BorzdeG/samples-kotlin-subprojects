package demo.common

import kotlinx.serialization.*

@Serializable
data class ParentModel(
	override val s: String,
	@Serializable val data: Any
) : CoreModel