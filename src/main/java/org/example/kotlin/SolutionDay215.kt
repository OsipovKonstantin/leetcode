package org.example.kotlin

//    medium #string builder #kotlin
//    Time complexity is O(n*k), where n is the input number and k is the maximum length of resulted string
//    Space complexity is O(k)
//    https://leetcode.com/problems/count-and-say
class SolutionDay215 {
    companion object {
        fun countAndSay(n: Int): String {
            val ans = StringBuilder("1")
            var count = n
            while (count-- > 1) {
                rle(ans);
            }
            return ans.reverse().toString()
        }

        private fun rle(ans: StringBuilder) {
            val temp = ans.toString()
            ans.clear()
            var start = 0
            val len = temp.length
            while (start < len) {
                var end = start + 1
                val startChar = temp[start]
                while (end < len && startChar == temp[end]) {
                    end++
                }
                ans.append(startChar).append((end - start))
                start = end
            }
        }
    }
}