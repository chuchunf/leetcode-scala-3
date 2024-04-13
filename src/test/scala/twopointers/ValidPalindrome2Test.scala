package twopointers

import jdk.jfr.ValueDescriptor
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import twopointers.ValidPalindrome2

class ValidPalindrome2Test extends AnyFunSuite {
  test("can validate palindrome") {
    val s = "aba"
    val result = ValidPalindrome2.validPalindrome(s)
    result shouldEqual true
  }

  test("can valid palinedrome with 1 extra char") {
    val s = "abca"
    val result = ValidPalindrome2.validPalindrome(s)
    result shouldEqual true
  }

  test("can invalid non palinedrome") {
    val s = "abc"
    val result = ValidPalindrome2.validPalindrome(s)
    result shouldEqual false
  }
}
