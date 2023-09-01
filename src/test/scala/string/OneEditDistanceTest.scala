package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class OneEditDistanceTest extends AnyFunSuite {
  test("can find one edit distnce for same length") {
    val s = "ab"
    val t = "cb"
    val result = OneEditDistance.isOneEditDistance(s, t)
    result shouldEqual true
  }

  test("cann't find one edit distnce for same length") {
    val s = "ab"
    val t = "ab"
    val result = OneEditDistance.isOneEditDistance(s, t)
    result shouldEqual false
  }

  test("can find one edit distnce for diff length") {
    val s = "ab"
    val t = "acb"
    val result = OneEditDistance.isOneEditDistance(s, t)
    result shouldEqual true
  }

  test("can not find one edit distnce for diff length") {
    val s = "ab"
    val t = "acd"
    val result = OneEditDistance.isOneEditDistance(s, t)
    result shouldEqual false
  }
}
