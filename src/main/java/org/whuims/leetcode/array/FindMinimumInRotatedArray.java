package org.whuims.leetcode.array;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedArray findMinimumInRotatedArray = new FindMinimumInRotatedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int res = findMinimumInRotatedArray.findMin(nums);
        System.out.println(res);
    }

    /**
     * my solution
     * @param nums
     * @return
     */
//    public int findMin(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int min = nums[0];
//        int i = 0, n = nums.length;
//        if (n == 1) {
//            return min;
//        }
//        while (i < n - 1 && nums[i] < nums[i + 1]) {
//            i++;
//        }
//        return i < n - 1 ? Math.min(min, nums[i + 1]) : min;
//    }

    /**
     * best up-votes
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
