package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class IntersectionofTwoLinkedListsTest extends AnyFunSuite {
  test("can not find intersection") {
    val (heada, headb) = (new LinkedListNode[Int](2, None), new LinkedListNode[Int](1, None))
    heada.append(6).append(4)
    headb.append(5)
    val result = IntersectionofTwoLinkedLists.getIntersectionNode(heada, headb)
    result shouldEqual None
  }

  test("can find intersection with same length") {
    val (heada, headb) = (new LinkedListNode[Int](2, None), new LinkedListNode[Int](1, None))
    val intersect = new LinkedListNode[Int](3, None)
    intersect.append(4).append(5)
    heada.next = Option(intersect)
    headb.next = Option(intersect)
    val result = IntersectionofTwoLinkedLists.getIntersectionNode(heada, headb)
    result.get shouldEqual intersect
  }

  test("can find intersection with diff length") {
    val (heada, headb) = (new LinkedListNode[Int](2, None), new LinkedListNode[Int](1, None))
    val intersect = new LinkedListNode[Int](4, None)
    intersect.append(5).append(6)
    val heada2 = new LinkedListNode[Int](3, None)
    heada.next = Option(heada2)
    heada2.next = Option(intersect)
    headb.next = Option(intersect)
    val result = IntersectionofTwoLinkedLists.getIntersectionNode(heada, headb)
    result.get shouldEqual intersect
  }
}
