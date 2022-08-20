package hashmap

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SortCharactersByFrequencyTest extends AnyFunSuite {
  test("can sort string") {
    val str = "tree"
    val result = SortCharactersByFrequency.frequencySort(str);
    result shouldEqual "eert"
  }

  test("can sort empty string") {
    val str = ""
    val result = SortCharactersByFrequency.frequencySort(str);
    result shouldEqual ""
  }
}
