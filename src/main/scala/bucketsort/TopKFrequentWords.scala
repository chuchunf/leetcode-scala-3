package bucketsort

import scala.collection.mutable

object TopKFrequentWords {
  def topKFrequent(words: Array[String], k: Int): List[String] =
    words.foldLeft(mutable.HashMap[String, Int]()) { case (frequencyMap, word) =>
      frequencyMap.update(word, frequencyMap.getOrElse(word, 0) + 1)
      frequencyMap
    }.foldLeft(Array.fill(words.length + 1)(mutable.ListBuffer[String]())) { case (bucket, (word, counts)) =>
      bucket(counts).addOne(word)
      bucket
    }.foldRight(mutable.ListBuffer[String]()) { case (unsorted, result) =>
      result.addAll(unsorted.sorted)
      result
    }.take(k)
      .toList
}
