package graph

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class CourseScheduleTest extends AnyFunSuite {
  test("can finish") {
    val values = Array(Array(1, 0))
    val result = CourseSchedule.canFinish(2, values)
    result shouldEqual true
  }

  test("can not finish") {
    val values = Array(Array(1, 0), Array(0, 1))
    val result = CourseSchedule.canFinish(2, values)
    result shouldEqual false
  }
}
