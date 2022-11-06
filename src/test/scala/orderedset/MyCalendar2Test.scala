package orderedset

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MyCalendar2Test extends AnyFunSuite {
  test("can add no overlap") {
    val cal = new MyCalendar2()
    cal.book(10, 20) shouldEqual true
    cal.book(30, 40) shouldEqual true
  }

  test("can add 1 overlap") {
    val cal = new MyCalendar2()
    cal.book(10, 30) shouldEqual true
    cal.book(20, 40) shouldEqual true
  }

  test("can NOT add 2 overlaps") {
    val cal = new MyCalendar2()
    cal.book(10, 30) shouldEqual true
    cal.book(20, 40) shouldEqual true
    cal.book(25, 60) shouldEqual false
  }
}
