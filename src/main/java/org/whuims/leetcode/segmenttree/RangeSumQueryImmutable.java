package org.whuims.leetcode.segmenttree;

public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);

    }

    private SegmentTreeNode root;

    public RangeSumQueryImmutable(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private int sumRange(int i, int j) {
        return sumRange(i, j, root);
    }

    private int sumRange(int i, int j, SegmentTreeNode root) {
        int start = root.start, end = root.end, mid = (start + end) >> 1;
        if (i == start && j == end) {
            return root.sum;
        } else if (j <= mid) {
            return sumRange(i, j, root.left);
        } else if (i > mid) {
            return sumRange(i, j, root.right);
        } else {
            return sumRange(i, mid, root.left) + sumRange(mid + 1, j, root.right);
        }
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            if (start == end) {
                return new SegmentTreeNode(nums[start], start, end);
            } else {
                int mid = (start + end) >> 1;
                SegmentTreeNode root = new SegmentTreeNode(0, start, end);
                root.left = buildSegmentTree(nums, start, mid);
                root.right = buildSegmentTree(nums, mid + 1, end);
                root.sum = root.left.sum + root.right.sum;
                return root;
            }
        }
    }

    class SegmentTreeNode {
        public int sum, start, end;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }
}
