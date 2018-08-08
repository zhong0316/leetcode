package org.whuims.leetcode.bitmanipulation;

public class MaxProductsOfWordLengths {

    public static void main(String[] args) {
        MaxProductsOfWordLengths maxProductsOfWordLengths = new MaxProductsOfWordLengths();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int res = maxProductsOfWordLengths.maxProduct(words);
        System.out.println(res);
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int len = words.length;
        int res = 0;
        int[] vector = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int temp = 0;
            for (char c : word.toCharArray()) {
                temp |= (1 << c - 'a');
            }
            vector[i] = temp;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((vector[i] & vector[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}
