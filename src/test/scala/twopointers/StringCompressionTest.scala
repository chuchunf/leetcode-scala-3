package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class StringCompressionTest extends AnyFunSuite {
  test("can count Array with 1 element") {
    val chars = Array[Char]('a')
    val result = StringCompression.compress(chars)
    result shouldEqual 1
  }

  test("can count Array with repeating elements") {
    val chars = Array[Char]('a', 'a', 'b', 'b', 'c', 'c', 'c')
    val result = StringCompression.compress(chars)
    result shouldEqual 6
  }

  test("can count Array with repeating elements with more than 10 occurrence") {
    val chars = Array[Char]('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')
    val result = StringCompression.compress(chars)
    result shouldEqual 4
  }

  test("can count 3 single elements") {
    val chars = Array[Char]('a', 'b', 'c')
    val result = StringCompression.compress(chars)
    println(s"result=$result, chars=${chars.mkString}")
  }
}
