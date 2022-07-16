package dp

object JumpGame {
  def canJump(nums: Array[Int]): Boolean = _canJump(0, nums.length, nums, Array.ofDim[Option[Boolean]](nums.length))

  def _canJump(current: Int, n: Int, nums: Array[Int], cache: Array[Option[Boolean]]): Boolean =
    if cache(current) != null then cache(current).get
    else if nums(current) + current > n then true
    else (1 to nums(current)).foldLeft(false) { case (result, i) =>
      val iresult = _canJump(current + i, n, nums, cache)
      cache(current + i) = Some(iresult)
      result || iresult
    }
}
