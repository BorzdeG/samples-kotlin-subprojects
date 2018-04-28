package demo.common

import kotlinx.serialization.*

@Serializable(with = ChildModelSerializer::class)
data class ChildModel(val cf: String)

@Serializer(forClass = ChildModel::class)
object ChildModelSerializer : KSerializer<ChildModel> {
	override val serialClassDesc = object : KSerialClassDesc {
		override val name = "demo.common.ChildModel"
		override val kind = KSerialClassKind.CLASS
		override fun getElementIndex(name: String) = when (name) {
			"cf" -> 0
			else -> -1
		}

		override fun getElementName(index: Int) = when (index) {
			0 -> "cf"
			else -> ""
		}
	}

	override fun load(input: KInput): ChildModel {
		input.readBegin(serialClassDesc)
		val cf = input.readStringElementValue(serialClassDesc, 0)
		input.readEnd(serialClassDesc)
		return ChildModel(cf = cf)
	}

	override fun save(output: KOutput, obj: ChildModel) {
		output.apply {
			writeBegin(serialClassDesc)
			writeStringElementValue(serialClassDesc, 0, obj.cf)
			writeEnd(serialClassDesc)
		}
	}
}