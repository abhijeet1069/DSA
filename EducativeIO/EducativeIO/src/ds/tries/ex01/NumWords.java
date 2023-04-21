package ds.tries.ex01;

import java.util.HashMap;

/**
Implement the totalWords(TrieNode root) function to find the total number of words in a Trie.
	Sample Input
		String keys[] = {"the", "a", "there", "answer", "any","by", "bye", "their","abc"};
	Sample Output
		9
 * */
public class NumWords { 
	
	public static int totalWords(TrieNode root){ //More practise needs to be done in recursion
        int result = 0;
        if(root.isEndWord) {
        	result++;
        }
        for(int i = 0 ; i < TrieNode.ALPHABET_SIZE; i++) {
        	if(root.children[i] != null) {
        		result += totalWords(root.children[i]);
        	}
        }
        
        return result;
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
