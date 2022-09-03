package twopointers

object StringCompression {
  def compress(chars: Array[Char]): Int =
    val compressed = (chars :+ 'A').zipWithIndex.foldLeft(("", 0)) {
      case ((result, lp), (char, rp)) =>
        if chars(lp) == char then (result, lp)
        else {
          val str = if (rp - lp) == 1 then "" else (rp - lp).toString
          (s"$result${chars(lp).toString}$str", rp)
        }
    }._1
    compressed.zipWithIndex.foreach { case (char, index) => chars(index) = char }
    compressed.length
}
