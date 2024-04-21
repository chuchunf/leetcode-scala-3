package dfs

import dfs.WordLadder
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class WordLadderTest extends AnyFunSuite {
  test("can find word ladder") {
    val words = List("hot","dot","dog","lot","log","cog")
    val result = WordLadder.ladderLength("hit", "cog", words)
    result shouldEqual 5
  }

  test("can not find word ladder") {
    val words = List("hot","doz","dog","loz","log","cog")
    val result = WordLadder.ladderLength("hit", "cog", words)
    result shouldEqual 0
  }
}
