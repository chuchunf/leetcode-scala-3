package math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class PowXnTest extends AnyFunSuite {
  test("can calculate power") {
    val x = 2.0
    val n = 10
    val result = PowXn.myPow(x, n)
    result shouldEqual 1024.0
  }

  test("can calculate odd power") {
    val x = 2.0
    val n = 9
    val result = PowXn.myPow(x, n)
    result shouldEqual 512.0
  }

  test("can calculate neagive power") {
    val x = 2.0
    val n = -2
    val result = PowXn.myPow(x, n)
    result shouldEqual 0.25
  }
}
