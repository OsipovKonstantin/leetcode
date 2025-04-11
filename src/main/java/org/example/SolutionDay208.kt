package org.example

//    easy #kotlin #string
//    Time complexity is O(n*log10(high)), where n is quantity of the numbers between low and high
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-symmetric-integers
class SolutionDay208 {
    companion object {
        fun countSymmetricIntegers(low: Int, high: Int): Int {
            var ans = 0
            for (i in low..high) {
                val s = i.toString()
                if (s.length % 2 != 0) continue
                if (isSymmetric(s)) ans++
            }
            return ans
        }

        private fun isSymmetric(s: String): Boolean {
            val len = s.length
            var diff = 0
            for (i in 0 until len / 2) {
                diff += (s[i] - '0') - (s[len - i - 1] - '0')
            }
            return diff == 0
        }
    }
}