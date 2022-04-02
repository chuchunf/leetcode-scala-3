package heap

object RelativeRanks {
  def findRelativeRanks(score: Array[Int]): Array[String] =
    val (pq, buffer) = (new PriorityQueue[Int](score.length), Array.ofDim[String](score.length))
    score.zipWithIndex.foreach { case (num, index) => pq.offer(index, num) }
    for (n <- 0 until buffer.length) {
      buffer(pq.poll()) = n match
        case 0 => "Gold Medal"
        case 1 => "Silver Medal"
        case 2 => "Bronze Medal"
        case n => (n + 1).toString
    }
    buffer
}
