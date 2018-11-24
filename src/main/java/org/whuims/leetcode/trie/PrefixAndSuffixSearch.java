package org.whuims.leetcode.trie;

public class PrefixAndSuffixSearch {

    public static void main(String[] args) {
        String[] words = {"abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"};
        PrefixAndSuffixSearch prefixAndSuffixSearch = new PrefixAndSuffixSearch(words);
        System.out.println(prefixAndSuffixSearch.f("", "aa"));
    }

    TrieNode root;
    char spilt = '{';

    public PrefixAndSuffixSearch(String[] words) {
        root = buildTire(words);
    }

    public int f(String prefix, String suffix) {
        return searchTrie(suffix + spilt + prefix);
    }

    int searchTrie(String word) {
        if (word == null || word.length() == 0) {
            return -1;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length() && curr != null; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] != null && curr.children[index].maxWeight != -1 && i == word.length() - 1) {
                return curr.children[index].maxWeight;
            }
            TrieNode next = curr.children[index];
            curr = next;
        }
        return -1;
    }

    TrieNode buildTire(String[] words) {
        root = new TrieNode();
        int weight = 0;
        for (String word : words) {
            int i = 0, len = word.length();
            while (i <= len) {
                TrieNode curr = root;
                String temp = word.substring(len - i) + spilt + word;
                for (int j = 0; j < temp.length(); j++) {
                    char c = temp.charAt(j);
                    int index = c - 'a';
                    if (curr.children[index] == null) {
                        curr.children[index] = new TrieNode();
                    }
                    TrieNode next = curr.children[index];
                    next.maxWeight = Math.max(next.maxWeight, weight);
                    next.val = c;
                    curr = next;
                }
                i++;
            }
            weight++;
        }
        return root;
    }

    class TrieNode {
        public char val;
        public int maxWeight = -1;
        public TrieNode[] children = new TrieNode[27];

        public TrieNode() {
        }
    }
}
