package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SingleNumberTest extends AnyFunSuite {
  test("can get single number") {
    val nums = Array(4, 1, 2, 1, 2)
    val result = SingleNumber.singleNumber(nums)
    result shouldEqual (4)
  }
}
