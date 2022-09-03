package twopointers

object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int =
    var (max, right, left) = (0, 0, height.length - 1)
    while right < left do
      max = max.max(height(right).min(height(left)) * (left - right))
      if height(right) > height(left) then left = left - 1
      else right = right + 1
    max
}
