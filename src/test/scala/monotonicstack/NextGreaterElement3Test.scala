package monotonicstack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class NextGreaterElement3Test extends AnyFunSuite {
  test("can find next greater element") {
    val n = 12
    val result = NextGreaterElement3.nextGreaterElement(n)
    result shouldEqual 21
  }

  test("can not find next greater element") {
    val n = 21
    val result = NextGreaterElement3.nextGreaterElement(n)
    result shouldEqual -1
  }
}
