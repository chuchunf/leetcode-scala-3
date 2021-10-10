package bit

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RepeatedDNASequencesTest extends AnyFunSuite {
  test("can find repeating sequence") {
    val s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    val result = RepeatedDNASequences.findRepeatedDnaSequences(s)
    result shouldEqual (List("AAAAACCCCC", "CCCCCAAAAA"))
  }
}
