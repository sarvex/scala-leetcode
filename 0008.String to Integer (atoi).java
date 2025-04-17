internal class Solution {
    fun myAtoi(s: String?): Int {
        if (s == null) return 0
        val n = s.length
        if (n == 0) return 0
        var i = 0
        while (s.get(i) == ' ') {
            // 仅包含空格
            if (++i == n) return 0
        }
        var sign = 1
        if (s.get(i) == '-') sign = -1
        if (s.get(i) == '-' || s.get(i) == '+') ++i
        var res = 0
        val flag = Int.Companion.MAX_VALUE / 10
        while (i < n) {
            // 非数字，跳出循环体
            if (s.get(i) < '0' || s.get(i) > '9') break
            // 溢出判断
            if (res > flag || (res == flag && s.get(i) > '7')) return if (sign > 0) Int.Companion.MAX_VALUE else Int.Companion.MIN_VALUE
            res = res * 10 + (s.get(i).code - '0'.code)
            ++i
        }
        return sign * res
    }
}