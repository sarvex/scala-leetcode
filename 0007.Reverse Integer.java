internal class Solution {
    fun reverse(x: Int): Int {
        var x = x
        var ans = 0
        while (x != 0) {
            if (ans < Int.Companion.MIN_VALUE / 10 || ans > Int.Companion.MAX_VALUE / 10) {
                return 0
            }
            ans = ans * 10 + x % 10
            x /= 10
        }
        return ans
    }
}