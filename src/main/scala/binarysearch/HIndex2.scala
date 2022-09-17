package binarysearch

object HIndex2 {
  def hIndex(citations: Array[Int]): Int =
    var (low, high) = (0, citations.length - 1)
    while low <= high do
      val mid = low + (high - low) / 2
      if (citations.length - mid) > citations(mid) then low = mid + 1
      else high = mid - 1
    citations.length - low
}
