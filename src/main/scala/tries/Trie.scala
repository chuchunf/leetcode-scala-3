package tries

class Trie[T](var value: Option[T], var children: List[Option[Trie[T]]]) {
  def search(key: String): Option[T] = search(this, key, 0)

  def insert(key: String, value: T): Unit = insert(this, key, value, 0)

  def delete(key: String): Unit = delete(this, key, 0)

  private def search(node: Trie[T], key: String, step: Int): Option[T] =
    if key.length == step then node.value
    else
      node.children(key.charAt(step) - 97) match
        case Some(next) => search(next, key, step + 1)
        case _ => None

  private def insert(node: Trie[T], key: String, value: T, step: Int): Unit =
    if key.length == step then node.value = Option(value)
    else {
      val index = key.charAt(step) - 97
      val child = node.children(index).getOrElse(Trie.empty[T])
      node.children = node.children.updated(index, Some(child))
      insert(child, key, value, step + 1)
    }

  private def delete(node: Trie[T], key: String, step: Int): Unit =
    if key.length == step then node.value = None
    else node.children(key.charAt(step) - 97).map(delete(_, key, step + 1))

  override def toString: String =
    val buffer = new StringBuilder(128)
    print(buffer, "", "", ' ')
    buffer.toString

  private def print(buffer: StringBuilder, prefix: String, childPrefix: String, index: Char): Unit =
    buffer.append(prefix)
    buffer.append("[" + index + "]")
    if (this.value.isDefined) buffer.append("(" + this.value.get.toString + ")")
    buffer.append(System.lineSeparator())
    var first = true
    this.children.zipWithIndex.foreach { case (child, index) => {
      child match
        case Some(trie) =>
          if !first then trie.print(buffer, childPrefix + "\\   ", childPrefix + "    ", (97 + index).toChar)
          else {
            trie.print(buffer, childPrefix + "+    ", childPrefix + "|    ", (97 + index).toChar)
            first = false
          }
        case None =>
    }}
}

object Trie {
  def empty[T] = new Trie[T](None, List.fill(26)(None))

  def apply[T] = empty[T]
}
