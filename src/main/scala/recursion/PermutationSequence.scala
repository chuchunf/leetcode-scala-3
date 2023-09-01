package recursion

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object PermutationSequence {
  def getPermutation(n: Int, k: Int): String =
    val (factorial, numbers) = (ArrayBuffer[Int]().addOne(1), ArrayBuffer[Int]())
    for (i <- 2 to n) factorial.addOne(factorial.last * i)
    for (i <- 1 to n) numbers.addOne(i)
    _getPermutation(n, k, factorial, numbers, "")

  @tailrec
  private def _getPermutation(n: Int, k: Int, factorial: ArrayBuffer[Int], nums: ArrayBuffer[Int], buffer: String): String = n match
    case 1 => buffer + nums(0)
    case _ => val i = (k - 1) / factorial(n - 2)
      val num = nums(i)
      nums.remove(i)
      _getPermutation(n - 1, k % factorial(n - 2), factorial, nums, buffer + num.toString)
}
