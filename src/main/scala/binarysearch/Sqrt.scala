package binarysearch

object Sqrt {
  def mySqrt(x: Int): Int = x match
    case 0 => 0
    case n if n < 4 => 1
    case 4 => 2
    case _ => var (low, mid, high) = (1, 1 + (x / 2 - 1) / 2, x / 2)
      while !(mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)) do
        if mid * mid < x then low = mid else high = mid
        mid = low + (high - low) / 2
      mid
}
