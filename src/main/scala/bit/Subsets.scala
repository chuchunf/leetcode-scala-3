package bit

import scala.collection.mutable

object Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] =
    (0 until 1 << nums.length).collect[List[Int]] { case i1 =>
      nums.zipWithIndex
        .filter { case (num, i2) => (i1 & (1 << i2)) != 0 }
        .map(_._1)
        .toList
    }.toList
}
