package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BullsandCowsTest extends AnyFunSuite {
  test("can find bulls and cows") {
    val (secret, guess) = ("1807", "7810")
    val result = BullsandCows.getHint(secret, guess)
    result shouldEqual "1A3B"
  }

  test("can find when there duplicates") {
    val (secret, guess) = ("1123", "0111")
    val result = BullsandCows.getHint(secret, guess)
    result shouldEqual "1A1B"
  }
}
