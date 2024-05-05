package monotonicstack

object NextGreaterElement2 {
  def nextGreaterElements(nums: Array[Int]): Array[Int] =
    val result = Array.fill(nums.length)(-1)
    val stack = scala.collection.mutable.Stack[Int]()
    for (i <- 0 until nums.length * 2) {
      while (stack.nonEmpty && nums(stack.top) < nums(i % nums.length))
        result(stack.pop()) = nums(i % nums.length)
      stack.push(i % nums.length)
    }
    result
}
