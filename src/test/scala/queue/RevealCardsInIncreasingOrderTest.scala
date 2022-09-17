package queue

import matrix.SpiralMatrix
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RevealCardsInIncreasingOrderTest extends AnyFunSuite {
  test("can reveal cards") {
    val deck = Array(17, 13, 11, 2, 3, 5, 7)
    val result = RevealCardsInIncreasingOrder.deckRevealedIncreasing(deck)
    result shouldEqual Array(2, 13, 3, 11, 5, 17, 7)
  }
}
