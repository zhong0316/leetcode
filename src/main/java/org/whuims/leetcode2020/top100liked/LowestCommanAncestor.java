package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

import org.whuims.leetcode.TreeNode;

public class LowestCommanAncestor {

    public static void main(String[] args) {
        LowestCommanAncestor l = new LowestCommanAncestor();
        TreeNode nodeVal2 = new TreeNode(2);
        TreeNode nodeVal1 = new TreeNode(1);
        TreeNode root = new TreeNode(3, new TreeNode(5, null, nodeVal1), nodeVal2);
        l.getPath(root, nodeVal1, new ArrayList());
        System.out.println(l.pathList.size());
    }

    List<TreeNode> pathList = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getPath(root, p, new ArrayList());
        List<TreeNode> list1 = this.pathList;
        getPath(root, q, new ArrayList());
        List<TreeNode> list2 = this.pathList;
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(list2.size() - i - 1))) {
                return list2.get(list2.size() - i - 1);
            }
        }

        return root;
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    private void getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == node) {
            path.add(node);
            pathList = new ArrayList(path);
            return;
        }
        if (root == null) {
            return;
        }
        path.add(root);
        getPath(root.left, node, path);
        getPath(root.right, node, path);
        path.remove(path.size() - 1);
    }
}