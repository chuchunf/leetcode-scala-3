package counting

import scala.collection.mutable

object TopKFrequentElements {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] =
    nums.foldLeft(mutable.HashMap[Int, Int]()) { case (frequencyMap, num) => {
      frequencyMap.update(num, frequencyMap.get(num).getOrElse(0) + 1)
      frequencyMap
    }}.foldLeft(Array.fill(nums.length + 1)(mutable.ListBuffer[Int]())) { case (bucket, (num, counts)) => {
      bucket(counts).addOne(num)
      bucket
    }}.foldRight(mutable.ListBuffer[Int]()) { case (result, nums) => {
      result.addAll(nums)
      result
    }}.takeRight(k)
      .toArray
}
