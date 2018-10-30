package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFourGame {

    public static void main(String[] args) {
        TwentyFourGame twentyFourGame = new TwentyFourGame();
        int[] nums = new int[]{3,4,6,7};
//        int[] nums = new int[]{4, 1, 8, 7};
        System.out.println(twentyFourGame.judgePoint24(nums));
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> numsD = new ArrayList<>();
        for (int num : nums) numsD.add((double) num);
        return gen24(numsD);
    }

    private boolean gen24(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0D) < 0.0001;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            Double numI = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                Double numJ = nums.get(j);
                List<Double> numsNext = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        numsNext.add(nums.get(k));
                    }
                }
                List<Double> combinations = Arrays.asList(numI + numJ, numI - numJ, numJ - numI, numI * numJ, numI / numJ, numJ / numI);
                for (int m = 0; m < combinations.size(); m++) {
                    numsNext.add(combinations.get(m));
                    if (gen24(numsNext)) return true;
                    numsNext.remove(numsNext.size() - 1);
                }
            }
        }
        return false;
    }

}
