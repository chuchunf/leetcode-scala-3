package binarysearch

class VersionControl(badversion: Int) {
  def isBadVersion(version: Int): Boolean = version >= badversion
}

class FirstBadVersion(badversion: Int) extends VersionControl(badversion) {
  def firstBadVersion(n: Int): Int =
    var (low, high) = (1, n)
    while low < high do {
      val mid = low + (high - low) / 2
      if !isBadVersion(mid) then low = mid + 1
      else high = mid
    }
    low
}
