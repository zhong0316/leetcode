package org.whuims.leetcode.dfs;

import org.whuims.leetcode.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        if (root == null || K < 0) return res;
        if (!graph.containsKey(target)) return res;
        while (!stack.isEmpty()) {
            int size = stack.size();
            if (K == 0) {https://github.com/spring-cloud/spring-cloud-netflix
                while (!stack.isEmpty()) {
                    res.add(stack.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = stack.poll();
                List<TreeNode> neighbors = graph.get(curr);
                for (TreeNode neighbor : neighbors) {
                    if (visited.contains(neighbor)) continue;
                    stack.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            K--;
        }
        return res;
    }

    private void buildGraph(TreeNode curr, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (curr == null) {
            return;
        }
        if (!graph.containsKey(curr)) {
            graph.put(curr, new ArrayList<>());
            if (parent != null) {
                graph.get(curr).add(parent);
                graph.get(parent).add(curr);
            }
            buildGraph(curr.left, curr, graph);
            buildGraph(curr.right, curr, graph);
        }
    }
}
