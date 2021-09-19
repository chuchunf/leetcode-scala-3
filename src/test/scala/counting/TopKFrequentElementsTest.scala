package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class TopKFrequentElementsTest extends AnyFunSuite {
  test("can take k elements") {
    val nums = Array(1, 1, 1, 2, 2, 3)
    val result = TopKFrequentElements.topKFrequent(nums, 2)
    result shouldEqual (Array(2, 1))
  }

  test("can take 1 element") {
    val nums = Array(1)
    val result = TopKFrequentElements.topKFrequent(nums, 1)
    result shouldEqual (Array(1))
  }
}
