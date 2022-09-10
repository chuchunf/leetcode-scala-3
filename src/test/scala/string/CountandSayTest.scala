package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CountandSayTest extends AnyFunSuite {
  test("can count say for 1") {
    val result = CountandSay.countAndSay(1)
    println(s"result=$result")
  }

  test("can count say for 4") {
    val result = CountandSay.countAndSay(4)
    println(s"result=$result")
  }
}
