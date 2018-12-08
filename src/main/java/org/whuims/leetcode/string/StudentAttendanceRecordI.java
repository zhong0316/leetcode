package org.whuims.leetcode.string;

/**
 * @author zhaozhongwei1
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();
        System.out.println(studentAttendanceRecordI.checkRecord("PPALLP"));
    }

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        int i = 0;
        int absentCounter = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCounter++;
                if (absentCounter >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                if (i < n - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}

