package array

object MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit =
    var (p1, p2) = (0, 0)
    while p1 < m do
      if n > 0 && nums1(p1) > nums2(p2) then {
        var tmp = nums2(p2)
        nums2(p2) = nums1(p1)
        nums1(p1) = tmp
      }
      p1 = p1 + 1
    for (i <- 0 until n) nums1(m + i) = nums2(i)
}
