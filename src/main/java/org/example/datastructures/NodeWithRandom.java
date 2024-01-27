package org.example.datastructures;

import java.util.Objects;

public class NodeWithRandom {
    public int val;
    public NodeWithRandom next;
    public NodeWithRandom random;

    public NodeWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeWithRandom that = (NodeWithRandom) o;
        return val == that.val && Objects.equals(next, that.next) && Objects.equals(random, that.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }
}
