internal class Solution {
    private var f: Array<Array<Boolean?>?>
    private var s: String? = null
    private var p: String? = null
    private var m = 0
    private var n = 0

    fun isMatch(s: String, p: String): Boolean {
        m = s.length
        n = p.length
        f = Array<Array<Boolean?>?>(m + 1) { arrayOfNulls<Boolean>(n + 1) }
        this.s = s
        this.p = p
        return dfs(0, 0)
    }

    private fun dfs(i: Int, j: Int): Boolean {
        if (j >= n) {
            return i == m
        }
        if (f[i]!![j] != null) {
            return f[i]!![j]!!
        }
        var res = false
        if (j + 1 < n && p!!.get(j + 1) == '*') {
            res = dfs(i, j + 2)
                    || (i < m && (s!!.get(i) == p!!.get(j) || p!!.get(j) == '.') && dfs(i + 1, j))
        } else {
            res = i < m && (s!!.get(i) == p!!.get(j) || p!!.get(j) == '.') && dfs(i + 1, j + 1)
        }
        return res.also { f[i]!![j] = it }
    }
}