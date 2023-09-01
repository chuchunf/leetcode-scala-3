package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class HappyNumberTest extends AnyFunSuite {
  test("can handle 1") {
    HappyNumber.isHappy(1) shouldEqual true
  }

  test("can handle 0") {
    HappyNumber.isHappy(0) shouldEqual false
  }

  test("can handle 19") {
    HappyNumber.isHappy(19) shouldEqual true
  }
}
