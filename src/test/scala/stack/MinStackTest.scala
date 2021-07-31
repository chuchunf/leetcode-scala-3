package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class MinStackTest extends AnyFunSuite {
  test("can work as a stack!") {
    import stack.MinStack

    val minStack = new MinStack[Integer]()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)

    var min = minStack.getMin()
    min shouldEqual (-3)
    var top = minStack.pop()
    top shouldEqual (-3)
    top = minStack.top()
    top shouldEqual (0)
    min = minStack.getMin()
    min shouldEqual (-2)
  }
}
