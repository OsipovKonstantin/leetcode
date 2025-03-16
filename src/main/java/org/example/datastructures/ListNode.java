package org.example.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int key;
    public int val;
    public ListNode next;

    public ListNode() {
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

    public List<Integer> asList(){
        List<Integer> elements = new ArrayList<>();
        elements.add(val);
        while(next!=null) {
            elements.add(next.val);
            next = next.next;
        }
        return elements;
    }
}