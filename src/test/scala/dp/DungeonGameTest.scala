package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class DungeonGameTest extends AnyFunSuite {
  test("can find min hp") {
    val dungeon = Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))
    val result = DungeonGame.calculateMinimumHP(dungeon)
    result shouldEqual (7)
  }
}
