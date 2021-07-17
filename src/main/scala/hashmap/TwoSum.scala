package hashmap

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    import scala.collection.mutable
    val cache = mutable.Map[Int, Int]()

    nums.zipWithIndex
      .find(pair => cache.get(target - pair._1) match {
        case Some(_) => true
        case _ => cache.put(pair._1, pair._2); false
      }) match
      case Some((num, index)) => Array(cache.get(target - num).get, index)
      case _ => throw new IllegalArgumentException("invalid parameter, no valid result!")
}
