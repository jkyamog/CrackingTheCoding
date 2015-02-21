package cracking.the.coding

import scala.collection.SortedMap

object DecimalToRoman extends App {
  val romanMap = SortedMap(
    1 -> "I",
    5 -> "V",
    10 -> "X",
    50 -> "L",
    100 -> "C"
  )

  // 58 -> LVIII
  // 44 -> XLIV

  def toRoman(value: Int, romanValue: Int): String = {
    if (value == 0) "" else {
      val n = value / romanValue
      val r = value % romanValue
      val lowerRomanValue = prevRoman(romanValue)

      val lowerDecimalValue = romanValue - lowerRomanValue

      if (n > 0) {
        val repeatedRoman = (1 to n).map(_ => romanMap(romanValue))
        repeatedRoman.mkString + toRoman(r, lowerRomanValue)
      } else if (n == 0 && (lowerDecimalValue <= r)) {
        romanMap(lowerRomanValue) + romanMap(romanValue) + toRoman(value - lowerDecimalValue, lowerRomanValue)
      } else toRoman(value, lowerRomanValue)
    }
  }

  def prevRoman(romanValue: Int): Int = {
    romanMap.keys.toSeq.reverse.find(_ < romanValue).getOrElse(1)
  }

  println(toRoman(44, 100))
  println(toRoman(58, 100))
  println(toRoman(200, 100))
  println(toRoman(222, 100))
  println(toRoman(1, 1))

}
