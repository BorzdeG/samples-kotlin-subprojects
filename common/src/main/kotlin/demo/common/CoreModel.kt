package demo.common

import kotlinx.serialization.Serializable

@Serializable
interface CoreModel {
	val s: String
}