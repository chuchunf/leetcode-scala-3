package stack

object ValidParentheses {
  def isValid(s: String): Boolean =
    val stack = new MinStack[Character]()
    val map = Map(')' -> '(', ']' -> '[', '}' -> '{')
    !s.toArray.exists {
      case char@('(' | '[' | '{') => stack.push(char); false
      case char@(')' | ']' | '}') => if stack.pop() == map(char) then false else true
      case _ => true
    } && stack.isEmpty
}
