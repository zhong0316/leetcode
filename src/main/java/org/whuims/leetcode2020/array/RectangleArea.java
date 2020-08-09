package org.whuims.leetcode2020.array;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = Math.abs(A - C) * Math.abs(B - D) + Math.abs(E - G) * Math.abs(F - H);
        // 判断有没有相交的部分
        if (Math.min(C, G) <= Math.max(A, E) || Math.min(D, H) <= Math.max(B, F)) {
            return res;
        }

        int w = Math.min(C, G) - Math.max(A, E);
        int h = Math.min(D, H) - Math.max(B, F);

        return res - w * h;
    }
}