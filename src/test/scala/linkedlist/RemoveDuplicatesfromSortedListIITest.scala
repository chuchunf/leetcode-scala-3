package linkedlist

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class RemoveDuplicatesfromSortedListIITest extends AnyFunSuite {
  test("can remove duplicates") {
    val head = new LinkedListNode[Int](1, None)
    head.append(2).append(3).append(3).append(4).append(4).append(5)
    var result = RemoveDuplicatesfromSortedListII.deleteDuplicates(head);
    result.value shouldEqual (1)
    result = result.next.get
    result.value shouldEqual (2)
    result = result.next.get
    result.value shouldEqual (3)
    result = result.next.get
    result.value shouldEqual (5)
  }
}
