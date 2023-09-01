package stack

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class SimplifyPathTest extends AnyFunSuite {
  test("can simplify /home/") {
    val result = SimplifyPath.simplifyPath("/home/")
    result shouldEqual "/home"
  }

  test("can simplify /../") {
    val result = SimplifyPath.simplifyPath("/../")
    result shouldEqual "/"
  }

  test("can simplify /a/./b/../../c/") {
    val result = SimplifyPath.simplifyPath("/a/./b/../../c/")
    result shouldEqual "/c"
  }
}
