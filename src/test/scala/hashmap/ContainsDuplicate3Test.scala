package hashmap

import hashmap.ContainsDuplicate3
import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ContainsDuplicate3Test extends AnyFunSuite {
  test("can find duplicates when t = 0") {
    val nums = Array(1, 2, 3, 1)
    val result = ContainsDuplicate3.containsNearbyAlmostDuplicate(nums, 3, 0)
    result shouldEqual true
  }

  test("can find duplicates when t > 0") {
    val nums = Array(1, 0, 1, 1)
    val result = ContainsDuplicate3.containsNearbyAlmostDuplicate(nums, 1, 2)
    result shouldEqual true
  }

  test("can not find duplicates") {
    val nums = Array(1, 5, 9, 1, 5, 9)
    val result = ContainsDuplicate3.containsNearbyAlmostDuplicate(nums, 2, 3)
    result shouldEqual false
  }
}
