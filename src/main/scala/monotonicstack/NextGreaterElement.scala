package monotonicstack

object NextGreaterElement {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    val map = scala.collection.mutable.Map[Int, Int]()
    val stack = scala.collection.mutable.Stack[Int]()

    for (num <- nums2)
      while (stack.nonEmpty && stack.top < num)
        map += (stack.pop() -> num)
      stack.push(num)

    nums1.map(num => map.getOrElse(num, -1))
}
