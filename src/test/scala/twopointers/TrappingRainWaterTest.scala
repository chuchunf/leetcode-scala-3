package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class TrappingRainWaterTest extends AnyFunSuite {
  test("can trap water") {
    val height = Array(4, 2, 0, 3, 2, 5)
    val water = TrappingRainWater.trap(height)
    water shouldEqual (9)
  }

  test("can trap water with low edges") {
    val height = Array(1, 4, 2, 0, 3, 2, 5, 1)
    val water = TrappingRainWater.trap(height)
    water shouldEqual (9)
  }

  test("can trap water from right") {
    val height = Array(5, 2, 3, 0, 2, 4)
    val water = TrappingRainWater.trap(height)
    water shouldEqual (9)
  }
}
