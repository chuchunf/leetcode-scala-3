package heap

object KthLargestElementinanArray {
  def findKthLargest(nums: Array[Int], k: Int): Int =
    val pq = new PriorityQueue[Int](unique = false)
    nums.foreach(num => pq.offer(num, num))
    (0 until k).map(_ => pq.poll()).last
}
