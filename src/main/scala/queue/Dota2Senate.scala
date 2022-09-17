package queue

import scala.collection.mutable

object Dota2Senate {
  def predictPartyVictory(senate: String): String =
    val (qr, qd) = (mutable.ArrayDeque[Int](), mutable.ArrayDeque[Int]())
    senate.zipWithIndex.foreach {
      case ('R', index) => qr.addOne(index)
      case (_, index) => qd.addOne(index)
    }
    while qr.nonEmpty && qd.nonEmpty do
      val (ri, di) = (qr.removeHead(), qd.removeHead())
      if ri < di then qr.addOne(senate.length + ri) else qd.addOne(senate.length + di)
    if qr.size > qd.size then "Radiant" else "Dire"
}
