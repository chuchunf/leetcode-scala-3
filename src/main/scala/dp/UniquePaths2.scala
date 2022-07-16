package dp

object UniquePaths2 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int =
    _uniquePaths(0, 0, obstacleGrid, Array.fill[Option[Int]](obstacleGrid.length, obstacleGrid(0).length)(None))

  private def _uniquePaths(c: Int, r: Int, grid: Array[Array[Int]], cache: Array[Array[Option[Int]]]): Int =
    if cache(c)(r).nonEmpty then cache(c)(r).get
    else if grid(c)(r) == 1 then 0
    else if c == grid.length - 1 && r == grid(0).length - 1 then 1
    else {
      val result = if c == grid.length - 1 then _uniquePaths(c, r + 1, grid, cache)
      else if r == grid(0).length - 1 then _uniquePaths(c + 1, r, grid, cache)
      else _uniquePaths(c, r + 1, grid, cache) + _uniquePaths(c + 1, r, grid, cache)
      cache(c)(r) = Some(result)
      result
    }
}
