internal class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val n = strs.size
        for (i in 0..<strs[0].length) {
            for (j in 1..<n) {
                if (strs[j].length <= i || strs[j].get(i) != strs[0].get(i)) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}