package bit

// 136. Single Number
object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = nums.reduceLeft { case (acc, num) => acc ^ num }
}
