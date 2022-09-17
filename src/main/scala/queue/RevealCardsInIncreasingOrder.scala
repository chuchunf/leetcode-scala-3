package queue

import scala.collection.mutable

object RevealCardsInIncreasingOrder {
  def deckRevealedIncreasing(deck: Array[Int]): Array[Int] =
    deck.sorted.reverse
      .foldLeft(mutable.ArrayDeque[Int]()) { case (q, num) =>
        if q.nonEmpty then q.prepend(q.removeLast())
        q.prepend(num)
      }.toArray
}
