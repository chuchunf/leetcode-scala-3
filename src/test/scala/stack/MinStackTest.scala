package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import stack.MinStack

class MinStackTest extends AnyFunSuite {
  test("can work as a stack!") {
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

  test("can pop elements") {
    val minStack = new MinStack[Integer]()
    assertThrows[IllegalArgumentException] {
      minStack.pop()
    }
    minStack.push(1)
    val result = minStack.pop()
    result shouldEqual (1)
  }

  test("can clear all elements") {
    val minStack = new MinStack[Integer]()
    minStack.push(1)
    val top = minStack.top()
    top shouldEqual (1)
    val min = minStack.getMin()
    min shouldEqual (1)
    minStack.clear()
    assertThrows[IllegalArgumentException] {
      minStack.top()
    }
    assertThrows[IllegalArgumentException] {
      minStack.getMin()
    }
    val empty = minStack.isEmpty()
    empty shouldEqual (true)
  }

  test("can print itself as string") {
    val minStack = new MinStack[Integer]()
    minStack.push(1)
    minStack.push(2)
    val result = minStack.toString()
    result shouldEqual ("2->1")
  }
}
