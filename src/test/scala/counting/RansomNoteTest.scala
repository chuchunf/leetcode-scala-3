package counting

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RansomNoteTest extends AnyFunSuite {
  test("can construct the rasom note") {
    val ransom = "aa"
    val magazine = "aab"
    val result = RansomNote.canConstruct(ransom, magazine)
    result shouldEqual (true)
  }

  test("can not construct the rasom note") {
    val ransom = "aabb"
    val magazine = "aab"
    val result = RansomNote.canConstruct(ransom, magazine)
    result shouldEqual (false)
  }
}
