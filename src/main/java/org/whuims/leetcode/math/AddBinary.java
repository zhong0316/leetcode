package org.whuims.leetcode.math;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        // make sure a is longer than b
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int aLen = a.length(), bLen = b.length();
        int i = 0, carry = 0;
        while (i < bLen) {
            int c1 = a.charAt(aLen - i - 1) - 48;
            int c2 = b.charAt(bLen - i - 1) - 48;
            int c3 = c1 + c2 + carry;
            if (c3 >= 2) {
                stringBuilder.append(c3 - 2);
                carry = 1;
            } else {
                stringBuilder.append(c3);
                carry = 0;
            }
            i++;
        }
        while (i < aLen) {
            int c = a.charAt(aLen - i - 1) - 48;
            int temp = carry + c;
            if (temp >= 2) {
                stringBuilder.append(temp - 2);
                carry = 1;
            } else {
                stringBuilder.append(temp);
                carry = 0;
            }
            i++;
        }
        if (carry == 1) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
