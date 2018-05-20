package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? Integer.compare(p2[0], p1[0]) : Integer.compare(p1[1], p2[1]));
        List<int[]> list = new ArrayList();
        for (int[] ppl : people) {
            list.add(ppl[1], ppl);
        }
        return list.toArray(new int[people.length][]);
    }
}
