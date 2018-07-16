package org.whuims.leetcode.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int res = longestRepeatingCharacterReplacement.characterReplacement("ABBB", 2);
        System.out.println(res);
    }

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0, end = 1;
        int res = 1;
        int maxFreq = 1;
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        freq[cs[0] - 'A']++;
        for (; end < len; end++) {
            maxFreq = Math.max(maxFreq, ++freq[cs[end] - 'A']);
            if (end - start + 1 - maxFreq > k) {
                // 如果当前窗口大小减去最大频率出现的字符个数大于k，则窗口开始处往前走一步
                freq[cs[start] - 'A']--;
                start++;
            } else {
                // 否则当前窗口内的所有其他字符都可以替换成频率出现最高的那个字符
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
}
