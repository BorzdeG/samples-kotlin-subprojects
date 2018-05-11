package demo.client.js

import demo.common.DataOne
import demo.common.ParentModel

fun main(args: Array<String>) {
	ClientJs()
}

class ClientJs {
	init {
		println(ParentModel(s = "test-js", data = DataOne(p0 = "ps")))
	}
}