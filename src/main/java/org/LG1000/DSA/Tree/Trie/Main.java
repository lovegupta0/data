package org.LG1000.DSA.Tree.Trie;

public class Main {
    public static void main(String[] args){
        TrieOp trieOp=new TrieOp();
        trieOp.insert("Hello");
        trieOp.insert("World");
        trieOp.insert("Hellen");
       /* System.out.println(trieOp.search("World"));
        System.out.println(trieOp.search("Wor"));
        System.out.println(trieOp.search("Hellow"));
        System.out.println(trieOp.search("Hello"));
        System.out.println(trieOp.search("Hellen"));*/
        trieOp.printAllWords();
        trieOp.delete("Hellen");
        System.out.println(trieOp.search("Hellen"));
        trieOp.printAllWords();
    }
}
