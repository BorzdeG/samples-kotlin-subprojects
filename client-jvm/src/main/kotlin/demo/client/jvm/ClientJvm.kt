package demo.client.jvm

import demo.common.ChildModel
import demo.common.CoreModel
import demo.common.ParentModel
import kotlinx.serialization.json.JSON

fun main(args: Array<String>) {
	val coreModel = CoreModel(s = "test")
	println("<:: raw")
	println(coreModel)
	println("<:: JSON.stringify")
	val jsonCoreModel = JSON.stringify(coreModel)
	println("json: $jsonCoreModel")
	println(">:: JSON.parse")
	println(JSON.parse<CoreModel>(jsonCoreModel))
//
	val parentModel = ParentModel(f = "value", childModel = ChildModel(cf = "cf"))
	println("<:: JSON.stringify")
	val jsonParentModel = JSON.stringify(parentModel)
	println("json: $jsonParentModel")
	println(">:: JSON.parse")
	println(JSON.parse<ParentModel>(jsonParentModel))
}