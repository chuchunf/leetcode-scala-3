package bit

object GrayCode {
  def grayCode(n: Int): List[Int] = n match
    case 1 => List(0, 1)
    case num => grayCode(num - 1) ::: grayCode(num - 1).reverse.map(_ | (1 << (num - 1)))
}
