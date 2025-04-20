package org.example.kotlin

import org.example.datastructures.GraphNode

//    medium #depth-first search #kotlin
//    Time complexity is O(n+e), where n and e are the numbers of nodes and edges in the graph, respectively
//    Space complexity is O(n+e)
//    https://leetcode.com/problems/clone-graph
class SolutionDay217Second {
    companion object {
        fun cloneGraph(node: GraphNode?): GraphNode? {
            if (node == null) return null
            val map = mutableMapOf<GraphNode, GraphNode>()
            dfs(node, map)
            for ((original, copied) in map) {
                for (neighbor in original.neighbors) {
                    copied.neighbors.add(map[neighbor])
                }
            }
            return map[node]
        }

        private fun dfs(node: GraphNode, map: MutableMap<GraphNode, GraphNode>) {
            if (map.containsKey(node)) return
            map[node] = GraphNode(node.`val`)
            for (element in node.neighbors) {
                dfs(element!!, map)
            }
        }
    }
}