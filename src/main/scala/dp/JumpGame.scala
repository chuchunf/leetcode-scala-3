package dp

object JumpGame {
  def canJump(nums: Array[Int]): Boolean = _canJump(0, nums.length, nums, Array.fill[Option[Boolean]](nums.length)(None))

  def _canJump(current: Int, n: Int, nums: Array[Int], cache: Array[Option[Boolean]]): Boolean =
    if cache(current).nonEmpty then cache(current).get
    else if nums(current) + current > n then true
    else (1 to nums(current)).foldLeft(false) { case (result, i) =>
      cache(current + i) = Some(_canJump(current + i, n, nums, cache))
      result || cache(current + i).get
    }
}
