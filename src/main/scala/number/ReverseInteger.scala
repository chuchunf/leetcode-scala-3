package number

object ReverseInteger {
  def reverse(x: Int): Int =
    var (org, result) = (x, 0)
    while org > 0 do
      result = result * 10
      result = result + org % 10
      org = org / 10
    result
}
