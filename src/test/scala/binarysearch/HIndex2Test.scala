package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class HIndex2Test extends AnyFunSuite {
  test("can get h index") {
    val citations = Array(0, 1, 3, 5, 6)
    val result = HIndex2.hIndex(citations)
    result shouldEqual 3
  }
}
