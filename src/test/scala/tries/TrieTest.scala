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
    trie.toString shouldEqual (
      """[ ]
        |+    [a](30)
        ||    +    [m](20)
        |\   [i](10)
        |\   [t]
        |    +    [r]
        |    |    +    [i]
        |    |    |    +    [e](40)
        |""".stripMargin)

    var result = trie.search("trie")
    result shouldEqual (Some(40))

    trie.delete("am")
    trie.toString shouldEqual (
      """[ ]
        |+    [a](30)
        ||    +    [m]
        |\   [i](10)
        |\   [t]
        |    +    [r]
        |    |    +    [i]
        |    |    |    +    [e](40)
        |""".stripMargin)

    result = trie.search("am")
    result shouldEqual (None)
  }
}
