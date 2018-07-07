package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SumOfDistanceInTree {

    public static void main(String[] args) {
        SumOfDistanceInTree sumOfDistanceInTree = new SumOfDistanceInTree();
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] res = sumOfDistanceInTree.sumOfDistancesInTree(6, edges);
        Arrays.stream(res).forEach(o -> System.out.println(o));
    }

    /**
     * When we move our root from one node to its connected node, one part of nodes get closer, one the other part get further.
     * If we know exactly hom many nodes in both parts, we can solve this problem.
     * <p>
     * With one single traversal in tree, we should get enough information for it and don't need to do it again and again.
     * <p>
     * Explanation:
     * 0. Let's solve it with node 0 as root.
     * <p>
     * 1. Initial an array of hashset tree, tree[i] contains all connected nodes to i.
     * Initial an array count, count[i] counts all nodes in the subtree i.
     * Initial an array of res, res[i] counts sum of distance in subtree i.
     * <p>
     * 2. Post order dfs traversal, update count and res:
     * count[root] = sum(count[i]) + 1
     * res[root] = sum(res[i]) + sum(count[i])
     * <p>
     * 3. Pre order dfs traversal, update res:
     * When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
     * res[i] = res[root] - count[i] + N - count[i]
     * <p>
     * 4. return res, done.
     */

    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    int n;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[N];
        count = new int[N];
        n = N;
        for (int i = 0; i < N; ++i) {
            tree.add(new HashSet<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, new HashSet<>());
        dfs2(0, new HashSet<>());
        return res;
    }

    public void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                dfs(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        }
        count[root]++;
    }

    public void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                dfs2(i, seen);
            }
        }
    }
}
