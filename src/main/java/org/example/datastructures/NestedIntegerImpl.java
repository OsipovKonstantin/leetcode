package org.example.datastructures;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {
    private Integer number;
    private List<NestedInteger> nestedIntegers;

    public NestedIntegerImpl(Integer number) {
        this.number = number;
    }

    public NestedIntegerImpl(List<NestedInteger> nestedIntegers) {
        this.nestedIntegers = nestedIntegers;
    }

    @Override
    public boolean isInteger() {
        return number != null;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return !nestedIntegers.isEmpty() ? nestedIntegers : new ArrayList<>();
    }
}


