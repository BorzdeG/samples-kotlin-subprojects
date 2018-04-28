package demo.common

import kotlinx.serialization.*
import kotlinx.serialization.KSerialClassKind.CLASS

@Serializable(with = ParentModelSerializer::class)
data class ParentModel(val f: String, val childModel: ChildModel) {
	companion object {
		@Suppress("unused")
		fun serializer() = ParentModelSerializer
	}
}

@Serializer(forClass = ParentModel::class)
object ParentModelSerializer : KSerializer<ParentModel> {
	override val serialClassDesc = object : KSerialClassDesc {
		override val name = "demo.common.ParentModel"
		override val kind = CLASS
		override fun getElementIndex(name: String) = when (name) {
			"f" -> 0
			"childModel" -> 1
			else -> -1
		}

		override fun getElementName(index: Int) = when (index) {
			0 -> "f"
			1 -> "childModel"
			else -> ""
		}
	}

	override fun load(input: KInput): ParentModel {
		input.readBegin(serialClassDesc)
		val f = input.readStringElementValue(serialClassDesc, 0)
		val childModel = input.readSerializableElementValue(serialClassDesc, 1, ChildModelSerializer)
		input.readEnd(serialClassDesc)

		return ParentModel(f = f, childModel = childModel)
	}

	override fun save(output: KOutput, obj: ParentModel) {
		output.writeBegin(serialClassDesc)
		output.writeStringElementValue(serialClassDesc, 0, obj.f)
		output.writeSerializableElementValue(serialClassDesc, 1, ChildModelSerializer, obj.childModel)
		output.writeEnd(serialClassDesc)
	}
}