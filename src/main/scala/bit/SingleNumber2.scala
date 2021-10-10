package bit

object SingleNumber2 {
  def singleNumber(nums: Array[Int]): Int =
    (0 to 31).foldLeft(0) { case (result, shift) =>
      nums.foldLeft(0) { case (count, num) =>
        if ((num >> shift) & 1) == 1 then (count + 1) % 3 else count
      } << shift | result
    }
}
