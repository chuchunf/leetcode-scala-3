package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RearrangeStringkDistanceApartTest extends AnyFunSuite {
  test("can rearrange string") {
    val s = "aabbcc"
    val result = RearrangeStringkDistanceApart.rearrangeString(s, 3)
    result shouldEqual "abcabc"
  }

  test("can not rearrange string") {
    val s = "aaabc"
    val result = RearrangeStringkDistanceApart.rearrangeString(s, 3)
    result shouldEqual ""
  }
}
