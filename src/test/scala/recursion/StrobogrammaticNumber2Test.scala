package recursion

import linkedlist.LinkedListNode
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class StrobogrammaticNumber2Test extends AnyFunSuite {
  test("can generate for 0") {
    val result = StrobogrammaticNumber2.generate(0)
    result shouldEqual Array("")
  }

  test("can generate for 1") {
    val result = StrobogrammaticNumber2.generate(1)
    result shouldEqual Array("0", "1", "8")
  }

  test("can generate for 2") {
    val result = StrobogrammaticNumber2.generate(2)
    result shouldEqual Array("11", "69", "88", "96")
  }

  test("can generate for 3") {
    val result = StrobogrammaticNumber2.generate(3)
    result shouldEqual Array("101", "609", "906", "808", "111", "619", "916", "818", "181", "689", "986", "888")
  }

  test("can generate for 4") {
    val result = StrobogrammaticNumber2.generate(4)
    result shouldEqual Array("1111", "6119", "9116", "8118", "1691", "6699", "9696", "8698", "1881", "6889", "9886", "8888", "1961", "6969", "9966", "8968")
  }
}
