package backtracking

import scala.collection.mutable

object GenerateParentheses {
  def generateParenthesis(n: Int): List[String] =
    val cache = mutable.ListBuffer[String]()
    generateParenthesisInternal(cache, "", 0, 0, n)
    cache.toList

  private def generateParenthesisInternal(cache: mutable.ListBuffer[String], tmp: String, open: Int, close: Int, max: Int): Unit =
    if open == max && close == max then cache.append(tmp)
    else
      if open < max then generateParenthesisInternal(cache, tmp + "(", open + 1, close, max)
      if close < open then generateParenthesisInternal(cache, tmp + ")", open, close + 1, max)
}
