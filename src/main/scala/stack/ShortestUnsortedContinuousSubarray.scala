package stack

object ShortestUnsortedContinuousSubarray {
  def findUnsortedSubarray(nums: Array[Int]): Int =
    def getEnd(nums: Array[Int]): Int =
      var (end, stack) = (nums.length, new MinStack[Integer]())
      nums.zipWithIndex.foreach { case (num, index) => {
        while (!stack.isEmpty() && nums(stack.top()) > num) do end = end.min(stack.pop())
        stack.push(index)
      }}
      end + 1

    val (left, right) = (getEnd(nums), nums.length - getEnd(nums.reverse))
    if right > left then right - left + 1 else 0
}
