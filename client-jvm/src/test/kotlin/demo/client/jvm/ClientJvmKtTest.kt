package demo.client.jvm

import demo.common.DataOne
import demo.common.ParentModel
import kotlinx.serialization.json.JSON
import org.junit.Assert.assertEquals
import org.junit.Test

class ClientJvmKtTest {
	@Test
	fun jsonTest() {
		val expected = ParentModel(s = "sp", data = DataOne(p0 = "pt0"))

		val dataJson = JSON.stringify(expected)
		assertEquals("""{"s":"sp","data":["demo.common.DataOne",{"p0":"pt0"}]}""", dataJson)

		val actual = JSON.parse<ParentModel>(dataJson)
		assertEquals(expected, actual)
	}

}