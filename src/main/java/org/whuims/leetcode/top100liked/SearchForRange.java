package org.whuims.leetcode.top100liked;

import java.util.PriorityQueue;
import java.util.Queue;

public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        binarySearch(nums, 0, nums.length - 1, qu, target);
        if (qu.size() == 0) {
            return new int[]{-1, -1};
        } else {
            if (qu.size() == 1) {
                int ele = qu.poll();
                return new int[]{ele, ele};
            } else {
                int counter = 0;
                int min = qu.peek(), max = min;
                while (qu.size() > 0) {
                    int ele = qu.poll();
                    if (ele < min) {
                        min = ele;
                    }
                    if (ele > max) {
                        max = ele;
                    }
                }
                return new int[]{min, max};
            }
        }
    }

    private void binarySearch(int[] nums, int start, int end, Queue qu, int target) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            qu.offer(mid);
        }
        if (mid > 0 && nums[mid - 1] >= target) {
            binarySearch(nums, start, mid - 1, qu, target);
        }
        if (mid < nums.length - 1 && nums[mid + 1] <= target) {
            binarySearch(nums, mid + 1, end, qu, target);
        }
    }
}
