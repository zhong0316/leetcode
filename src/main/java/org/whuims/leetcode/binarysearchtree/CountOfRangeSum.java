package org.whuims.leetcode.binarysearchtree;

/**
 * 建立BST，把prefix sum作为TreeNode.val存进去，为了避免重复的TreeNode.val处理麻烦，设置一个count记录多少个重复TreeNode.val, 维护leftSize, 记录比该节点value小的节点个数，rightSize同理
 * <p>
 * 由于RangeSum S(i,j)在[lower,upper]之间的条件是lower<=sums[j+1]-sums[i]<=upper, 所以我们每次insert一个新的PrefixSum sums[k]进这个BST之前，先寻找一下（rangeSize）该BST内已经有多少个PrefixSum（叫它sums[t]吧）满足lower<=sums[k]-sums[t]<=upper, 即寻找有多少个sums[t]满足：
 * <p>
 * sums[k]-upper<=sums[t]<=sums[k]-lower
 * <p>
 * BST提供了countSmaller和countLarger的功能，计算比sums[k]-upper小的RangeSum数目和比sums[k]-lower大的数目，再从总数里面减去，就是所求
 */
public class CountOfRangeSum {

    private TreeNode insert(TreeNode root, long val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val == val) {
            root.count++;
        } else if (val < root.val) {
            root.leftSize++;
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.rightSize++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int countSmaller(TreeNode root, long val) {
        if (root == null) {
            return 0;
        } else if (root.val == val) {
            return root.leftSize;
        } else if (root.val > val) {
            return countSmaller(root.left, val);
        } else {
            return root.leftSize + root.count + countSmaller(root.right, val);
        }
    }

    private int countLarger(TreeNode root, long val) {
        if (root == null) {
            return 0;
        } else if (root.val == val) {
            return root.rightSize;
        } else if (root.val < val) {
            return countLarger(root.right, val);
        } else {
            return countLarger(root.left, val) + root.count + root.rightSize;
        }
    }

    private int rangeSize(TreeNode root, long lower, long upper) {
        int total = root.count + root.leftSize + root.rightSize;
        int smaller = countSmaller(root, lower);    // Exclude everything smaller than lower
        int larger = countLarger(root, upper);      // Exclude everything larger than upper
        return total - smaller - larger;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return 0;
        }
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        TreeNode root = new TreeNode(sums[0]);
        int output = 0;
        for (int i = 1; i < sums.length; i++) {
            output += rangeSize(root, sums[i] - upper, sums[i] - lower);
            insert(root, sums[i]);
        }
        return output;
    }

    private class TreeNode {
        long val = 0;
        int count = 1;
        int leftSize = 0;
        int rightSize = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(long v) {
            this.val = v;
            this.count = 1;
            this.leftSize = 0;
            this.rightSize = 0;
        }
    }
}
