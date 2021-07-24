package string

import scala.collection.mutable

object ZigZagConversion {
  def convert(s: String, numRows: Int): String = numRows match
    case 1 => s
    case _ => val cache = (0 to numRows - 1).map(_ => new mutable.ArrayBuffer[Char]()).toArray
      var (pos, num, down) = (0, 0, true)
      while pos < s.length do
        cache(num).append(s.charAt(pos))
        pos = pos + 1
        num = if down then num + 1 else num - 1
        if num == numRows then {
          down = false
          num = numRows - 2
        }
        if num == -1 then {
          down = true
          num = 1
        }
      cache.reduce(_ ++ _).mkString("")
}
