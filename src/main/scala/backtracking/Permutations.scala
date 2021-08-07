package backtracking

import scala.collection.mutable

object Permutations {
  def permute(nums: Array[Int]): List[List[Int]] =
    val (result, numsbuffer) = (mutable.ListBuffer[List[Int]](), mutable.ArrayBuffer[Int]().addAll(nums))
    permuteInternal(numsbuffer, mutable.ListBuffer[Int](), result)
    result.toList

  private def permuteInternal(nums: mutable.ArrayBuffer[Int], tmp: mutable.ListBuffer[Int], result: mutable.ListBuffer[List[Int]]): Unit =
    nums match
      case mutable.ArrayBuffer() => result.append(tmp.toList)
      case _ => for (n <- 0 until nums.length)
        val remove = nums.remove(n)
        permuteInternal(nums, mutable.ListBuffer[Int]().addAll(tmp).append(remove), result)
        nums.insert(n, remove)
}
