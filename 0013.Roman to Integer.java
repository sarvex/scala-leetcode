internal class Solution {
    fun romanToInt(s: String): Int {
        val cs = "IVXLCDM"
        val vs = intArrayOf(1, 5, 10, 50, 100, 500, 1000)
        val d: Map<Char?, Int?> = HashMap()
        for (i in vs.indices) {
            d.put(cs.get(i), vs[i])
        }
        val n = s.length
        var ans: Int = d.get(s.get(n - 1))!!
        for (i in 0..<n - 1) {
            val sign = if (d.get(s.get(i))!! < d.get(s.get(i + 1))!!) -1 else 1
            ans += sign * d.get(s.get(i))!!
        }
        return ans
    }
}