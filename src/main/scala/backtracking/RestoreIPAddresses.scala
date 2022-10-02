package backtracking

import scala.collection.mutable

object RestoreIPAddresses {
  def restoreIpAddresses(s: String): List[String] =
    val result = mutable.ListBuffer[String]()
    _restoreIPAddresses(s, 0, 0, "", result)
    result.toList

  private def _restoreIPAddresses(s: String, i: Int, dots: Int, buffer: String, result: mutable.ListBuffer[String]): Unit = dots match
    case 3 => if s.substring(i).toInt < 256 && (s.substring(i).equals("0") || !s.substring(i).startsWith("0")) then result.addOne(buffer + s.substring(i))
    case _ => for (j <- (i + 1) to (i + 3)) {
      if j < s.length && s.substring(i, j).toInt < 256 && (s.substring(i, j).equals("0") || !s.substring(i, j).startsWith("0")) then
        _restoreIPAddresses(s, j, dots + 1, buffer + s.substring(i, j) + ".", result)
    }
}
