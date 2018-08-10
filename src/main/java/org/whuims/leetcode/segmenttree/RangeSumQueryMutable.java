package org.whuims.leetcode.segmenttree;

public class RangeSumQueryMutable {

    class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        public int sum;

        public SegmentTreeNode(int start, int end, SegmentTreeNode left, SegmentTreeNode right, int sum) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
    }

    private SegmentTreeNode root;

    public RangeSumQueryMutable(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, null, null, nums[start]);
        } else {
            int mid = (start + end) >> 1;
            SegmentTreeNode root = new SegmentTreeNode(start, end, null, null, 0);
            root.left = buildSegmentTree(nums, start, mid);
            root.right = buildSegmentTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }
    }

    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}