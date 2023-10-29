package monotonicstack

import monotonicstack.LargestRectangleinHistogram
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import stack.MinStack

class LargestRectangleinHistogramTest extends AnyFunSuite {
  test("can find largest rect") {
    val heights = Array(2, 4)
    val result = LargestRectangleinHistogram.largestRectangleArea(heights)
    result shouldEqual 4
  }

  test("can find largest rect 2") {
    val heights = Array(2, 1, 5, 6, 2, 3)
    val result = LargestRectangleinHistogram.largestRectangleArea(heights)
    result shouldEqual 10
  }
}
