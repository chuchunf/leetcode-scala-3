package bit

object ConvertaNumbertoHexadecimal {
  def toHex(num: Int): String = num match
    case 0 => "0"
    case n => "0123456789abcdef".charAt(n & 15).toString + (if n >>> 4 != 0 then toHex(n >>> 4) else "")
}
