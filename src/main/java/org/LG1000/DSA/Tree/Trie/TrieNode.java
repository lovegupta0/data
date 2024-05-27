package org.LG1000.DSA.Tree.Trie;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character,TrieNode> child;
    public boolean endOfWord;
    public TrieNode(){
        child=new HashMap<>();
        this.endOfWord=false;
    }

}
