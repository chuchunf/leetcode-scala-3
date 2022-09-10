package string

object CompareVersionNumbers {
  def compareVersion(version1: String, version2: String): Int =
    val (vs1, vs2) = (version1.split("\\."), version2.split("\\."))
    for (i <- 0 until vs1.length.max(vs2.length)) {
      val v1v = if i >= vs1.length then 0 else getVersion(vs1(i))
      val v2v = if i >= vs2.length then 0 else getVersion(vs2(i))
      if v1v != v2v then return v1v.compare(v2v)
    }
    0

  private def getVersion(v: String): Int = v.indexWhere(c => c.isDigit && !c.isSpaceChar) match
    case len if len >= v.length => 0
    case len => v.substring(len).toInt
}
