package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ZigzagIteratorTest extends AnyFunSuite {
  test("can zigzag list with same length") {
    val l1 = List(1, 2)
    val l2 = List(3, 4)
    val i = new ZigzagIterator(l1, l2)
    i.next shouldEqual 1
    i.next shouldEqual 3
    i.next shouldEqual 2
    i.next shouldEqual 4
    i.hasNext shouldEqual false
  }

  test("can zigzag list with diff length") {
    val l1 = List(1, 2, 3)
    val l2 = List(4, 5)
    val i = new ZigzagIterator(l1, l2)
    i.next shouldEqual 1
    i.next shouldEqual 4
    i.next shouldEqual 2
    i.next shouldEqual 5
    i.next shouldEqual 3
    i.hasNext shouldEqual false
  }

  test("can zigzag list with empty list") {
    val l1 = List[Int]()
    val l2 = List(3, 4)
    val i = new ZigzagIterator(l1, l2)
    i.next shouldEqual 3
    i.next shouldEqual 4
    i.hasNext shouldEqual false
  }
}
