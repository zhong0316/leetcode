package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate("", 0, 0, ret, n);
        return ret;
    }

    public void generate(String s, int leftNum, int rightNum, List<String> ret, int n) {
        if (s.length() == 2 * n) {
            if (!ret.contains(s)) {
                ret.add(s);
            }
            return;
        }
        if (leftNum == 0 || leftNum == rightNum) {
            generate(s + "(", leftNum + 1, rightNum, ret, n);
        } else if (leftNum > rightNum) {
            if (leftNum <= n - 1) {
                generate(s + "(", leftNum + 1, rightNum, ret, n);
                generate(s + ")", leftNum, rightNum + 1, ret, n);
            } else {
                generate(s + ")", leftNum, rightNum + 1, ret, n);
            }
        }
    }
}
