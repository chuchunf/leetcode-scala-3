package greedy

object GasStation {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int =
    gas.zip(cost).zipWithIndex.find { case ((g, c), i) =>
      if g - c < 0 then false else {
        var (left, next) = (g - c, if i + 1 >= gas.length then 0 else i + 1)
        while left >= 0 && next != i do {
          left = left + gas(next) - cost(next)
          next = if next + 1 >= gas.length then 0 else next + 1
        }
        left >= 0
      }
    }.getOrElse(((0, 0), -1))._2
}
