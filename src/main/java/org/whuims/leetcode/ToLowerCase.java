package org.whuims.leetcode;

public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                c = (char) (c + 'a' - 'A');
            }
            res[i] = c;
        }
        return new String(res);
    }
}
