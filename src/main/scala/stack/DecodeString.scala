package stack

object DecodeString {
  def decodeString(s: String): String =
    val (numstack, strstack) = (new MinStack[Integer](), new MinStack[String]())
    var (i, j) = (0, 0)
    while i < s.length do {
      s(i) match
        case '[' => i = i + 1
        case ']' => i = i + 1
          var tmp = strstack.pop() * numstack.pop()
          while !strstack.isEmpty do tmp = strstack.pop() + tmp
          strstack.push(tmp)
        case num if Character.isDigit(num) => j = i
          while Character.isDigit(s(j)) do j = j + 1
          numstack.push(s.substring(i, j).toInt)
          i = j
        case _ => j = i
          while j < s.length && Character.isAlphabetic(s(j)) do j = j + 1
          strstack.push(s.substring(i, j))
          i = j
    }
    val result = strstack.pop()
    if strstack.isEmpty then result else strstack.pop() + result
}
