package array

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SubsetsTest extends AnyFunSuite {
  test("can get all sub sets") {
    val nums = Array(1, 2, 3)
    val result = Subsets.subsets(nums)
    result.length shouldEqual 8
  }
}
