package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SqrtTest extends AnyFunSuite {
  test("can get sqrt of 16") {
    val result = Sqrt.mySqrt(16)
    result shouldEqual (4)
  }

  test("can get sqrt of 17") {
    val result = Sqrt.mySqrt(17)
    result shouldEqual (4)
  }
}
