package hashmap

import scala.collection.mutable

object SubstringwithConcatenationofAllWords {
  def findSubstring(s: String, words: Array[String]): List[Int] =
    val (count, record, len) = (mutable.Map[String, Int](), mutable.Map[String, Int](), words(0).length)
    words.foreach(w => count.update(w, count.getOrElse(w, 0) + 1))
    val (ss, result) = (s.grouped(len).toArray, mutable.ListBuffer[Int]())
    for (i <- 0 until (ss.length - words.length)) {
      record.clear()
      if !ss.slice(i, i + words.length).exists { str =>
        record.update(str, record.getOrElse(str, 0) + 1)
        if record(str) > count.getOrElse(str, 0) then true else false
      } then result.addOne(len * i)
    }
    result.toList
}
