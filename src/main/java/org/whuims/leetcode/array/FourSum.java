package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {-1, 0, -5, -2, -2, -4, 0, 1, -2};
        List<List<Integer>> res = fourSum.fourSum(nums, -9);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return kSum(4, 0, nums, target);
    }

    /**
     * All kSum problem can be divided to two parts:
     * 1: convert kSum to 2Sum problem;
     * 2: solve the 2Sum problem;
     *
     * @param k
     * @param index
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> kSum(int k, int index, int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (k == 2) {
            int left = index, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    // skip the duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<List<Integer>> kSubtractOneSum = kSum(k - 1, i + 1, nums, target - nums[i]);
                if (kSubtractOneSum != null) {
                    for (List<Integer> path : kSubtractOneSum) {
                        path.add(0, nums[i]);
                    }
                    res.addAll(kSubtractOneSum);
                }
            }
        }
        return res;
    }
}
