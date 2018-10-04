package org.whuims.leetcode.string;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("the sky   is blue"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] cs = s.toCharArray();
        int n = cs.length;
        // first, we reverse the whole string
        reverse(cs, 0, n -1);
        // second, we reverse each word
        reverseWord(cs);
        // last, we clear trailing, tailing and duplicate space
        return clearSpace(cs);
    }

    private String clearSpace(char[] cs) {
        int i = 0, j = 0, n = cs.length;
        while (j < n) {
            // skip spaces
            while (j < n && cs[j] == ' ') j++;
            // keep no spaces
            while (j < n && cs[j] != ' ') cs[i++] = cs[j++];
            // skip spaces
            while (j < n && cs[j] == ' ') j++;
            // keep one space
            if (j < n) cs[i++] = ' ';
        }
        return new String(cs).substring(0, i);
    }
    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            i++;
            j--;
        }
    }
    private void reverseWord(char[] cs) {
        int n = cs.length;
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && cs[i] == ' ') i++;
            while (j < i || j < n && cs[j] != ' ') j++;
            int left = i, right = j - 1;
            reverse(cs, left, right);
        }
    }
}
