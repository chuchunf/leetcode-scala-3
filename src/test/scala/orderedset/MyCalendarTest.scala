package orderedset

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MyCalendarTest extends AnyFunSuite {
  test("can add non-overlap") {
    val cal = new MyCalendar()
    cal.book(10, 20) shouldEqual true
    cal.book(30, 40) shouldEqual true
  }

  test("can not add if start overlap") {
    val cal = new MyCalendar()
    cal.book(10, 20) shouldEqual true
    cal.book(15, 30) shouldEqual false
  }

  test("can not add if end overlap") {
    val cal = new MyCalendar()
    cal.book(30, 40) shouldEqual true
    cal.book(10, 35) shouldEqual false
  }
}
