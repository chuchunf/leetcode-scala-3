package number

import scala.collection.mutable

object MultiplyStrings {
  def multiply(num1: String, num2: String): String =
    val cache = (0 to num2.length - 1).map(_ => new mutable.ArrayBuffer[Char]()).toArray
    num2.reverse.toArray.zipWithIndex.foreach { case (n2, index) => {
      var (line, carry) = (cache(index), 0)
      (0 until index).foreach(_ => line.append('0'))
      num1.reverse.toArray.foreach(n1 => {
        val mul = (n1 - '0') * (n2 - '0') + carry
        line.append((mul % 10 + '0').toChar)
        carry = mul / 10
      })
    }}

    cache.reduce((l1, l2) => {
      val len = l1.length.max(l2.length)
      val result = mutable.ArrayBuffer[Char]()
      var carry = 0
      for (i <- 0 until len) {
        val sum = carry + (if i < l1.length then l1(i) - '0' else 0) + (if i < l2.length then l2(i) - '0' else 0)
        result.append((sum % 10 + '0').toChar)
        carry = sum / 10
      }
      result
    }).mkString.reverse
}