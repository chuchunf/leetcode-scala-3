package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CompareVersionNumbersTest extends AnyFunSuite {
  test("can compare the same") {
    val v1 = "1.01"
    val v2 = "1.01"
    val result = CompareVersionNumbers.compareVersion(v1, v2)
    result shouldEqual 0
  }

  test("can compare and ingore leading zero") {
    val v1 = "1.01"
    val v2 = "1.1"
    val result = CompareVersionNumbers.compareVersion(v1, v2)
    result shouldEqual 0
  }

  test("can find diff in minor version") {
    val v1 = "2.01"
    val v2 = "2.2"
    val result = CompareVersionNumbers.compareVersion(v1, v2)
    result shouldEqual -1
  }
}
