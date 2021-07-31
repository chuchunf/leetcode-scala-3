package array

import scala.collection.mutable

object Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] =
    val cache = mutable.ListBuffer[List[Int]]()
    cache.addOne(List[Int]())
    nums.foreach(num => {
      val temp = mutable.ListBuffer[List[Int]]()
      cache.foreach(list => temp.addOne(mutable.ListBuffer[Int]().addAll(list).addOne(num).toList))
      cache.addAll(temp)
    })
    cache.toList
}
