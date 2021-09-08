package string

import scala.collection.mutable

object SubstringwithConcatenationofAllWords {
  def findSubstring(s: String, words: Array[String]): List[Int] =
    val len = words(0).length
    val ss = s.grouped(len).toArray
    val map = mutable.HashMap[String, Int]()
    words.foreach { word => map.update(word, map.get(word).getOrElse(0) + 1) }
    ss.zipWithIndex.filter { case (word, index) => {
      val wordmap = mutable.HashMap[String, Int]().addAll(map)
      for (n <- 0 until words.length if n + index < ss.length) wordmap.update(ss(index + n), map.get(ss(index + n)).getOrElse(0) - 1)
      wordmap.values.count(_ != 0) == 0
    }}.map { case (_, index) => { index * len }}
      .toList
}
