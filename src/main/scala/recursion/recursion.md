#Recursion
Recursion solves problems where the solution depends on solutions to smaller instances of the same problem by using functions that call themselves from within their own code.
- Works with tree/linked list etc. recursive data structures 
- Recursion normally could be converted to Iteration via a Stack

Implement the recursion function 
- Identify recursion case => a problem could be resolved by re-apply same function
- Assume we already find the function then identify exit condition

### 21. Merge Two Sorted Lists
```scala
  def mergeTwoLists(l1: LinkedListNode[Int], l2: LinkedListNode[Int]): LinkedListNode[Int] = mergeTwolistsInternal(Option(l1), Option(l2)).get

  private def mergeTwolistsInternal(l1: Option[LinkedListNode[Int]], l2: Option[LinkedListNode[Int]]): Option[LinkedListNode[Int]] =
    (l1, l2) match
      case (None, None) => None
      case (Some(_), None) => l1
      case (None, Some(_)) => l2
      case (Some(n1), Some(n2)) => if n1.value < n2.value then {
        n1.next = mergeTwolistsInternal(n1.next, l2)
        l1
      } else {
        n2.next = mergeTwolistsInternal(l1, n2.next)
        l2
      }
```