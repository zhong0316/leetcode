package org.whuims.leetcode.design;

public class AddAndSearchWord {

    public static void main(String[] args) {
        AddAndSearchWord andSearchWord = new AddAndSearchWord();
        andSearchWord.addWord("a");
        andSearchWord.addWord("ab");
        System.out.println(andSearchWord.search("a"));
        System.out.println(andSearchWord.search("a."));
        System.out.println(andSearchWord.search("ab"));
        System.out.println(andSearchWord.search(".a"));
        System.out.println(andSearchWord.search(".b"));
        System.out.println(andSearchWord.search("ab."));
        System.out.println(andSearchWord.search("."));
        System.out.println(andSearchWord.search(".."));
    }

    TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
         if (word == null || word.length() == 0) return;
         int len = word.length();
         TrieNode curr = root;
         for (int i = 0; i < len; i++) {
             if (curr.children == null) curr.children = new TrieNode[26];
             char c = word.charAt(i);
             int index = c - 'a';
             if (curr.children[index] == null) curr.children[index] = new TrieNode();
             curr.children[index].val = c;
             if (i == len - 1) curr.children[index].isWord = true;
             curr = curr.children[index];
         }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return searchBacktracking(word.toCharArray(), 0, root);
    }

    public boolean searchBacktracking(char[] chars, int index, TrieNode curr) {
        if (index == chars.length) {
            if (curr.isWord) return true;
            else return false;
        }
        char c = chars[index];
        TrieNode[] children = curr.children;
        if (children == null) return false;
        for (TrieNode child : children) {
            if (child == null) continue;
            if (c == '.' || c == child.val) {
                if (searchBacktracking(chars, index + 1, child)) return true;
            }
        }
        return false;
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children;
}
