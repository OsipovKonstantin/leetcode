
package org.example.datastructures;

import java.util.HashMap;
import java.util.Map;

//    SolutionDay68Third
//    medium #design
//    https://leetcode.com/problems/lru-cache/description
//    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//    Implement the LRUCache class:
//    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//    int get(int key) Return the value of the key if the key exists, otherwise return -1.
//    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
//    the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//    The functions get and put must each run in O(1) average time complexity.
//    Example 1:
//    Input
//    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//    Output
//    [null, null, null, 1, null, -1, null, -1, 3, 4]
//    Explanation
//    LRUCache lRUCache = new LRUCache(2);
//    lRUCache.put(1, 1); // cache is {1=1}
//    lRUCache.put(2, 2); // cache is {1=1, 2=2}
//    lRUCache.get(1);    // return 1
//    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//    lRUCache.get(2);    // returns -1 (not found)
//    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//    lRUCache.get(1);    // return -1 (not found)
//    lRUCache.get(3);    // return 3
//    lRUCache.get(4);    // return 4
class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node dummyStart;
    Node dummyEnd;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummyStart = new Node(0, 0);
        this.dummyEnd = new Node(0, 0);
        dummyStart.next = dummyEnd;
        dummyEnd.prev = dummyStart;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = dummyEnd.prev;
        prev.next = node;
        dummyEnd.prev = node;
        node.prev = prev;
        node.next = dummyEnd;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        remove(map.get(key));
        insert(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        if (capacity < map.size()) {
            Node lru = dummyStart.next;
            map.remove(lru.key);
            remove(lru);
        }
    }
}