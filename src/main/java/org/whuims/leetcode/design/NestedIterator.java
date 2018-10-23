package org.whuims.leetcode.design;

import org.whuims.leetcode.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int currIndex = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            recursive(nestedInteger);
        }
    }

    private void recursive(NestedInteger curr) {
        if (curr.isInteger()) {
            list.add(curr.getInteger());
        } else {
            for (NestedInteger nestedInteger : curr.getList()) {
                recursive(nestedInteger);
            }
        }
    }

    @Override
    public Integer next() {
        if (currIndex < list.size()) return list.get(currIndex++);
        return null;
    }

    @Override
    public boolean hasNext() {
        return currIndex < list.size();
    }
}
