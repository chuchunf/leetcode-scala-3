package backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class RestoreIPAddressesTest extends AnyFunSuite {
  test("can parse 25525511135") {
    val s = "25525511135"
    val result = RestoreIPAddresses.restoreIpAddresses(s)
    result shouldEqual List("255.255.11.135", "255.255.111.35")
  }

  test("can parse 0000") {
    val s = "0000"
    val result = RestoreIPAddresses.restoreIpAddresses(s)
    result shouldEqual List("0.0.0.0")
  }

  test("can parse 101023") {
    val s = "101023"
    val result = RestoreIPAddresses.restoreIpAddresses(s)
    result shouldEqual List("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")
  }
}
