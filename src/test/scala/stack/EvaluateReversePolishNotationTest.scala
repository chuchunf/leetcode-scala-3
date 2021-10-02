package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import stack.MinStack

class EvaluateReversePolishNotationTest extends AnyFunSuite {
  test("can evalute \"2\",\"1\",\"+\",\"3\",\"*\"") {
    val tokens = Array("2", "1", "+", "3", "*")
    val result = EvaluateReversePolishNotation.evalRPN(tokens)
    result shouldEqual (9)
  }

  test("can evalute \"4\",\"13\",\"5\",\"/\",\"+\"") {
    val tokens = Array("4", "13", "5", "/", "+")
    val result = EvaluateReversePolishNotation.evalRPN(tokens)
    result shouldEqual (6)
  }

  test("can evalute \"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"") {
    val tokens = Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
    val result = EvaluateReversePolishNotation.evalRPN(tokens)
    result shouldEqual (22)
  }

}
