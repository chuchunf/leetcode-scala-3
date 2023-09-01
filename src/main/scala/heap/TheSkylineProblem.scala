package heap

import scala.collection.mutable

object TheSkylineProblem {
  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] =
    val (points, result, active) = (mutable.ArrayBuffer[Array[Int]](), mutable.ArrayBuffer[List[Int]](), mutable.HashSet[Int](-1))
    val heap = new PriorityQueue[(Int, Int)]()
    heap.offer((0, -1), 0)
    buildings.zipWithIndex.foreach { case (a, i) => points.addAll(Array(Array(a(0), a(2), 1, i), Array(a(1), a(2), -1, i))) }
    points.sortWith { case (b1, b2) => if b1(0) != b2(0) then b1(0) < b2(0) else b1(1) * b1(2) > b2(1) * b2(2) }
      .foreach { case Array(x, h, lr, i) =>
        if lr == 1 then active.add(i) else active.remove(i)
        if lr == 1 then {
          if !heap.isEmpty && h > heap.peek()._1 then result.addOne(List(x, h))
          heap.offer((h, i), h)
        } else {
          while !heap.isEmpty && !active.contains(heap.peek()._2) do heap.poll()
          if !heap.isEmpty && heap.peek()._1 != result.last(1) then result.addOne(List(x, heap.peek()._1))
        }
      }
    result.toList
}
