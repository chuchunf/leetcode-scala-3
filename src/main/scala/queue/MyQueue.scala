package queue

import scala.collection.mutable

class MyQueue[T] {
  private val input = mutable.Stack[T]()
  private val output = mutable.Stack[T]()

  def push(x: T): Unit = input.push(x)

  def pop(): T =
    this.peek()
    output.pop()

  def peek(): T =
    if output.isEmpty then while !input.isEmpty do output.push(input.pop())
    output.head

  def empty(): Boolean = input.isEmpty && output.isEmpty
}
