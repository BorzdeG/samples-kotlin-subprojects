package demo.client.js

import demo.common.CoreModel

fun main(args: Array<String>) {
	ClientJs()
}

class ClientJs {
	init {
		println(CoreModel(s = "test-js"))
	}
}