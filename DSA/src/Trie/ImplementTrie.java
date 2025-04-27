package Trie;

public class ImplementTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		System.out.println("Inserting words: Striver, Striving, String, Strike");
		trie.insert("striver");
		trie.insert("striving");
		trie.insert("string");
		trie.insert("strike");
		
		System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
	}

}
class Trie {

    //Node structure for trie
    static class Node{
        //Array to store links to child nodes
        Node links[] = new Node[26];//lower case alpha
        //flag indicating if the node marks the end of a word
        boolean flag = false;

        //checks if the node contains letter or not
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        //insert a new node with a specific letter into the trie
        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        //get the node with specific letter from the trie
        Node get(char ch){
            return links[ch-'a'];
        }

        //set the current node as the end of a word
        void setEnd(){
            flag = true;
        }

        //check if the current node is marked as end of a word
        boolean isEnd(){
            return flag;
        }

    }
    
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            //move to the reference trie
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
             if(!node.containsKey(prefix.charAt(i))){
                return false;
            } node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
