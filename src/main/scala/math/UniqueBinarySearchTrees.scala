package math

object UniqueBinarySearchTrees {
  def numTrees(n: Int): Int = n match
    case 0 => 1
    case n if n <= 2 => n
    case n => (0 until n).foldRight(0) { case (num, acc) => acc + numTrees(num) * numTrees(n - 1 - num) }
}
