package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class Numberof1BitsTest extends AnyFunSuite {
  test("can count number of 1 bits") {
    val result = Numberof1Bits.hammingWeight(11)
    result shouldEqual 3
  }

  test("can count number of 1 bits of negative int") {
    val result = Numberof1Bits.hammingWeight(-3)
    result shouldEqual 31
  }
}
