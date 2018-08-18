package org.whuims.leetcode.dp;

public class MaximumSumOfThreeNonOverlappingSubarrays {

    /**
     * Since it's 3 non-overlapping sub-array, we can divide it into left, mid, right.
     * Suppose mid is [i, i+k-1] because it needs to hav at least k elements, then
     * we can have left is from [0,i-1] and right is from [i+k, n-1].
     * <p>
     * Since left must have at least k elements then i-1-0+1 >= k , thus we have i>=k
     * Same thing for the right, since n-1-(i-k)+1 >= k, thus we have i<=n-2k
     * Thus we have k<=i<=n-2k , this is very important math to figure out.
     * <p>
     * Then we have 2 arrays which stores the maximum starting index from left and from right.
     * <p>
     * Finally, we figure out when i is in the range mentioned above, what would be the max from left and right and take
     * the global max.
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len < 3 * k) {
            return res;
        }
        int[] left = new int[len], right = new int[len], sum = new int[len + 1];
        // Computing the running sum
        // sum[i] stores the value from index 0 to i-1
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int leftMax = sum[k] - sum[0];
        left[k - 1] = 0;
        // traversing from left to right
        for (int i = k; i < len; i++) {
            if (sum[i + 1] - sum[i - k + 1] > leftMax) {
                leftMax = sum[i + 1] - sum[i - k + 1];
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        int rightMax = sum[len] - sum[len - k];
        right[len - k] = len - k;
        // traversing from right to left
        for (int i = len - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] > rightMax) {
                right[i] = i;
                rightMax = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int max = 0;
        // now consider the middle part where k<=i<=n-2k
        for (int i = k; i <= len - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int total = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}
