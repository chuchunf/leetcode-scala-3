package tries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class IndexPairsofaStringTest extends AnyFunSuite {
  test("can index pairs of a string") {
    val s = "thestoryofleetcodeandme"
    val words = List("story","fleet","leetcode")
    val result = IndexPairsofaString.indexPairs(s, words)
    result shouldEqual List(List(3, 7), List(9, 13), List(10, 17))
  }
}
