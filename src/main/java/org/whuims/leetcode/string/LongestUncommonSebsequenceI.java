package org.whuims.leetcode.string;

public class LongestUncommonSebsequenceI {

    public static void main(String[] args) {
        LongestUncommonSebsequenceI longestUncommonSebsequenceI = new LongestUncommonSebsequenceI();
        int res = longestUncommonSebsequenceI.findLUSlength("aaa", "aaaa");
        System.out.println(res);
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
