package heap

object UglyNumber2 {
  def nthUglyNumber(n: Int): Int = n match
    case s if s < 7 => s
    case b => val (pq, factors) = (new PriorityQueue[Int](n * 2, (a, b) => a < b), Array(2, 3, 5))
      var (last, count) = (1, 1)
      while count < n do {
        count = count + 1
        factors.foreach(n => pq.offer(n * last, n * last))
        last = pq.poll()
      }
      last
}
