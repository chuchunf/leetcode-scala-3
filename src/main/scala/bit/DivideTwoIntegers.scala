package bit

object DivideTwoIntegers {
  def divide(dividend: Int, divisor: Int): Int =
    val sign = if (divisor ^ dividend) >= 0 then 1 else -1
    var (dvd, dvs, result, count) = (dividend.abs, divisor.abs, 0, 0)
    while dvd > dvs do
      while dvd > (dvs << count) do count = count + 1
      result = result + (1 << (count - 1))
      dvd = dvd - (dvs << (count - 1))
      count = 0
    result * sign
}
