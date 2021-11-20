package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SlidingWindowMaximumTest extends AnyFunSuite {
  test("can find the maxs") {
    val nums = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val result = SlidingWindowMaximum.maxSlidingWindow(nums, 3)
    result shouldEqual (Array(3, 3, 5, 5, 6, 7))
  }
}
