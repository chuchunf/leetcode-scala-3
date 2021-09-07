package array

object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit =
    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k)
    reverse(nums, k + 1, nums.length - 1)

  private def reverse(nums: Array[Int], sp: Int, ep: Int): Unit =
    var (s, e) = (sp, ep)
    while s < e do
      val tmp = nums(e)
      nums(e) = nums(s)
      nums(s) = tmp
      s = s + 1
      e = e - 1
}
