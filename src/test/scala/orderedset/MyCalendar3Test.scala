package orderedset

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MyCalendar3Test extends AnyFunSuite {
  test("can detect the max") {
    val calendar = new MyCalendar3()
    calendar.book(10, 20) shouldEqual 1
    calendar.book(50, 60) shouldEqual 1
    calendar.book(10, 40) shouldEqual 2
    calendar.book(5, 15) shouldEqual 3
    calendar.book(5, 10) shouldEqual 3
    calendar.book(25, 55) shouldEqual 3
  }
}
