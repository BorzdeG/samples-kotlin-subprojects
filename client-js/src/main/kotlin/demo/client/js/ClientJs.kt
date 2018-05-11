package demo.client.js

import demo.common.DataOne
import demo.common.ParentModel
import kotlinx.serialization.json.JSON

fun main(args: Array<String>) {
	ClientJs()
}

class ClientJs {
	init {
		val parentModel = ParentModel(s = "test-js", data = DataOne(p0 = "ps"))
		println("> toString")
		println(parentModel)
		println("> json")
		println(JSON.stringify(parentModel))
	}
}