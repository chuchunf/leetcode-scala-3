package dp

object InterleavingString {
  def isInterleave(s1: String, s2: String, s3: String): Boolean =
    val cache = Array.ofDim[Option[Boolean]](s1.length + 1, s2.length + 1, s3.length + 1)
    _isInterleave(s1, 0, s2, 0, s3, 0, cache, true)

  private def _isInterleave(s1: String, l1: Int, s2: String, l2: Int, s3: String, l3: Int, cache: Array[Array[Array[Option[Boolean]]]], order: Boolean): Boolean =
    if l1 == s1.length && l2 == s2.length && l3 == s3.length then true
    else if (l1 == s1.length && l3 < s3.length) || (l1 < s1.length && l3 == s3.length) then false
    else {
      val cached = if order then cache(l1)(l2)(l3) else cache(l2)(l1)(l3)
      if cached != null then cached.get else {
        val result = (l1 + 1 to s1.length).exists { i =>
          if s1.substring(l1, i).equals(s3.substring(l3, l3 + (i - l1))) then
            _isInterleave(s2, l2, s1, i, s3, l3 + (i - l1), cache, !order)
          else false
        }
        if order then cache(l1)(l2)(l3) = Some(result) else cache(l2)(l1)(l3) = Some(result)
        result
      }
    }
}
