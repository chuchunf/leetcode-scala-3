package twopointers

object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int =
    var (max, left, right) = (0, 0, height.length - 1)
    while left < right do
      max = max.max(height(left).min(height(right)) * (right - left))
      if height(left) > height(right) then right = right - 1
      else left = left + 1
    max
}
