package org.whuims.leetcode.dfs;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int[][] res = floodFill.floodFill(image, 1, 1, 1);
        System.out.println();
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == Integer.MAX_VALUE) image[i][j] = newColor;
            }
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] == originalColor) {
            image[sr][sc] = Integer.MAX_VALUE;
            dfs(image, sr + 1, sc, originalColor);
            dfs(image, sr - 1, sc, originalColor);
            dfs(image, sr, sc + 1, originalColor);
            dfs(image, sr, sc - 1, originalColor);
        }
    }
}
