package dp

object ClimbingStairs {
  def climbStairs(n: Int): Int = n match
    case n if n <= 2 => n
    case _ => (2 until n).foldLeft((1, 2)) { case ((n_2, n_1), _) => (n_1, n_2 + n_1) }._2
}
