package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class TwoSumTest extends AnyFunSuite {
  test("can handle simple happy case") {
    val nums = Array(2, 7, 11, 15)
    val target = 9
    val result = TwoSum.twoSum(nums, target)
    result shouldEqual Array(0, 1)
  }

  test("can handle duplicate values") {
    val nums = Array(3, 3)
    val target = 6
    val result = TwoSum.twoSum(nums, target)
    result shouldEqual Array(0, 1)
  }

  test("can handle invalid cases") {
    val nums = Array(3, 5)
    val target = 6
    assertThrows[IllegalArgumentException] {
      TwoSum.twoSum(nums, target)
    }
  }

  test("can handle invalid input") {
    val nums = Array(3)
    val target = 6
    assertThrows[IllegalArgumentException] {
      TwoSum.twoSum(nums, target)
    }
  }
}
