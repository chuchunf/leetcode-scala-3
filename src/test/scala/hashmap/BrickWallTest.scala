package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class BrickWallTest extends AnyFunSuite {
  test("can find the min number") {
    val wall = List(List(1, 2, 2, 1), List(3, 1, 2), List(1, 3, 2), List(2, 4), List(3, 1, 2), List(1, 3, 1, 1))
    val result = BrickWall.leastBricks(wall)
    result shouldEqual (2)
  }
}
