package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class MyStackTest extends AnyFunSuite {
  test("can behave as a stack") {
    val mystack = new MyStack[Integer]()
    mystack.push(1)
    mystack.push(1)
    mystack.push(2)
    val top = mystack.top()
    top shouldEqual 2
    val result = mystack.pop()
    result shouldEqual 2
    val isempty = mystack.empty()
    isempty shouldEqual false
  }
}
