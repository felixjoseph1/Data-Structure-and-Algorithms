package DataStructureImplementation.Trie;

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        this.root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }
    public boolean search(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return curr.isEnd;
    }
    public boolean startsWith(String prefix){
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            int index=ch-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return true;
    }
}

public class Main{
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
