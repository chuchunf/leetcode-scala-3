package bucketsort

import scala.collection.mutable

object SortCharactersByFrequency {
  def frequencySort(s: String): String =
    val (map, bucket) = (mutable.Map[Char, Int](), Array.fill(s.length + 1)(mutable.ListBuffer[Char]()))
    s.foreach { c => map.update(c, map.getOrElse(c, 0) + 1) }
    map.foreach((char, count) => bucket(count).addOne(char))
    bucket.zipWithIndex
      .foldRight("") { case ((list, count), str) =>
        str + list.foldLeft("") { case (result, char) => result + char.toString * count }
      }
}
