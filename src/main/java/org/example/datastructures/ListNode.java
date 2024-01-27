package org.example.datastructures;

public class ListNode {
    public int key;
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}