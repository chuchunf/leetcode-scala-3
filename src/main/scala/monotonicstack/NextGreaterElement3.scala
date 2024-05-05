package monotonicstack

object NextGreaterElement3 {
  def nextGreaterElement(n: Int): Int =
    val stack = scala.collection.mutable.Stack[Int]()
    val str = n.toString
    for (i <- str.length - 1 to 0 by -1) {
      if stack.nonEmpty && str.charAt(stack.top) > str.charAt(i) then {
        val result = str.substring(0, i) + str.charAt(stack.pop())
        stack.push(i)
        return (result + stack.map(str.charAt).sorted.mkString).toInt
      }
      stack.push(i)
    }
    -1
}
