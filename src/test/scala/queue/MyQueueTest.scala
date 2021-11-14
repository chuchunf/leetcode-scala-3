package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MyQueueTest extends AnyFunSuite {
  test("can work as queue") {
    val queue = new MyQueue[Integer]()
    queue.push(1)
    queue.push(2)
    val peek = queue.peek()
    peek shouldEqual (1)
    val pop = queue.pop()
    pop shouldEqual (1)
    val empty = queue.empty()
    empty shouldEqual (false)
  }
}
