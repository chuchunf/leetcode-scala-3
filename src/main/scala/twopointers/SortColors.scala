package twopointers

object SortColors {
  def sortColors(nums: Array[Int]): Unit = sortColorsInternal(nums, sortColorsInternal(nums, 0, 0), 1)

  private def sortColorsInternal(nums: Array[Int], start: Int, target: Int): Int =
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
