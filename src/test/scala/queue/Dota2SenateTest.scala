package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class Dota2SenateTest extends AnyFunSuite {
  test("can vote with same number of D and R") {
    val senate = "RD"
    val result = Dota2Senate.predictPartyVictory(senate)
    result shouldEqual "Radiant"
  }

  test("can vote with diff number of D and R") {
    val senate = "RDD"
    val result = Dota2Senate.predictPartyVictory(senate)
    result shouldEqual "Dire"
  }
}
