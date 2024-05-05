package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldEqual

class CourseSchedule3Test extends AnyFunSuite {
  test("can find the schedule") {
    val courses = Array(Array(100, 200), Array(200, 1300), Array(1000, 1250), Array(2000, 3200))
    val result = CourseSchedule3.scheduleCourse(courses)
    result shouldEqual 3
  }

  test("can not find the schedule") {
    val courses = Array(Array(3, 2), Array(4, 3))
    val result = CourseSchedule3.scheduleCourse(courses)
    result shouldEqual 0
  }
}
