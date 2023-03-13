package ds.tries.ex01;

/**
 Core Logic : Number of Words = Number of endWord true flags
 * */
public class NumWords { //loop needs to go through unique paths. Let's try with ""DFS""

    public static int countWords(TrieNode root, int count){
        if(root == null){
            return 0;
        }
        else{
            for(int i = 0; i < TrieNode.ALPHABET_SIZE; i++){
                if(root.children[i] != null){ //ignore null children
                    if(root.children[i].isEndWord){ //leaf Node
                        count += 1;
                    }
                    else{
                        count += countWords(root.children[i],count);
                    }
                }
            }
        }
        return count;
    }
    public static int totalWords(TrieNode root){
        return countWords(root,0);
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc","c","d","e"};
        Trie trie = new Trie();
        for(String key : keys){
            trie.insert(key);
        }
        System.out.println(totalWords(trie.getRoot()));
    }
}
