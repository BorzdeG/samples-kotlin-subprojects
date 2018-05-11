package demo.common

import kotlinx.serialization.json.JSON
import kotlin.test.Test
import kotlin.test.assertEquals

class DataOneTest {
	@Test
	fun blaTest() {
		val dataOne = DataOne(p0 = "pt0")
		assertEquals("""{"p0":"pt0"}""", JSON.stringify(dataOne))
	}
}