package string

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class PartitionLabelsTest extends AnyFunSuite {
  test("can get partition") {
    val str = "ababcbacadefegdehijhklij"
    val result = PartitionLabels.partitionLabels(str)
    result shouldEqual List(9, 7, 8)
  }
}
