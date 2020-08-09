package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = t.threeSum(nums);
        System.out.println(res.size());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int num1 = nums[i];
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -num1) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(num1);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > -num1) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}