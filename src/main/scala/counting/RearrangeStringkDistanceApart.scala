package counting

import scala.collection.mutable

object RearrangeStringkDistanceApart {
  def rearrangeString(str: String, k: Int): String =
    str.foldLeft(mutable.HashMap[Char, Int]()) { case (frequencyMap, char) => {
      frequencyMap.update(char, frequencyMap.get(char).getOrElse(0) + 1)
      frequencyMap
    }}.foldLeft(Array.fill(str.length + 1)(mutable.ListBuffer[Char]())) { case (bucket, (char, counts)) => {
      bucket(counts).addOne(char)
      bucket
    }}.zipWithIndex.foldRight((Array.fill[Char](str.length)(' '), 0)) { case ((chars, count), (buffer, index)) => {
      (buffer, chars.foldLeft(0) { case (offset, char) => {
        for (i <- 0 until count) {
          if i * k + index + offset > str.length then return ""
          else buffer(i * k + index + offset) = char
        }
        offset + 1
      }})
    }}._1.mkString
}
