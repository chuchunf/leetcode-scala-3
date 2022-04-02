package heap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class RelativeRanksTest extends AnyFunSuite {
  test("can find relative rank of sorted") {
    val score = Array(5, 4, 3, 2, 1)
    val result = RelativeRanks.findRelativeRanks(score)
    result(0) shouldEqual "Gold Medal"
    result(1) shouldEqual "Silver Medal"
    result(2) shouldEqual "Bronze Medal"
    result(3) shouldEqual "4"
    result(4) shouldEqual "5"
  }

  test("can find relative rank of unsorted") {
    val score = Array(10, 3, 8, 9, 4)
    val result = RelativeRanks.findRelativeRanks(score)
    result(0) shouldEqual "Gold Medal"
    result(1) shouldEqual "5"
    result(2) shouldEqual "Bronze Medal"
    result(3) shouldEqual "Silver Medal"
    result(4) shouldEqual "4"
  }
}
