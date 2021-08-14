package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class IsomorphicStringsTest extends AnyFunSuite {
  test("can detect a valid one") {
    val (s, t) = ("egg", "add")
    val result = IsomorphicStrings.isIsomorphic(s, t)
    result shouldEqual (true)
  }

  test("can detect an invalid case") {
    val (s, t) = ("foo", "bar")
    val result = IsomorphicStrings.isIsomorphic(s, t)
    result shouldEqual (false)
  }
}
