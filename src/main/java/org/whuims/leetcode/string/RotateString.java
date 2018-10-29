package org.whuims.leetcode.string;

public class RotateString {

    public boolean rotateString(String A, String B) {
        if (A == null || A.length() == 0) {
            return B == null || B.length() == 0;
        }
        if (A.length() != B.length()) return false;
        for (int i = 0; i < A.length() - 1; i++) {
            String left = A.substring(0, i + 1);
            String right = A.substring(i + 1);
            if (B.equals(right + left)) return true;
        }
        return false;
    }
}
