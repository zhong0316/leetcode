package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    private String postorder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "#";
        String serial = root.val + postorder(root.left, map, res) + postorder(root.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(root);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
