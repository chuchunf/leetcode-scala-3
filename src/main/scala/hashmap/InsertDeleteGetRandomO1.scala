package hashmap

import scala.collection.mutable

class InsertDeleteGetRandomO1() {
  private val map = mutable.Map[Int, Int]()
  private val array = mutable.ArrayBuffer[Int]()
  private val random = new scala.util.Random

  def insert(value: Int): Boolean =
    if map.contains(value) then
      false
    else {
      map.put(value, array.length)
      array.addOne(value)
      true
    }

  def remove(value: Int): Boolean =
    if !map.contains(value) then
      false
    else {
      array(map.get(value).get) = array(array.length - 1)
      array.dropRight(1)
      true
    }

  def getRandom(): Int = array(random.nextInt(array.length))
}
