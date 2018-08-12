package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> res = summaryRanges.summaryRanges(nums);
        res.forEach(System.out::println);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int len = nums.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
            if (i == len - 1 || (i < len - 1 && nums[i + 1] != nums[i] + 1)) {
                if (list.size() == 1) {
                    stringBuilder.append(list.get(0));
                } else {
                    stringBuilder.append(list.get(0));
                    stringBuilder.append("->");
                    stringBuilder.append(list.get(list.size() - 1));
                }
                res.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                list.clear();
            }
        }
        return res;
    }
}
