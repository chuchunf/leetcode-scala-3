package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class DistinctSubsequencesTest extends AnyFunSuite {
  test("can find rabbit") {
    val (s, t) = ("rabbbit", "rabbit")
    val result = DistinctSubsequences.numDistinct(s, t)
    result shouldEqual 3
  }

  test("can find babgbag") {
    val (s, t) = ("babgbag", "bag")
    val result = DistinctSubsequences.numDistinct(s, t)
    result shouldEqual 5
  }
}
