

/* Students:
 * 
 * This implementation of Binary Search Tree is the traditional approach
 * (not the approach you are implementing in your project).  The left and
 * right references of a Node will be "null" if there is no child on 
 * that side.
 * 
 * At the bottom of this class you can find the methods that were 
 * implemented during one of the lectures.
 * 
 * There are several empty methods for you to implement.  Note that 
 * I have also included some PublicTests so that you can see if your code
 * is working correctly.  Be sure to follow the instructions that are 
 * included in the comments!
 */


public class BinarySearchTree<K extends Comparable<K>, V> {
	
	private class Node {
		private K key;
		private V value;
		private Node left, right;

		private Node(K key, V data) {
			this.key = key;
			this.value = data;
		}
	}

	/* Do not add any other instance variables or static variables to
	 * the BinarySearchTree class. */
	
	private Node root;

	/** Search for the Node with the key equal to the parameter.  If
	 * it is found, return the corresponding data value.  If the Key is not in
	 * the tree, return null.  THIS SHOULD BE IMPLEMENTED RECURSIVELY!  Your
	 * helper method should have just two parameters: the key and localRoot.
	 */
	public V get(K key) {
		return getHelper(root, key);

	}

	private V getHelper(Node localRoot, K key) {
		if (localRoot == null) {
			return null;
		}
		if (localRoot.key.compareTo(key) == 0) {
			return localRoot.value;
			
		} else if (localRoot.key.compareTo(key) > 0) {
			return getHelper(localRoot.left, key);
			
		} else {
			return getHelper(localRoot.right, key);
		}

	}

	/**
	 * Returns the number of leaves in the tree. (Recall that a leaf is a node with
	 * no children.) THIS SHOULD BE IMPLEMENTED RECURSIVELY! Your helper method
	 * should only have one parameter (localRoot).
	 */
	public int countLeaves() {
		return countLeavesHelper(root);
	}

	public int countLeavesHelper(Node localRoot) {
		int num = 0;
		if (localRoot.left == null && localRoot.right == null) {
			num += 1;
		}
		if (localRoot.left != null) {
			num += countLeavesHelper(localRoot.left);
		}
		if (localRoot.right != null) {
			num += countLeavesHelper(localRoot.right);
		}
		return num;
	}
	 
	/**
	 * Find the Node with the smallest key, and return its value. THIS SHOULD BE
	 * IMPLEMENTED RECURSIVELY! Your helper method should only have one parameter
	 * (localRoot).
	 */
	public V getValueForSmallestKey() {
		return getValueForSmallestKeyHelper(root);
	}

	public V getValueForSmallestKeyHelper(Node localRoot) {
		if (localRoot.left == null) {
			return localRoot.value;
		}
		return getValueForSmallestKeyHelper(localRoot.left);
	}
	
	/** Find any key that is mapped to the given value.  This is NOT going to 
	 * be fast.  You have to traverse the whole tree, looking for the value.
	 * If you find it, return (any) key that maps to it.  Note that the code you
	 * will be writing would work for ANY binary tree, not just a BST.  YOU
	 * MUST WRITE THIS RECURSIVELY.  Your helper method should have just two
	 * parameters: the value and localRoot.
	 */
	public K reverseLookup(V value) {
		return reverseLookupHelper(root, value);
	}

	public K reverseLookupHelper(Node localRoot, V value) {
		if (localRoot == null) {
			return null;
		}
		if (localRoot.value.equals(value)) {
			return localRoot.key;
		}
		K leftKey = reverseLookupHelper(localRoot.left, value);
		K rightKey = reverseLookupHelper(localRoot.left, value);

		if (leftKey != null) {
			return leftKey;
		}
		if (rightKey != null) {
			return rightKey;
		}
		return null;
	}
	
	/* The rest of this class was implemented already in one of the
	 * lectures.  Feel free to look it over to refresh your memory.
	 */
	
	
	public boolean put(K key, V data) {
		if (root == null) {
			root = new Node(key, data);
			return true;
		} else {
			return putHelper(key, data, root);
		}
	}

	private boolean putHelper(K key, V data, Node localRoot) {
		int comparison = key.compareTo(localRoot.key);
		if (comparison == 0) {
			localRoot.value = data;
			return false;
		} else if (comparison < 0) {
			if (localRoot.left == null) {
				localRoot.left = new Node(key, data);
				return true;
			} else {
				return putHelper(key, data, localRoot.left);
			}
		} else {
			if (localRoot.right == null) {
				localRoot.right = new Node(key, data);
				return true;
			} else {
				return putHelper(key, data, localRoot.right);
			}
		}
	}

	public String toString() {
		return toStringAux(root);
	}

	private String toStringAux(Node rootAux) {
		String answer = "";
		if (rootAux == null) {
			return answer;
		}
		answer = toStringAux(rootAux.left);
		answer += "{" + rootAux.key + ":" + rootAux.value + "}";
		answer += toStringAux(rootAux.right);
		return answer;
	}

}