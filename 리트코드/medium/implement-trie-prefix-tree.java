import java.util.*;

class Trie {

    static class TrieNode{
  		HashMap<Character, TrieNode> children = new HashMap<>();
      	boolean end = false;
    }
  
  	static TrieNode root;
  
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
      	TrieNode node = root;
		for (char cha : word.toCharArray()) {
          	if (node.children.containsKey(cha) == false) { // 없다
                node.children.put(cha, new TrieNode());
            }  // 있다
          	node = node.children.get(cha); // node = node->children[cha];
        }
      	node.end = true; // node->end = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
      	for(char cha : word.toCharArray()){
           	if(node.children.containsKey(cha) == false) return false;
          	node = node.children.get(cha);
        }
      	return node.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
      	for(char cha : prefix.toCharArray()){
            // System.out.println("check!" + node.children.containsKey(cha) + cha);
           	if(node.children.containsKey(cha) == false) return false;
          	node = node.children.get(cha);
        }
      	return true;
    }
}
