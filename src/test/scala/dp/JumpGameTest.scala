package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class JumpGameTest extends AnyFunSuite {
  test("can test jump true") {
    val nums = Array(2, 3, 1, 1, 4)
    val result = JumpGame.canJump(nums)
    result shouldEqual true
  }

  test("can test jump false") {
    val nums = Array(3, 2, 1, 0, 4)
    val result = JumpGame.canJump(nums)
    result shouldEqual false
  }
}
