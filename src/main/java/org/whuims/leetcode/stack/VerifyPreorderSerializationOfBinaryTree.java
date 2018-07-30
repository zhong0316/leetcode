package org.whuims.leetcode.stack;

public class VerifyPreorderSerializationOfBinaryTree {

    /**
     * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
