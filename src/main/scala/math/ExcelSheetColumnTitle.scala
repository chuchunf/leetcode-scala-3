package math

object ExcelSheetColumnTitle {
  def convertToTitle(columnNumber: Int): String = columnNumber match
    case 0 => ""
    case num => convertToTitle(columnNumber / 26) + ((columnNumber % 26) + 64).toChar
}
