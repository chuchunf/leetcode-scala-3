package prefixsum

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ProductofArrayExceptSelfTest extends AnyFunSuite {
  test("can get product of rest") {
    val nums = Array(2, 3, 4, 5)
    val result = ProductofArrayExceptSelf.productExceptSelf(nums)
    result shouldEqual Array(60, 40, 30, 24)
  }

  test("can get product of rest with zero") {
    val nums = Array(2, 3, 4, 0)
    val result = ProductofArrayExceptSelf.productExceptSelf(nums)
    result shouldEqual Array(0, 0, 0, 24)
  }

  test("can get product of rest with 2 zeroes") {
    val nums = Array(2, 0, 4, 0)
    val result = ProductofArrayExceptSelf.productExceptSelf(nums)
    result shouldEqual Array(0, 0, 0, 0)
  }
}
