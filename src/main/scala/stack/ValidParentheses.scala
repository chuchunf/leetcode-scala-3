package stack

object ValidParentheses {
  def isValid(s: String): Boolean =
    val stack = new MinStack[Character]()
    val map = Map(')' -> '(', ']' -> '[', '}' -> '{')
    s.toArray.find(char => char match {
      case '(' | '[' | '{' => stack.push(char); false
      case ')' | ']' | '}' => if (stack.pop() == map(char)) then false else true
      case _ => false
    }).isEmpty
}
