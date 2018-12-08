package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenTheLock {
    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(openTheLock.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> throns = new HashSet<>();
        for (String str : deadends) {
            throns.add(str);
        }
        List<String> curr = new ArrayList<>();
        curr.add("0000");
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        if (throns.contains("0000")) return -1;
        while (true && curr.size() > 0) {
            int size = curr.size();
            List<String> next = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String str = curr.get(i);
                visited.add(str);
                for (int j = 0; j < 4; j++) {
                    char[] cs = str.toCharArray();
                    char originChar = cs[j];
                    char add = '0';
                    char subtract = '0';
                    if (originChar == '0') {
                        add = (char) (originChar + 1);
                        subtract = '9';
                    } else if (originChar == '9') {
                        add = '0';
                        subtract = (char) (originChar - 1);
                    } else {
                        add = (char) (originChar + 1);
                        subtract = (char) (originChar - 1);
                    }
                    char[] cs1 = new char[cs.length];
                    System.arraycopy(cs, 0, cs1, 0, cs.length);
                    cs1[j] = add;
                    String addStr = new String(cs1);
                    if (addStr.equals(target)) return step + 1;
                    if (!visited.contains(addStr) && !throns.contains(addStr)) {
                        next.add(addStr);
                        visited.add(addStr);
                    }
                    cs1[j] = subtract;
                    addStr = new String(cs1);
                    if (addStr.equals(target)) return step + 1;
                    if (!visited.contains(addStr) && !throns.contains(addStr)) {
                        next.add(addStr);
                        visited.add(addStr);
                    }
                }
            }
            step++;
            curr = next;
        }
        return -1;
    }
}
