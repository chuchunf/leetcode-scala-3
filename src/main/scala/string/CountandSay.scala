package string

object CountandSay {
  def countAndSay(n: Int): String =
    (1 until n).foldLeft("1") { case (result, _) =>
      println(s"n=$n, result=$result")
      (result + "A").zipWithIndex.foldLeft(("", 0)) {
        case ((sb, lp), (char, rp)) if rp == 0 || char == result(rp - 1) => (sb, lp)
        case ((sb, lp), (_, rp)) => (s"$sb${rp - lp}${result(rp - 1).toString}", rp)
      }._1
    }
}

