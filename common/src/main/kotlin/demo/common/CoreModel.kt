package demo.common

import kotlinx.serialization.*
import kotlinx.serialization.KSerialClassKind.CLASS

@Serializable(with = CoreModelSerializer::class)
data class CoreModel(val s: String) {
	companion object {
		@Suppress("unused")
		fun serializer() = CoreModelSerializer
	}

	override fun toString(): String {
		return "s: $s"
	}
}

@Serializer(forClass = CoreModel::class)
object CoreModelSerializer : KSerializer<CoreModel> {

	override val serialClassDesc = object : KSerialClassDesc {
		override val name = "demo.common.CoreModel"
		override val kind = CLASS

		override fun getElementName(index: Int) = when (index) {
			0 -> "s"
			else -> ""
		}

		override fun getElementIndex(name: String) = when (name) {
			"s" -> 0
			else -> -1
		}
	}

	override fun load(input: KInput): CoreModel {
		input.readBegin(serialClassDesc)
		input.readElement(serialClassDesc)
		val s = input.readStringElementValue(serialClassDesc, 0)
		input.readEnd(serialClassDesc)
		return CoreModel(s = s)
	}

	override fun save(output: KOutput, obj: CoreModel) {
		output.writeBegin(serialClassDesc)
		output.writeStringElementValue(serialClassDesc, 0, obj.s)
		output.writeEnd(serialClassDesc)
	}
}