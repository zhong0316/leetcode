package org.whuims.leetcode;

public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode() {
    }

    public TrieNode(char val, boolean isWord, TrieNode[] children) {
        this.val = val;
        this.isWord = isWord;
        this.children = children;
    }
}
