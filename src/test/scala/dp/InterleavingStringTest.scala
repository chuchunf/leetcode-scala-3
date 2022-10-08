package dp

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*

class InterleavingStringTest extends AnyFunSuite {
  test("is interleaving simple") {
    val (s1, s2, s3) = ("aa", "bb", "aabb")
    val result = InterleavingString.isInterleave(s1, s2, s3)
    result shouldEqual true
  }

  test("is interleaving") {
    val (s1, s2, s3) = ("aabcc", "dbbca", "aadbbcbcac")
    val result = InterleavingString.isInterleave(s1, s2, s3)
    result shouldEqual true
  }

  test("is not interleaving") {
    val (s1, s2, s3) = ("aabcc", "dbbca", "aadbbbaccc")
    val result = InterleavingString.isInterleave(s1, s2, s3)
    result shouldEqual false
  }
}

