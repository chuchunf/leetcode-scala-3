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
    pq.poll() shouldEqual 4
    pq.poll() shouldEqual 3
    pq.poll() shouldEqual 2
    pq.poll() shouldEqual 1
  }
}
