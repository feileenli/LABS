import java.util.HashSet;

/* A general tree containing Strings, implemented as a "linked tree" */

public class StringTree {

	public static class Node {   // LEAVE THIS PUBLIC FOR OUR TESTS
		String data;
		HashSet<Node> children;
		
		public Node(String s) {
			data = s;
			children = new HashSet<>();
		}
	}
	
	public Node root = null;    // LEAVE THIS PUBLIC FOR OUR TESTS
	
	
	/* This constructor creates a new StringTree. It will have one Node (the
	 * root) that contains the data specified by the parameter.
	 */
	public StringTree(String rootString) {
		root = new Node(rootString);
	}
	
	/*
	 * Search the tree for the node containing the parent string. If found, add a
	 * child node to this (parent) node containing the child string as its data.
	 * 
	 * If the parent string is not found in the tree, the method should do nothing.
	 * 
	 * Hint: You should implement this recursively, using a private helper method
	 * with three parameters: localRoot, parent, and child.
	 */
	public void addChild(String parent, String child) {
		// remove this and implement this method
		traversal(root, parent, child);
	}

	private void traversal(Node localRoot, String parent, String child) {
		if (localRoot != null) {
			if (localRoot.data.equals(parent)) {
				localRoot.children.add(new Node(child));
			}
			for (Node kid : localRoot.children) {
				traversal(kid, parent, child);
			}
		}
	}
	
	/* Returns the number of Strings in the Tree
	 * Hint:  You should implement this recursively, using a private helper method 
	 * with ONE parameter (localRoot). DO NOT USE A SECOND PARAMETER TO KEEP TRACK
	 * OF THE COUNT!
	 */
	public int countElements() {
		return traversal2(root);
	}

	private int traversal2(Node localRoot) {
		int sum = 1;
		for (Node kid : localRoot.children) {
			sum += traversal2(kid);
		}
		return sum;
	}

	/* Return the string in the tree that is longest 
	 * Hint: You should implement this recursively, using a helper method that
	 * takes ONE PARAMETER (localRoot). DO NOT USE TWO PARAMETERS.
	*/
	public String findLongestString() {
		return findLongestStringHelper(root);
	}
	public String findLongestStringHelper(Node localRoot) {
		String longestStringFromChildren = localRoot.data;
		if(localRoot != null) {
			for(Node child: localRoot.children) {
				String longest = findLongestStringHelper(child); 
				if(longest.length() >= longestStringFromChildren.length()) {
					longestStringFromChildren = longest;
				}
			}
		}
		return longestStringFromChildren;
		
	}

	
	
	
}
