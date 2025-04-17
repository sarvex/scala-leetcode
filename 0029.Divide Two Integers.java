internal class Solution {
    fun divide(a: Int, b: Int): Int {
        var a = a
        var b = b
        if (b == 1) {
            return a
        }
        if (a == Int.Companion.MIN_VALUE && b == -1) {
            return Int.Companion.MAX_VALUE
        }
        val sign = (a > 0 && b > 0) || (a < 0 && b < 0)
        a = if (a > 0) -a else a
        b = if (b > 0) -b else b
        var ans = 0
        while (a <= b) {
            var x = b
            var cnt = 1
            while (x >= (Int.Companion.MIN_VALUE shr 1) && a <= (x shl 1)) {
                x = x shl 1
                cnt = cnt shl 1
            }
            ans += cnt
            a -= x
        }
        return if (sign) ans else -ans
    }
}