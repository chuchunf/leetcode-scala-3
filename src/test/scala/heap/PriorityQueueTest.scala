package heap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class PriorityQueueTest extends AnyFunSuite {
  test("can function as priority queue") {
    val pq = new PriorityQueue[Int]()
    pq.offer(1, 1)
    pq.offer(4, 4)
    pq.offer(3, 3)
    pq.offer(2, 2)

    pq.length() shouldEqual 4

    pq.poll() shouldEqual 4
    pq.poll() shouldEqual 3
    pq.poll() shouldEqual 2
    pq.poll() shouldEqual 1
  }

  test("can function as min priority queue") {
    val pq = new PriorityQueue[Int](128, (a, b) => a < b)
    pq.offer(1, 1)
    pq.offer(4, 4)
    pq.offer(3, 3)
    pq.offer(2, 2)

    pq.length() shouldEqual 4

    pq.poll() shouldEqual 1
    pq.poll() shouldEqual 2
    pq.poll() shouldEqual 3
    pq.poll() shouldEqual 4
  }

  test("can confirm uniqueness of the queue") {
    val pq = new PriorityQueue[Int]()
    pq.offer(1, 1) shouldEqual true
    pq.offer(1, 1) shouldEqual false
    pq.length() shouldEqual 1
    pq.poll() shouldEqual 1
  }

  test("can handle non-unique element") {
    val pq = new PriorityQueue[Int](unique = false)
    pq.offer(1, 1)
    pq.offer(4, 4)
    pq.offer(3, 3)
    pq.offer(1, 1)

    pq.length() shouldEqual 4

    pq.poll() shouldEqual 4
    pq.poll() shouldEqual 3
    pq.poll() shouldEqual 1
    pq.poll() shouldEqual 1
  }
}
