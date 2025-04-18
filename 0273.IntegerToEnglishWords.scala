object Solution {
  private val belowTwenty = Array("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
  private val tens = Array("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
  private val thousands = Array("", "Thousand", "Million", "Billion")

  /**
    * Converts an integer to its English words representation.
    *
    * Integer to English Words conversion using recursion and chunking.
    * @intuition Break the number into 3-digit groups and convert each group to words recursively.
    * @approach Recursively process each 3-digit chunk, mapping numbers to words using arrays for units, tens, and thousands.
    * @space O(1) — Uses a fixed number of arrays and variables; output string size is not counted.
    * @time O(log₁₀N) — Each 3 digits are processed in constant time; overall proportional to the number of digits.
    *
    * @param num the integer to convert (0 <= num <= 2^31 - 1)
    * @return the English words representation of the number
    */
  def numberToWords(num: Int): String = {
    if (num == 0) return "Zero"

    def helper(n: Int): String = {
      if (n == 0) ""
      else if (n < 20) belowTwenty(n) + " "
      else if (n < 100) tens(n / 10) + " " + helper(n % 10)
      else belowTwenty(n / 100) + " Hundred " + helper(n % 100)
    }

    var n = num
    var i = 0
    var res = ""
    while (n > 0) {
      if (n % 1000 != 0) {
        res = helper(n % 1000) + thousands(i) + (if (res.nonEmpty) " " else "") + res
      }
      n /= 1000
      i += 1
    }
    res.trim.replaceAll(" +", " ")
  }
}
