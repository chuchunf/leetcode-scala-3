package tree

sealed class TreeNode[T](var value: T, var left: Option[TreeNode[T]], var right: Option[TreeNode[T]]) {
  override def toString: String =
    val buffer = new StringBuilder(128)
    print(buffer, "", "")
    buffer.toString

  private def print(buffer: StringBuilder, prefix: String, childPrefix: String): Unit =
    buffer.append(prefix)
    buffer.append(this.value)
    buffer.append(System.lineSeparator())
    if right.isDefined then {
      if left.isDefined then right.get.print(buffer, childPrefix + "+   ", childPrefix + "|   ")
      else right.get.print(buffer, childPrefix + "\\  ", childPrefix + "    ")
    }
    if left.isDefined then left.get.print(buffer, childPrefix + "\\   ", childPrefix + "    ")
}

object TreeNode {
  def apply[T](value: T): TreeNode[T] = new TreeNode(value, None, None)
}
