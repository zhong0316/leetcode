package org.whuims.leetcode.array;

import java.util.Arrays;

public class ValidTriangleNumber {

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        int[] nums = {2, 2, 3, 4};
        int res = validTriangleNumber.triangleNumber(nums);
        System.out.println(res);
    }

//    public int triangleNumber(int[] nums) {
//        if (nums == null || nums.length <= 2) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int n = nums.length;
//        int res = 0;
//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (triangle(nums, i, j, k)) {
//                        res++;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean triangle(int[] nums, int i, int j, int k) {
//        if (nums[i] + nums[j] <= nums[k] || nums[i] + nums[k] <= nums[j]
//                || nums[j] + nums[k] <= nums[i]) {
//            return false;
//        }
//        return true;
//    }

    /**
     * O(n^2)
     *
     * @param A
     * @return
     */
    public int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
