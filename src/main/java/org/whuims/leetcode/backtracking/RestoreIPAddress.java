package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        String s = "25525511135";
        List<String> res = restoreIPAddress.restoreIpAddresses(s);
        for (String str : res) {
            System.out.println(str);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        backtracking(res, s, 0, s.length(), 0, "");
        return res;
    }

    private void backtracking(List<String> res, String s, int start, int len, int counter, String curr) {
        if (counter == 4 && start >= len) {
            res.add(curr.substring(1));
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (start + i > len) {
                continue;
            }
            String part = s.substring(start, start + i);
            if (part.length() > 1) {
                if (part.charAt(0) == '0' || Integer.parseInt(part) == 0) {
                    break;
                }
            }
            if (Integer.parseInt(part) <= 255) {
                backtracking(res, s, start + i, len, counter + 1, curr + "." + part);
            } else {
                break;
            }
        }
    }
}
