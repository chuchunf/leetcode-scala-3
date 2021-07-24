package string

import scala.collection.mutable

object PartitionLabels {
  def partitionLabels(s: String): List[Int] =
    val (cache, result) = (mutable.Map[Char, Int](), mutable.ListBuffer[Int]())
    var (i, start, end) = (0, 0, 0)
    s.zipWithIndex.foreach { case (char, index) => cache.update(char, index) }
    while i < s.length do
      end = cache.get(s.charAt(i)).get
      while end > i do
        i = i + 1
        end = end.max(cache.get(s.charAt(i)).get)
      result.append(end + 1 - start)
      i = (i + 1)
      start = i
      end = i
    result.toList
}
