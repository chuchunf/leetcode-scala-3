package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SqrtTest extends AnyFunSuite {
  test("can get sqrt of <= 4") {
    Sqrt.mySqrt(0) shouldEqual (0)
    Sqrt.mySqrt(1) shouldEqual (1)
    Sqrt.mySqrt(2) shouldEqual (1)
    Sqrt.mySqrt(3) shouldEqual (1)
    Sqrt.mySqrt(4) shouldEqual (2)

  }

  test("can get sqrt of 16") {
    val result = Sqrt.mySqrt(16)
    result shouldEqual (4)
  }

  test("can get sqrt of 17") {
    val result = Sqrt.mySqrt(15)
    result shouldEqual (3)
  }
}
