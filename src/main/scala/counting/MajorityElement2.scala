package counting

object MajorityElement2 {
  def majorityElement(nums: Array[Int]): List[Int] =
    nums.foldLeft((nums(0), 0, nums(1), 0)) {
      case ((m1, c1, m2, c2), num) if num == m1 => (m1, c1 + 1, m2, c2)
      case ((m1, c1, m2, c2), num) if num == m2 => (m1, c1, m2, c2 + 1)
      case ((m1, c1, m2, c2), num) if c1 == 0 => (num, 1, m2, c2)
      case ((m1, c1, m2, c2), num) if c2 == 0 => (m1, c1, num, 1)
      case ((m1, c1, m2, c2), _) => (m1, c1 - 1, m2, c2 - 1)
    } match
      case (m1, _, m2, _) => List(m1, m2).filter(m => nums.count(_ == m) > nums.length / 3)
}
