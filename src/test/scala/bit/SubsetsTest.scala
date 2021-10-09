package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SubsetsTest extends AnyFunSuite {
  test("can get all sub sets") {
    val nums = Array(1, 2, 3)
    val result = Subsets.subsets(nums)
    result shouldEqual (List(List(), List(1), List(2), List(1, 2), List(3), List(1, 3), List(2, 3), List(1, 2, 3)))
  }
}
