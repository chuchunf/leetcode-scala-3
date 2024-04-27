package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class ContainsDuplicateTest extends AnyFunSuite {
  test("can detect duplicates") {
    val nums = Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
    val result = ContainsDuplicate.containsDuplicate(nums)
    result shouldEqual true
  }

  test("can detect duplicates false") {
    val nums = Array(1, 2, 3, 4)
    val result = ContainsDuplicate.containsDuplicate(nums)
    result shouldEqual false
  }
}
