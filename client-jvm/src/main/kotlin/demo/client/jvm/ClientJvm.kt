package demo.client.jvm

import demo.common.DataOne
import demo.common.ParentModel
import kotlinx.serialization.json.JSON

fun main(args: Array<String>) {
	val dataOne = DataOne(p0 = "p1")
	val parentModel = ParentModel(s = "test", data = dataOne)

	println("<:: JSON.stringify")

	val jsonDataOne = JSON.stringify(dataOne)
	println("dataOne: $jsonDataOne")

	val jsonParentModel = JSON.stringify(parentModel)
	println("jsonParentModel: $jsonParentModel")

	println(">:: JSON.parse")
	println(JSON.parse<DataOne>(jsonDataOne))
	println(JSON.parse<ParentModel>(jsonParentModel))
}