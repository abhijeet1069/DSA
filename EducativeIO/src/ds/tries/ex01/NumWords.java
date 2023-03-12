package ds.tries.ex01;

/**
 Core Logic : Number of Words = Number of endWord true flags
 * */
public class NumWords {
    public static int totalWords(TrieNode root){
        // Write - Your - Code
        return 0;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};
        Trie trie = new Trie();
        for(String key : keys){
            trie.insert(key);
        }
    }
}
