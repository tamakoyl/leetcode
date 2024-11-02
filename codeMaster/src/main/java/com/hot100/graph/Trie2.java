package com.hot100.graph;



/**
 * @Author:Tamako
 * @Date:2024/8/13 17:02
 * @Description:TODO
 */
public class Trie2 {
    public Trie2() {
        this.root = new TrieNode();
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfTheWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfTheWord = false;
        }
    }

    private final TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index]; // 移动到子节点
        }
        current.isEndOfTheWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index]; // 移动到子节点
        }
        return current.isEndOfTheWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (Character c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index]; // 移动到子节点
        }
        return true;
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
