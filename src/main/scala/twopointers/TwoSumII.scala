package twopointers

object TwoSumII {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] =
    var (lp, rp) = (0, numbers.length - 1)
    while lp < rp && numbers(lp) + numbers(rp) != target do
      numbers(lp) + numbers(rp) match
        case sum if sum < target => lp = lp + 1
        case _ => rp = rp - 1
    Array(lp + 1, rp + 1)
}
