package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class ReverseBitsTest extends AnyFunSuite {
  test("can reverse bit") {
    val result = ReverseBits.reverseBits(43261596)
    result shouldEqual 964176192
  }

  test("can reverse bit of negative value") {
    val result = ReverseBits.reverseBits(-11)
    result shouldEqual -1342177281
  }
}
