package org.example.kotlin

//    medium #hashmap #kotlin
//    Time complexity is O(n*m), where n is the size of the answers array and m is the maximum value in the answers array
//    Space complexity is O(m)
//    https://leetcode.com/problems/rabbits-in-forest
class SolutionDay217 {
    companion object {
        fun numRabbits(answers: IntArray): Int {
            val array = Array(1001) { IntArray(2) }
            for (answer in answers) {
                array[answer][1]++
                if (array[answer][0] == 0) array[answer][0] = answer + 1
                else if (array[answer][1] > array[answer][0]) array[answer][0] += answer + 1
            }
            return array.sumOf { it[0] }
        }
    }
}