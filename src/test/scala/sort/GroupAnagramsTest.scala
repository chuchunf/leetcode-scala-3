package sort

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class GroupAnagramsTest extends AnyFunSuite {
  test("can group anagrams") {
    val strs = Array("eat", "tea", "tan", "ate", "nat", "bat")
    val result = GroupAnagrams.groupAnagrams(strs)
    result shouldEqual List(List("eat", "tea", "ate"), List("bat"), List("tan", "nat"))
  }

  test("can group anagrams of 1 element") {
    val strs = Array("eat")
    val result = GroupAnagrams.groupAnagrams(strs)
    result shouldEqual List(List("eat"))
  }
}
