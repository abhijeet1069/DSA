package ds.tries.ex03;

import java.util.ArrayList;


public class Sort {

	public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str) {
	    //Leaf denotes end of a word
	    if (root.isEndWord) {
	      //current word is stored till the 'level' in the character array
	      String temp = "";
	      for (int x = 0; x < level; x++) { //unknown logic
	        temp += Character.toString(str[x]);
	      }
	      result.add(temp);
	    }
	    for (int i = 0; i < 26; i++) {
	      if (root.children[i] != null) {
	        //Non-null child, so add that index to the character array
	        str[level] = (char)(i + 'a');
	        getWords(root.children[i], result, level + 1, str);
	      }
	    }
	  }
	
	public static ArrayList<String> sortArray(String[] arr) {
	    ArrayList<String> result = new ArrayList<String>(); 
	    Trie trie = new Trie();
	    for(String arrElement : arr) {
	    	trie.insert(arrElement);
	    }
	    getWords(trie.getRoot(),result,0,new char[20]);
	    return result;
	  }
	
	public static void main(String[] args) {
		String keys[] = {"the", "a", "there", "answer", "any","by", "bye", "their","abc"};
		System.out.println(sortArray(keys));
	}

}
