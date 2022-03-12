package recursion

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class PermutationSequenceTest extends AnyFunSuite {
  test("can find the permutation") {
    val result = PermutationSequence.getPermutation(3, 3)
    result shouldEqual "213"
  }

  test("can find the permutation 2") {
    val result = PermutationSequence.getPermutation(4, 9)
    result shouldEqual "2314"
  }
}
