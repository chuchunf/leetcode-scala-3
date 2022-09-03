package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ContainerWithMostWaterTest extends AnyFunSuite {
  test("can handle minimum case") {
    val a = Array(1, 1)
    val result = ContainerWithMostWater.maxArea(a)
    result shouldEqual 1
  }

  test("can handle normal case") {
    val a = Array(4, 3, 2, 1, 4)
    val result = ContainerWithMostWater.maxArea(a)
    result shouldEqual 16
  }

  test("can handle normal case from right") {
    val a = Array(4, 1, 2, 3, 4)
    val result = ContainerWithMostWater.maxArea(a)
    result shouldEqual 16
  }

  test("can handle leetcode case") {
    val a = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val result = ContainerWithMostWater.maxArea(a)
    result shouldEqual 49
  }
}
