package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ScrambleStringTest extends AnyFunSuite {
  test("can scramble") {
    val (s1, s2) = ("great", "rgeat")
    val result = ScrambleString.isScramble(s1, s2)
    result shouldEqual true
  }

  test("can not scramble") {
    val (s1, s2) = ("abcde", "caebd")
    val result = ScrambleString.isScramble(s1, s2)
    result shouldEqual false
  }
}
