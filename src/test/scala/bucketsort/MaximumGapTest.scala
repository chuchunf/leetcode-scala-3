package bucketsort

import bucketsort.MaximumGap
import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MaximumGapTest extends AnyFunSuite {
  test("can find max gap") {
    val nums = Array(3, 6, 9, 1)
    val result = MaximumGap.maximumGap(nums)
    result shouldEqual 3
  }
}
