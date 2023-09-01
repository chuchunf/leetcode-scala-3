package stack

object LongestValidParentheses {
  def longestValidParentheses(s: String): Int =
    val stack = new MinStack[Character]()
    var (max, count) = (0, 0)
    s.foreach {
      case '(' => stack.push('(')
      case _ => if stack.isEmpty then {
        max = max.max(count * 2)
        count = 0
      } else {
        stack.pop()
        count = count + 1
      }
    }
    max.max(count * 2)
}
