package greedy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class GasStationTest extends AnyFunSuite {
  test("can travel in cycle") {
    val gas = Array(1, 2, 3, 4, 5)
    val cost = Array(3, 4, 5, 1, 2)
    val result = GasStation.canCompleteCircuit(gas, cost)
    result shouldEqual 3
  }

  test("can not travel in cycle") {
    val gas = Array(2, 3, 4)
    val cost = Array(3, 4, 3)
    val result = GasStation.canCompleteCircuit(gas, cost)
    result shouldEqual -1
  }
}
