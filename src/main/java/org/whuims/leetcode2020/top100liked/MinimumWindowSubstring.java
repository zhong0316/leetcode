package org.whuims.leetcode2020.top100liked;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(m.minWindow(s, t));
    }

    /**
     * sliding window two pointers
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // 滑动窗口，left初始化为0，right向后移动，直到包含t，计算长度
        // left向后移动直到字符串在t中出现过，right继续向后移动，直到重新包含t，计算长度
        // 直到 right到s.length() - 1
        int left = 0;
        int right = 0;
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int minLen = s.length() + 1;
        int n = s.length();
        int counter = t.length();
        int head = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (freq[c]-- > 0) {
                counter--;
            }
            right++;
            while (counter == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    head = left;
                }
                if (++freq[s.charAt(left++)] > 0) {
                    counter++;
                }
            }
        }

        return minLen == s.length() + 1 ? "" : s.substring(head, head + minLen);
    }
}