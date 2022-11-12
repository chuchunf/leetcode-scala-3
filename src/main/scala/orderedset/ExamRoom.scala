package orderedset

import scala.collection.mutable

class ExamRoom(n: Int) {
  private[this] val dists = mutable.TreeSet[(Int, Int)]()(DistOrdering)
  private[this] val points = mutable.TreeMap[Int, mutable.Set[Int]]()

  def seat(): Int = points.size match
    case 0 => points(0) = mutable.Set[Int]().addOne(n - 1)
      0
    case 1 => points(n - 1) = mutable.Set[Int]().addOne(0)
      dists.addOne((0, n - 1))
      n - 1
    case _ => val (begin, end) = dists.head
      val mid: Int = begin + (end - begin) / 2
      dists.addOne((begin, mid)).addOne((mid, end)).remove((begin, end))
      points(mid) = mutable.Set[Int]().addOne(begin).addOne(end)
      points(begin).addOne(mid).remove(end)
      points(end).addOne(mid).remove(begin)
      mid

  def leave(p: Int): Unit =
    val ps = points.remove(p).get.toList
    val (begin, end) = if ps.head > ps.last then (ps.last, ps.head) else (ps.head, ps.last)
    dists.remove((begin, p))
    dists.remove(p, end)
    dists.add(begin, end)

  object DistOrdering extends Ordering[(Int, Int)] {
    def compare(key1: (Int, Int), key2: (Int, Int)): Int = ((key2._2 - key2._1) / 2).compareTo((key1._2 - key1._1) / 2)
  }
}
