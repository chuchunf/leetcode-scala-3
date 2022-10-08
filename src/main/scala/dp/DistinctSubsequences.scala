package dp

object DistinctSubsequences {
  def numDistinct(s: String, t: String): Int = _numDistinct(s, 0, t, 0, Array.fill(s.length, t.length)(-1))

  private def _numDistinct(s: String, i: Int, t: String, j: Int, cache: Array[Array[Int]]): Int =
    if j >= t.length then 1
    else if i >= s.length then 0 else {
      if cache(i)(j) == -1 then
        cache(i)(j) = s.drop(i).zipWithIndex.map { case (char, k) =>
          if char == t(j) then _numDistinct(s, i + k + 1, t, j + 1, cache) else 0
        }.sum
      cache(i)(j)
    }
}
