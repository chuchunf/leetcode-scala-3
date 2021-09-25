package math

object PowXn {
  def myPow(x: Double, n: Int): Double = (x, n) match
    case (in, pow) if pow == 1 => in
    case (in, pow) if pow < 0 => myPow(1 / in, -pow)
    case (in, pow) if pow % 2 == 0 => myPow(in * in, pow / 2)
    case (in, pow) => in * myPow(in * in, (pow - 1) / 2)
}
