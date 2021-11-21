package sort

import scala.collection.mutable

object GroupAnagrams {
  def groupAnagrams(strs: Array[String]): List[List[String]] =
    val cache = mutable.HashMap[String, List[String]]()
    strs.foreach { str => cache.update(str.sorted, cache.getOrElse(str.sorted, List.empty[String]) :+ str) }
    cache.values.toList
}
