package org.whuims.leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

    public static void main(String[] args) {
        KDiffPairsInArray kDiffPairsInArray = new KDiffPairsInArray();
        int[] nums = {3, 1, 4, 1, 3, 5};
        int res = kDiffPairsInArray.findPairs(nums, 2);
        System.out.println(res);
    }

//    public int findPairs(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k < 0) {
//            return 0;
//        }
//        int len = nums.length;
//        Set<Pair> set = new HashSet<>();
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (nums[i] - nums[j] == k || nums[i] - nums[j] == -k) {
//                    if (!set.contains(new Pair(nums[j], nums[i]))) {
//                        set.add(new Pair(nums[i], nums[j]));
//                    }
//                }
//            }
//        }
//        return set.size();
//    }
//
//    class Pair {
//        int left;
//        int right;
//
//        public Pair(int left, int right) {
//            this.left = left;
//            this.right = right;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Pair pair = (Pair) o;
//            return left == pair.left &&
//                    right == pair.right;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(left, right);
//        }
//    }

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
