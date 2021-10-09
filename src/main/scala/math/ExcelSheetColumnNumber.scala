package math

object ExcelSheetColumnNumber {
  def titleToNumber(columnTitle: String): Int =
    columnTitle.foldLeft(0) { case (sum, char) => sum * 26 + (char - 'A'.toInt + 1) }
}
