import java.lang.String
import kotlin.Int
import kotlin.arrayOfNulls

internal class Solution {
    fun convert(s: String, numRows: Int): String? {
        if (numRows == 1) {
            return s
        }
        val g = arrayOfNulls<StringBuilder>(numRows)
        Arrays.setAll(g, { k -> StringBuilder() })
        var i = 0
        var k = -1
        for (c in s.toCharArray()) {
            g[i].append(c)
            if (i == 0 || i == numRows - 1) {
                k = -k
            }
            i += k
        }
        return String.join("", *g)
    }
}