package heap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class UglyNumber2Test extends AnyFunSuite {
  test("can find a small ugly number") {
    val result = UglyNumber2.nthUglyNumber(4)
    result shouldEqual 4
  }

  test("can find a big ugly number") {
    val result = UglyNumber2.nthUglyNumber(10)
    result shouldEqual 12
  }
}
