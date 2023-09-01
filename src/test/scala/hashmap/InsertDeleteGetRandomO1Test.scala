package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class InsertDeleteGetRandomO1Test extends AnyFunSuite {
  test("can function as required") {
    val set = new InsertDeleteGetRandomO1()
    set.insert(1) shouldEqual (true)
    set.remove(2) shouldEqual (false)
    set.insert(2) shouldEqual (true)
    set.remove(1) shouldEqual (true)
    set.insert(2) shouldEqual (false)
    set.getRandom shouldEqual (2)
  }
}
