package orderedset

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ExamRoomTest extends AnyFunSuite {
  test("can create exam room & add 1st and 2nd") {
    val room = new ExamRoom(10)
    room.seat() shouldEqual 0
    room.seat() shouldEqual 9
  }

  test("can seat more") {
    val room = new ExamRoom(10)
    room.seat() shouldEqual 0
    room.seat() shouldEqual 9
    room.seat() shouldEqual 4
    room.seat() shouldEqual 2
  }

  test("can leave and seat again") {
    val room = new ExamRoom(10)
    room.seat() shouldEqual 0
    room.seat() shouldEqual 9
    room.seat() shouldEqual 4
    room.seat() shouldEqual 2
    room.leave(4)
    println(s"${room.seat()}")
  }

}
