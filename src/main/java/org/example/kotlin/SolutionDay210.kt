package org.example.kotlin

//    medium #recursion #kotlin
//    Time complexity is O(logn)
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-good-numbers
class SolutionDay210 {
    companion object {
        fun countGoodNumbers(n: Long): Int {
            val mod = 1000000007L
            val fives = if (n % 2 == 0L) n / 2 else n / 2 + 1L
            val fours = n - fives
            return (calculate(fives, mod, 5) * calculate(fours, mod, 4) % mod).toInt()
        }

        private fun calculate(number: Long, mod: Long, general: Long): Long {
            var num = number
            var gen = general
            if (num == 0L) return 1L
            var remainder = 1L
            while (num > 1L) {
                if (num % 2 == 1L) {
                    remainder = remainder * gen % mod
                }
                num /= 2
                gen = gen * gen % mod
            }
            return remainder * gen % mod
        }
    }
}