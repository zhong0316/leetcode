package org.whuims.leetcode.twopointers;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int res = lengthOfLastWord.lengthOfLastWord(" ");
        System.out.println(res);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.replaceAll(" ", "").length() == 0) {
            return 0;
        }
        int len = s.length(), right = len - 1;
        char[] cs = s.toCharArray();
        int res;
        while (cs[right] == ' ') right--;
        res = right;
        while (cs[right] != ' ') right--;
        res -= right;
        return res;
    }
}
