package twopointers

object SortColors {
  def sortColors(nums: Array[Int]): Unit = _sortColors(nums, _sortColors(nums, 0, 0), 1)

  private def _sortColors(nums: Array[Int], start: Int, target: Int): Int =
    var lp = start
    while nums(lp) == target do lp = lp + 1
    var rp = lp + 1
    while rp < nums.length do {
      if nums(rp) == target then
        nums(rp) = nums(lp)
        nums(lp) = target
        lp = lp + 1
      end if
      rp = rp + 1
    }
    lp
}
