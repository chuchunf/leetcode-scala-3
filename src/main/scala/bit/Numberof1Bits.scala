package bit

object Numberof1Bits {
  def hammingWeight(n: Int): Int = (0 to 31).count(i => ((n >>> i) & 1) == 1)
}
