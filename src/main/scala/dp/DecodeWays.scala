package dp

object DecodeWays {
  def numDecodings(s: String): Int =
    val cache = Array.fill[Int](if s.length < 2 then 2 else s.length)(0)
    cache(0) = 1
    cache(1) = if s.charAt(0) == '0' then 1 else 2
    for (i <- 2 until s.length) {
      val (first, second) = (s.substring(i, i + 1).toInt, s.substring(i - 1, i + 1).toInt)
      if first >= 1 && first <= 9 then cache(i) = cache(i) + cache(i - 1)
      if second > 10 && second <= 26 then cache(i) = cache(i) + cache(i - 2)
    }
    cache(s.length - 1)
}