package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res) {
        List<TreeNode> lis = new ArrayList<>();
        lis.add(root);
        while (!lis.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>(lis);
            List<Integer> delta = new ArrayList<>();
            for (int i = 0; i < lis.size(); i++) {
                delta.add(lis.get(i).val);
            }
            res.add(delta);
            lis.clear();
            for (TreeNode node : temp) {
                if (node.left != null) {
                    lis.add(node.left);
                }
                if (node.right != null) {
                    lis.add(node.right);
                }
            }
        }
    }
}
