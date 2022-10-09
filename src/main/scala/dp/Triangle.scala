package dp

object Triangle {
  def minimumTotal(triangle: List[List[Int]]): Int =
    _minimumTotal(0, 0, triangle, Array.fill(triangle.length, triangle.last.length)(-1))

  private def _minimumTotal(level: Int, i: Int, triangle: List[List[Int]], cache: Array[Array[Int]]): Int =
    if level == triangle.size then 0
    else {
      if cache(level)(i) == -1 then
        cache(level)(i) = triangle(level)(i)
          + _minimumTotal(level + 1, i, triangle, cache).min(_minimumTotal(level + 1, i + 1, triangle, cache))
      cache(level)(i)
    }
}
