package string

object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = strs match
    case Array() => ""
    case _ => var prefix = strs(0)
      strs.drop(1).foreach(str => {
        while str.indexOf(prefix) == -1 do prefix = prefix.dropRight(1)
      })
      prefix
}
