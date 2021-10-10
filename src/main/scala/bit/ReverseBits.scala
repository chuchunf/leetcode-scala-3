package bit

object ReverseBits {
  def reverseBits(x: Int): Int = (0 to 31).foldLeft(0) { case (result, index) => (result << 1) | (x >> index & 1) }
}
