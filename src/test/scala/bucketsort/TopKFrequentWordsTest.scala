package bucketsort

import bucketsort.TopKFrequentElements
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import tree.TreeNode

class TopKFrequentWordsTest extends AnyFunSuite {
  test("can sort by frequency") {
    val words = Array("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
    val result = TopKFrequentWords.topKFrequent(words, 4)
    result shouldEqual List("the", "is", "sunny", "day")
  }

  test("can sort by frequency with same frequency") {
    val words = Array("i", "love", "leetcode", "i", "love", "coding")
    val result = TopKFrequentWords.topKFrequent(words, 2)
    result shouldEqual List("i", "love")
  }
}
