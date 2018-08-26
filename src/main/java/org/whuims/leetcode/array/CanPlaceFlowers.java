package org.whuims.leetcode.array;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flowerbed = {0,0,1,0,0};
        int n = 1;
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, n));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if (len == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i == len - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            } else {
                if (i > 0 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
