package string

object OneEditDistance {
  def isOneEditDistance(s: String, t: String): Boolean =
    if s.length == t.length then s.toCharArray.zip(t.toCharArray).count { case (sc, tc) => { !sc.equals(tc) }} == 1
    else {
      val (ss, ls) = if s.length > t.length then (t, s) else (s, t)
      var (count, sp, lp) = (0, 0, 0)
      while lp < ls.length do
        if ss(sp) != ls(lp) then count = count + 1 else sp = sp + 1
        lp = lp + 1
      count == 1
    }
}
