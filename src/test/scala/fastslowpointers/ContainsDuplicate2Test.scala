package fastslowpointers

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ContainsDuplicate2Test extends AnyFunSuite {
  test("can find duplicates") {
    val nums = Array(1, 2, 3, 1)
    val k = 3
    val result = ContainsDuplicate2.containsNearbyDuplicate(nums, k)
    result shouldEqual (true)
  }

  test("can not find duplicates") {
    val nums = Array(1, 2, 3, 1, 2, 3)
    val k = 2
    val result = ContainsDuplicate2.containsNearbyDuplicate(nums, k)
    result shouldEqual (false)
  }
}
