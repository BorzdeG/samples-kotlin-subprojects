package demo.client

import demo.common.CoreModel

class Client {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			println(CoreModel(s = "test"))
		}
	}
}