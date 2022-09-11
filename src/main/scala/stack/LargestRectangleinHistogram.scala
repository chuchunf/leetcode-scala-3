package stack

object LargestRectangleinHistogram {
  def largestRectangleArea(heights: Array[Int]): Int =
    val stack = new MinStack[Integer]()
    var result = 0
    for (i <- 0 to heights.length) {
      val h = if i == heights.length then 0 else heights(i)
      while !stack.isEmpty && h < heights(stack.top()) do
        val ch = heights(stack.pop())
        val pi: Integer = if stack.isEmpty then -1 else stack.top()
        result = result.max(ch * (i - pi - 1))
      stack.push(i)
    }
    result
}
