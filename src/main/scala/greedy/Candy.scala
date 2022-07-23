package greedy

// 135. Candy
object Candy {
  def candy(ratings: Array[Int]): Int =
    ratings.zipWithIndex.foldLeft((0, 0)) { case ((r, p), (v, i)) =>
      if i == 0 then (1, 1) else {
        if v > ratings(i - 1) then (r + p + 1, p + 1) else {
          if p > 1 then (r + 1, 1) else {
            var (acc, pi) = (0, i)
            while pi > 0 && ratings(pi - 1) > ratings(pi) do {
              pi = pi - 1
              acc = acc + 1
            }
            (r + acc + 1, 1)
          }
        }
      }
    }._1
}
