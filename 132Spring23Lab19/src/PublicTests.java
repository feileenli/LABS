import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class PublicTests {
	
	@Test
	public void testGetEasy() {
		BinarySearchTree<String, String> tree = createSmallTree();
		assertTrue(tree.get("A").equals("a"));
		assertTrue(tree.get("B").equals("b"));
		assertTrue(tree.get("C").equals("c"));
	}

	@Test
	public void testCountLeavesEasy() {
		BinarySearchTree<String, String> tree = createSmallTree();
		assertTrue(tree.countLeaves() == 2);
	}
	
	@Test
	public void testGetDifficult() {
		BinarySearchTree<Integer, Integer> tree = createBigTree();
		for (int i = 0; i < 100; i++) {
			assertTrue(tree.get((i *1000) % 1223).equals(100 - i));
		}
	}
	
	@Test
	public void testCountLeavesDifficult() {
		BinarySearchTree<Integer, Integer> tree = createBigTree();
		assertTrue(tree.countLeaves() == 11);
	}
	
	@Test
	public void testGetValueForSmallestKey() {
		BinarySearchTree<Integer, Integer> tree = createMediumTree();
		assertTrue(tree.getValueForSmallestKey().equals(1000));
	}
	
	@Test
	public void testReverseLookup() {
		BinarySearchTree<Integer, Integer> tree = createMediumTree();
		for (int i = 1000; i < 1100; i++) {
			assertTrue(tree.reverseLookup(i).equals(i - 1000));
		}
	}
	
	private static BinarySearchTree<String, String> createSmallTree() {
		BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>();
		tree.put("B", "b");
		tree.put("C", "c");
		tree.put("A", "a");
		return tree;
	}
	
	private static BinarySearchTree<Integer, Integer> createMediumTree() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
		for (Integer x : list) {
			tree.put(x, x + 1000);   // 0 -> 1000, 1 -> 1001, etc.
		}
		return tree;
	}
	
	private static BinarySearchTree<Integer, Integer> createBigTree() {
		BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>();
		for (int i = 0; i < 100; i++) {
			tree.put((i * 1000) % 1223,  100 - i);
		}
		return tree;
	}
}
