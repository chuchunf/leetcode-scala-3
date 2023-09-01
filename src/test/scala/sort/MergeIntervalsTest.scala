package sort

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MergeIntervalsTest extends AnyFunSuite {
  test("can merge single interval") {
    val internals = Array(Array(1, 4))
    val result = MergeIntervals.merge(internals)
    result shouldEqual Array(Array(1, 4))
  }

  test("can merge connected overlap interval ") {
    val internals = Array(Array(1, 4), Array(4, 7))
    val result = MergeIntervals.merge(internals)
    result shouldEqual Array(Array(1, 7))
  }

  test("can merge overlap interval ") {
    val internals = Array(Array(1, 4), Array(2, 7))
    val result = MergeIntervals.merge(internals)
    result shouldEqual Array(Array(1, 7))
  }

  test("can merge completed overlap interval ") {
    val internals = Array(Array(1, 7), Array(2, 3))
    val result = MergeIntervals.merge(internals)
    result shouldEqual Array(Array(1, 7))
  }
}
