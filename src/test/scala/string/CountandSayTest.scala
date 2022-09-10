package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CountandSayTest extends AnyFunSuite {
  test("can count say for 1") {
    val result = CountandSay.countAndSay(1)
    result shouldEqual "1"
  }

  test("can count say for 2") {
    val result = CountandSay.countAndSay(2)
    result shouldEqual "11"
  }

  test("can count say for 3") {
    val result = CountandSay.countAndSay(3)
    result shouldEqual "21"
  }

  test("can count say for 4") {
    val result = CountandSay.countAndSay(4)
    result shouldEqual "1211"
  }
}
