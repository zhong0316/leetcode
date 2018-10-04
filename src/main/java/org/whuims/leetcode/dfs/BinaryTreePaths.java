package org.whuims.leetcode.dfs;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        List<String> res = binaryTreePaths.binaryTreePaths(root);
        res.forEach(System.out::println);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path, List<String> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuilder.append(path.get(i) + "->");
            }
            stringBuilder.append(path.get(path.size() - 1));
            res.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }
}
