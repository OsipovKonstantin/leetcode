package org.example;

import org.example.datastructures.ListNode;

//    easy #design a hashmap. Here we implemented map with hash function, but on the leetcode.com easy solution was to
//     store data in array int[1000001]
//    https://leetcode.com/problems/design-hashmap
//    Design a HashMap without using any built-in hash table libraries.
//    Implement the MyHashMap class:
//    MyHashMap() initializes the object with an empty map.
//    void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map,
//    update the corresponding value.
//    int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping
//    for the key.
//    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
//    Example 1:
//    Input
//    ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//    [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//    Output
//    [null, null, null, 1, -1, null, 1, null, -1]
//    Explanation
//    MyHashMap myHashMap = new MyHashMap();
//    myHashMap.put(1, 1); // The map is now [[1,1]]
//    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
//    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
//    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
//    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
public class SolutionDay38Sixth {
    private final int size = 19997;
    private final int multiplier = 12582917;
    private ListNode[] data;

    public SolutionDay38Sixth() {
        this.data = new ListNode[size];
    }

    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key, value, data[h]);
        data[h] = node;
    }

    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            data[h] = node.next;
        } else {
            while (node.next != null) {
                if (node.next.key != key) {
                    node = node.next;
                } else {
                    node.next = node.next.next;
                }
            }
        }
    }

    private int hash(int key) {
        return (int) ((long) key * multiplier % size);
    }
}
