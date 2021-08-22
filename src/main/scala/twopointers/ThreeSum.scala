package twopointers

import scala.collection.mutable

object ThreeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] =
    val result = mutable.ListBuffer[List[Int]]()
    val sorted = nums.sorted
    for (index<-0 until sorted.length) {
      if index==0 || sorted(index-1)!=sorted(index) then
        var (leftp, rightp) = (index + 1, sorted.length - 1)
        while leftp < rightp do {
          sorted(index) + sorted(leftp) + sorted(rightp) match
            case sum if sum > 0 => rightp = rightp - 1
            case sum if sum < 0 => leftp = leftp + 1
            case _ => result.append(List(sorted(index), sorted(leftp), sorted(rightp)))
              while sorted(leftp + 1) == sorted(leftp) do leftp = leftp + 1
              while sorted(rightp - 1) == sorted(rightp) do rightp = rightp - 1
              leftp = leftp + 1
              rightp = rightp - 1
        }
    }
    result.toList
}
