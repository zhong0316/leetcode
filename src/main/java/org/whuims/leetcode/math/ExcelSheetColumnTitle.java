package org.whuims.leetcode.math;

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnTitle.convertToTitle(26 * 27 + 3));
    }

    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            n--;
            stringBuilder.append((char) ('A' + n % 26));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
