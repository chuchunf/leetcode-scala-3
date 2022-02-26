package binarysearch

object MedianofTwoSortedArrays {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double =
    val (len1, len2) = (nums1.length, nums2.length)
    if len1 < len2 then findMedianSortedArrays(nums2, nums1)
    else {
      var (low1, high1, half) = (0, len1, (len1 + len2 + 1) / 2)
      while low1 <= high1 do {
        val i = (low1 + high1) / 2
        val j = half - i
        if i < len1 && nums2(j - 1) > nums1(i) then low1 = i + 1
        else if i > 0 && nums1(i - 1) > nums2(j) then high1 = i - 1
        else {
          val maxleft = if i == 0 then nums2(j - 1) else if j == 0 then nums1(i - 1) else nums1(i - 1).max(nums2(j - 1))
          if (len1 + len2) % 2 == 1 then return maxleft
          val minright = if i == len1 then nums2(j) else if j == len2 then nums1(i) else nums1(i).min(nums2(j))
          return (maxleft + minright) / 2
        }
      }
      -1
    }
}
