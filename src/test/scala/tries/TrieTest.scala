package tries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class TrieTest extends AnyFunSuite {
  test("can create a trie") {
    val trie = Trie.empty[Int]
    trie.insert("i", 10)
    trie.insert("am", 20)
    trie.insert("a", 30)
    trie.insert("trie", 40)
    println(s"trie=$trie")

    var result = trie.search("i")
    result shouldEqual (Some(10))

    trie.delete("am")
    println(s"$trie")

    result = trie.search("am")
    result shouldEqual (None)
  }
}
