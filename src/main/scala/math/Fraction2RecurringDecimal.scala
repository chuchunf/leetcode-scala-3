package math

import scala.collection.mutable

object Fraction2RecurringDecimal {
  def fractionToDecimal(numerator: Int, denominator: Int): String =
    val sign = if numerator * denominator > 0 then "" else "-"
    var (num, dev) = (numerator.abs.toLong, denominator.abs.toLong)
    val result = StringBuffer("")
    result.append(num / dev)
    num = num % dev
    if num != 0 then {
      result.append(".")
      val cache = mutable.HashMap[Long, Int]()
      cache.put(num, result.length())
      while num != 0 do
        num = num * 10
        result.append(num / dev)
        num = num % dev
        if !cache.contains(num) then cache.put(num, result.length()) else {
          result.insert(cache.get(num).get, '(')
          result.append(")")
          num = 0
        }
    }
    s"$sign${result.toString}"
}
