package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SingleNumber2Test extends AnyFunSuite {
  test("can get single number") {
    val nums = Array(0, 1, 0, 1, 0, 1, 99)
    val result = SingleNumber2.singleNumber(nums)
    result shouldEqual 99
  }
}
