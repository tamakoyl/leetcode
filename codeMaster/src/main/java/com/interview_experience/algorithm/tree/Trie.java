package com.interview_experience.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/8/13 15:10
 * @Description:前缀树
 */
public class Trie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        // Constructor
        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }


    private final TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;  // Mark the end of a word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            //依次往后找
            current = current.children.get(ch);
            if (current == null) {
                return false;  // If the character is not found, return false
            }
        }
        return current.isEndOfWord;  // Return true only if it's the end of a word
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;  // If the character is not found, return false
            }
        }
        return true;  // If we can traverse the Trie along the prefix, return true
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        // Search for words
        System.out.println(trie.search("apple"));  // Output: true
        System.out.println(trie.search("app"));    // Output: true
        System.out.println(trie.search("bat"));    // Output: true
        System.out.println(trie.search("ball"));   // Output: true
        System.out.println(trie.search("bal"));    // Output: false

        // Check prefixes
        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("ba"));  // Output: true
        System.out.println(trie.startsWith("bat")); // Output: true
        System.out.println(trie.startsWith("bal")); // Output: true
        System.out.println(trie.startsWith("cat")); // Output: false
    }
}
