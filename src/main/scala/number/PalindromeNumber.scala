package number

object PalindromeNumber {
  def isPalindrome(x: Int): Boolean =
    var (org, result) = (x, 0)
    while org > result do
      result = result * 10
      result = result + org % 10
      org = org / 10
    org == result || org == result / 10
}
