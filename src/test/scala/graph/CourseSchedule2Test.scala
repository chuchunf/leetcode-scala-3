package graph

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CourseSchedule2Test extends AnyFunSuite {
  test("can find the schedule") {
    val values = Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2))
    val result = CourseSchedule2.findOrder(4, values)
    result shouldEqual Array(0, 1, 2, 3)
  }
}
