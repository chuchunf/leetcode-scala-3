package twopointers

object ImplementstrStr {
  def strStr(haystack: String, needle: String): Int =
    haystack.toCharArray.zipWithIndex.find { case (_, index) =>
      needle.toCharArray.zipWithIndex.find { case (char2, index2) =>
        haystack(index + index2) != char2
      }.isEmpty
    }.map(_._2).getOrElse(-1)
}
