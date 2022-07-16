package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class UniquePaths2Test extends AnyFunSuite {
  test("can find unique path") {
    val obstacleGrid = Array(Array(0, 0, 0), Array(0, 1, 0), Array(0, 0, 0))
    val result = UniquePaths2.uniquePathsWithObstacles(obstacleGrid)
    result shouldEqual 2
  }

  test("can find unique path without blocks") {
    val obstacleGrid = Array(Array(0, 0, 0), Array(0, 0, 0), Array(0, 0, 0))
    val result = UniquePaths2.uniquePathsWithObstacles(obstacleGrid)
    result shouldEqual 6
  }

  test("can find unique path all blocked") {
    val obstacleGrid = Array(Array(0, 1, 0), Array(1, 0, 0), Array(0, 0, 0))
    val result = UniquePaths2.uniquePathsWithObstacles(obstacleGrid)
    result shouldEqual 0
  }
}
