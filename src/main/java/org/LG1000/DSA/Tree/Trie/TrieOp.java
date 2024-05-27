package org.LG1000.DSA.Tree.Trie;

import java.util.Map;

public class TrieOp {
    private TrieNode root;
    public TrieOp(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode currentNode=root;
        for(char c:word.toCharArray()){
            TrieNode p=currentNode.child.get(c);
            if(p==null){
                p=new TrieNode();
                currentNode.child.put(c,p);
            }
            currentNode=p;
        }
        currentNode.endOfWord=true;

    }
    public boolean search(String word){
        TrieNode currentNode=root;
        for(char c:word.toCharArray()){
            TrieNode p=currentNode.child.get(c);
            if(p==null){
                return false;
            }
            currentNode=p;
        }
        return currentNode.endOfWord;
    }
    public void delete(String word){
        if(search(word)){
            delete(root,word,0);
        }
    }
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.child.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.child.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.child.remove(ch);
            return current.child.isEmpty() && !current.endOfWord;
        }
        return false;
    }
    public void printAllWords() {
        printAllWords(root, new StringBuilder());
    }

    private void printAllWords(TrieNode current, StringBuilder prefix) {
        if (current.endOfWord) {
            System.out.println(prefix.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : current.child.entrySet()) {
            prefix.append(entry.getKey());
            printAllWords(entry.getValue(), prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}
