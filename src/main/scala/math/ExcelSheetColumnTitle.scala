package math

object ExcelSheetColumnTitle {
  def convertToTitle(columnNumber: Int): String = columnNumber match
    case 0 => ""
    case num => convertToTitle(num / 26) + ((num % 26) + 64).toChar
}
