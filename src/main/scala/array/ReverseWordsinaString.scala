package array

import scala.collection.mutable

object ReverseWordsinaString {
  def reverseWords(s: String): String =
    var array = mutable.ArrayBuffer[Char]().addAll(s)
    swapArray(array, 0, array.size - 1)
    array = removeExtraSapce(array)
    swapWords(array)
    array.mkString

  private def swapWords(array: mutable.ArrayBuffer[Char]): Unit =
    var (s, e) = (0, 0)
    while e < array.size do
      while e < array.size && array(e).isLetterOrDigit do e = e + 1
      swapArray(array, s, e - 1)
      e = e + 1
      s = e

  private def removeExtraSapce(array: mutable.ArrayBuffer[Char]): mutable.ArrayBuffer[Char] =
    var (a, c) = (0, 0)
    while c < array.size do
      while c < array.size && array(c).isSpaceChar do c = c + 1
      while c < array.size && array(c).isLetterOrDigit do
        array(a) = array(c)
        a = a + 1
        c = c + 1
      while c < array.size && array(c).isSpaceChar do c = c + 1
      if c < array.size then {
        array(a) = ' '
        a = a + 1
      }
    array.slice(0, a)

  private def swapArray(array: mutable.ArrayBuffer[Char], from: Int, to: Int): Unit =
    var (l, r) = (from, to)
    while l < r do
      val tmp = array(r)
      array(r) = array(l)
      array(l) = tmp
      l = l + 1
      r = r - 1
}
