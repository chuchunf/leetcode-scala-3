package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MajorityElementTest extends AnyFunSuite {
  test("can find major") {
    val nums = Array(3, 2, 3)
    val result = MajorityElement.majorityElement(nums)
    result shouldEqual (3)
  }

  test("can find major in longer array") {
    val nums = Array(2, 2, 1, 1, 1, 2, 2)
    val result = MajorityElement.majorityElement(nums)
    result shouldEqual (2)
  }
}
