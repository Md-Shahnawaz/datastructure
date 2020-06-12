package com.leetcode.medium.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {

    private Node root = new Node();

    public static void main(String[] args) {

        TrieTree trie = new TrieTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public TrieTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node temp = node.nodes.get(ch);
            if(temp == null){
                temp = new Node();
                node.nodes.put(ch, temp);
            }
            if(i == word.length() - 1){
                temp.pivot = true;
            }
            node = temp;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node temp = node.nodes.get(ch);
            if(temp == null){
                break;
            }
            if(i == word.length() - 1 && temp.pivot) {
                return true;
            }
            node = temp;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Node temp = node.nodes.get(ch);
            if(temp == null){
                return false;
            }
            node = temp;
        }
        return true;
    }

    public class Node {
        Map<Character, Node> nodes = new HashMap<>();
        boolean pivot;
    }

}
