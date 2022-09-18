package recursion

object StrobogrammaticNumber2 {
  def generate(n: Int): Array[String] = n match
    case 0 => Array("")
    case 1 => Array("0", "1", "8")
    case 2 => Array("11", "69", "88", "96")
    case _ => generate(n - 2).flatMap(num => Array("1" + num + "1", "6" + num + "9", "9" + num + "6", "8" + num + "8"))
}
