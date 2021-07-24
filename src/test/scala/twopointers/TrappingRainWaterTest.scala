package twopointers

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class TrappingRainWaterTest extends AnyFunSuite {
  test("can trap water") {
    val height = Array(4, 2, 0, 3, 2, 5)
    val water = TrappingRainWater.trap(height)
    water shouldEqual (9)
  }
}
