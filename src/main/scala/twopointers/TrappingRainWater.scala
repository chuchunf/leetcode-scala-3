package twopointers

object TrappingRainWater {
  def trap(height: Array[Int]): Int =
    var (water, left, right) = (0, 0, height.length - 1)
    while left < right && height(left) <= height(left + 1) do left = left + 1
    while left < right && height(right - 1) >= height(right) do right = right - 1
    while right > (left + 1) do
      var (lefth, righth) = (height(left), height(right))
      if lefth > righth then {
        while height(right - 1) < righth do
          water = water + righth - height(right - 1)
          right = right - 1
      } else {
        while lefth > height(left + 1) do
          water = water + lefth - height(left + 1)
          left = left + 1
      }
    water
}
