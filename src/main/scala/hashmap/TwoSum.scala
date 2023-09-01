package hashmap

import scala.collection.mutable

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    val cache = mutable.Map[Int, Int]()
    nums.zipWithIndex.find { case (value, index) => cache.get(target - value) match
      case Some(_) => true
      case _ => cache.put(value, index).isDefined
    } match
      case Some((num, index)) => Array(cache(target - num), index)
      case _ => throw new IllegalArgumentException("invalid parameter, no valid result!")
}
