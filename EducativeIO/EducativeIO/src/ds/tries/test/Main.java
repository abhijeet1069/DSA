package ds.tries.test;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cars");
        System.out.println(trie.search("cas"));
    }
}
