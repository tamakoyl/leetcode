package com.hot100.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/8/13 16:41
 * @Description:TODO
 */
public class Trie {

    public Trie() {
        root = new TrieNode();
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfTheWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfTheWord = false;
        }
    }

    private final TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfTheWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfTheWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (Character c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

}
