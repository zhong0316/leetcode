package org.whuims.leetcode.array;

public class CircularArrayLoop {
    /**
     * Just think it as finding a loop in Linkedlist, except that loops with only 1 element do not count.
     * Use a slow and fast pointer, slow pointer moves 1 step a time while fast pointer moves 2 steps a time.
     * If there is a loop (fast == slow), we return true, else if we meet element with different directions,
     * then the search fail, we set all elements along the way to 0. Because 0 is fail for sure so when later
     * search meet 0 we know the search will fail.
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            // slow, fast pointer
            int j = i, k = getIndex(nums, i);
            while (nums[i] * nums[k] > 0 && nums[i] * nums[getIndex(nums, k)] > 0) {
                if (j == k) {
                    if (j == getIndex(nums, j)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(nums, j);
                k = getIndex(nums, getIndex(nums, k));
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[j];
            while (val * nums[j] > 0) {
                int next = getIndex(nums, j);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getIndex(int[] nums, int i) {
        int n = nums.length;
        return (i + nums[i] >= 0 ? (i + nums[i]) % n : n + (i + nums[i]) % n);
    }
}
