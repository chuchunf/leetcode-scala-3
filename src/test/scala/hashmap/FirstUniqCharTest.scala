package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class FirstUniqCharTest extends AnyFunSuite {
  test("can find the 1st unqiue character") {
    val data = "leetcode"
    val result = FirstUniqChar.firstUniqChar(data)
    result shouldEqual 0
  }

  test("can find the 1st unique character 2") {
    val data = "leetcodel"
    val result = FirstUniqChar.firstUniqChar(data)
    result shouldEqual 3
  }

  test("can throw exception if there is no unique chacter") {
    val data = "aabb"
    val result = FirstUniqChar.firstUniqChar(data)
    result shouldEqual -1
  }
}
