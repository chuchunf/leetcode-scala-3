package stack

object EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int =
    val stack = new MinStack[Integer]()
    tokens.foreach {
      _ match
        case "+" => stack.push(stack.pop() + stack.pop())
        case "*" => stack.push(stack.pop() * stack.pop())
        case "-" => stack.push(-stack.pop() + stack.pop())
        case "/" => stack.push((1.0 / stack.pop().toDouble * stack.pop()).toInt)
        case num => stack.push(num.toInt)
    }
    stack.pop()
}
