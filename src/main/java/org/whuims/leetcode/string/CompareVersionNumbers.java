package org.whuims.leetcode.string;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("7.5.2.4", "7.5.3"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        if (version1 == null && version2 != null) return -1;
        if (version1 != null && version2 == null) return 1;
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length, len2 = arr2.length;
        int minLen = Math.min(len1, len2);
        int i = 0;
        for (; i < minLen; i++) {
            int v1 = Integer.parseInt(arr1[i]), v2 = Integer.parseInt(arr2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        while (i < len1) {
            if (Integer.parseInt(arr1[i++]) > 0) return 1;
        }
        while (i < len2) {
            if (Integer.parseInt(arr2[i++]) > 0) return -1;
        }
        return 0;
    }
}
