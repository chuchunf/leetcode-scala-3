package binarysearch

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class FirstBadVersionTest extends AnyFunSuite {
  test("can find the 1st bad version") {
    val result = new FirstBadVersion(4).firstBadVersion(10)
    result shouldEqual 4
  }
}
