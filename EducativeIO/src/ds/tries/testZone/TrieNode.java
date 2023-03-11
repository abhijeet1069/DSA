package ds.tries.testZone;

//will add meaning to words and create dictionary

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord;
    String meaning;
    static final int ALPHABET_SIZE = 26;
    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }
    public void markAsLeaf(){
        this.isEndWord = true;
    }
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }
}
