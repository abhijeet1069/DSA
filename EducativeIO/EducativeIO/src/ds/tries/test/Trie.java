package ds.tries.test;
//car
public class Trie {
    TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }
    public int getIndex(char c){ //assuming letters are within a-z
        return c -'a';
    }
    public void insert(String str){
        TrieNode currentNode = this.root;
        for(int i = 0; i < str.length(); i++){
            int index = getIndex(str.charAt(i));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String str){ //only read operation
        TrieNode currentNode = this.root;
        if(this.root == null){ //nothing to search in an empty trie
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            int index = getIndex(str.charAt(i));
            if(currentNode.children[index] == null){ //index empty means value isn't there
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord; //check whether last node is a leaf node or not
    }
}
