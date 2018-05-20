package org.whuims.leetcode.top100liked;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int reach=0;
        int i=0;
        while(i<nums.length && i<=reach){
            reach=Math.max(reach,i+nums[i]);
            i++;
        }
        return reach>=nums.length-1;
    }

}
