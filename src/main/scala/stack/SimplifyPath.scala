package stack

object SimplifyPath {
  def simplifyPath(path: String): String =
    val stack = new MinStack[String]()
    path.split("/")
      .foreach { _ match
          case ".." => if !stack.isEmpty() then stack.pop()
          case str => if !str.isEmpty && !".".equals(str) then stack.push(str)
      }
    var result = ""
    while !stack.isEmpty() do result = "/" + stack.pop() + result
    if result.isEmpty then "/" else result
}
