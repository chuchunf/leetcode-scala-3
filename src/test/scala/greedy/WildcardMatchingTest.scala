package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WildcardMatchingTest extends AnyFunSuite {
  test("can match without wildcard") {
    val s = "aa"
    val p = "a"
    val result = WildcardMatching.isMatch(s, p)
    result shouldEqual false
  }

  test("can match with *") {
    val s = "aa"
    val p = "*"
    val result = WildcardMatching.isMatch(s, p)
    result shouldEqual true
  }

  test("can match with ?") {
    val s = "cb"
    val p = "?a"
    val result = WildcardMatching.isMatch(s, p)
    result shouldEqual false
  }

}
