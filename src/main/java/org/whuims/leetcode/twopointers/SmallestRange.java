package org.whuims.leetcode.twopointers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SmallestRange {

    public static void main(String[] args) throws IOException {
        SmallestRange smallestRange = new SmallestRange();
//        List<List<Integer>> nums = Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1));
//        List<List<Integer>> nums = Arrays.asList(Arrays.asList(4,10,15,24,26), Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30));
//        int[][] matrix = new int[][]{{-89,1,69,89,90,98},{-43,-36,-24,-14,49,61,66,69},{73,94,94,96},{11,13,76,79,90},{-40,-20,1,9,12,12,14},{-91,-31,0,21,25,26,28,29,29,30},{23,88,89},{31,42,42,57},{-2,6,11,12,12,13,15},{-3,25,34,36,39},{-7,3,29,29,31,32,33},{4,11,14,15,15,18,19},{-34,9,12,19,19,19,19,20},{-26,4,47,53,64,64,64,64,64,65},{-51,-25,36,38,50,54},{17,25,38,38,38,38,40},{-30,12,15,19,19,20,22},{-14,-13,-10,68,69,69,72,74,75},{-39,42,70,70,70,71,72,72,73},{-67,-34,6,26,28,28,28,28,29,30,31}};
        List<String> lines = FileUtils.readLines(new File("temp"), "UTF-8");
//
        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            String[] arr = lines.get(i).split(",");
            for (String num : arr) {
                if (num.length() > 0) temp.add(Integer.parseInt(num));
            }
            nums.add(temp);
        }
        int[] res = smallestRange.smallestRange(nums);
        System.out.println(res[0] + "," + res[1]);
    }
//    // 记录每个数字和组别索引(Item(value,groupIndex))，
//    // 然后对所有Item排序。再利用two-pointers方法查找
//    public int[] smallestRange(List<List<Integer>> nums) {
//        int[] res = new int[2];
//        if (nums.size() == 0) return res;
//        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < nums.size(); i++) {
//            for (int num : nums.get(i)) {
//                items.add(new Item(num, i));
//            }
//        }
//        if (items.size() == 1) {
//            res[0] = items.get(0).value;
//            res[1] = items.get(0).value;
//            return res;
//        }
//        Collections.sort(items, (Comparator.comparingInt(o -> o.value)));
//        Set<Integer> groups = new HashSet<>();
//        int left = 0, right = left + 1;
//        groups.add(items.get(left).groupIndex);
//        groups.add(items.get(right).groupIndex);
//        int minGap = Integer.MAX_VALUE;
//        int n = items.size();
//        int cliques = nums.size();
//        while (left < n && right < n) {
//            while (right < n - 1 && groups.size() < cliques) {
//                right++;
//                groups.add(items.get(right).groupIndex);
//                if ((minGap != Integer.MAX_VALUE && items.get(right).value - items.get(left).value > minGap) || groups.size() == cliques) {
//                    break;
//                }
//            }
//            if (right < n && items.get(right).value - items.get(left).value < minGap && groups.size() == cliques) {
//                minGap = items.get(right).value - items.get(left).value;
//                res[0] = items.get(left).value;
//                res[1] = items.get(right).value;
//                if (minGap == 0) return res;
//            }
//            while (left < n - 1 && items.get(left + 1).value == items.get(left).value) left++;
//            left++;
//            right = left + 1;
//            groups.clear();
//            if (left < n) {
//                groups.add(items.get(left).groupIndex);
//            }
//            if (right < n) {
//                groups.add(items.get(right).groupIndex);
//            }
//
//        }
//        return res;
//    }
//
//    class Item {
//        int value, groupIndex;
//
//        public Item(int value, int groupIndex) {
//            this.value = value;
//            this.groupIndex = groupIndex;
//        }
//    }


    public int[] smallestRange(List<List<Integer>> nums) {
        int start = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minGap = Integer.MAX_VALUE;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int[] temp = new int[]{nums.get(i).get(0), i, 0};
            priorityQueue.offer(temp);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (priorityQueue.size() == size) {
            int[] curr = priorityQueue.poll();
            int left = curr[0], groupIndex = curr[1], indexInGroup = curr[2];
            if (max - left < minGap) {
                minGap = max - left;
                start = left;
            }
            if (indexInGroup + 1 < nums.get(groupIndex).size()) {
                curr[0] = nums.get(groupIndex).get(indexInGroup + 1);
                curr[2]++;
                max = Math.max(max, curr[0]);
                priorityQueue.offer(curr);
            }
        }
        return new int[]{start, start + minGap};
    }
}
