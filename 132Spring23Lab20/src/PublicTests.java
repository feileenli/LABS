import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class PublicTests {

	@Test
	public void testEasyInsert() {
		MinHeap<Integer> h = new MinHeap<Integer>();
		h.add(8);
		h.add(5);
		h.add(3);
		h.add(7);
		assertTrue(h.data.get(0).equals(3));
		assertTrue(h.data.get(1).equals(7));
		assertTrue(h.data.get(2).equals(5));
		assertTrue(h.data.get(3).equals(8));
	}

	@Test
	public void testInsertThorough() {
		int LIST_SIZE = 500;
		MinHeap<Integer> h = new MinHeap<Integer>();
		Set<Integer> originalList = new HashSet<Integer>();
		int value;
		for (int i = 0; i < LIST_SIZE; i++) {
			boolean success;
			do {
				value = random.nextInt(100000);
				success = originalList.add(value);
			} while (!success);
			h.add(value);
		}
	
		// check all values present
		for (Integer i : originalList) {
			assertTrue(h.data.indexOf(i) >= 0 && h.data.indexOf(i) < LIST_SIZE);
		}
		
		// check invariant
		for (int i = 0; i < LIST_SIZE; i++) {
			if (leftChild(i) < LIST_SIZE) {
				assertTrue(h.data.get(i) <= h.data.get(leftChild(i)));
			}
			if (rightChild(i) < LIST_SIZE) {
				assertTrue(h.data.get(i) <= h.data.get(rightChild(i)));
			}
		}
	}
	
	@Test 
	public void testRemoveSmallest() {
		MinHeap<Integer> h = new MinHeap<Integer>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		for (int i : list) {
			h.add(i);
		}
		for (int i = 0; i < 100; i++) {
			int answer = h.removeSmallest();
			assertEquals(i, answer);
		}
	}


	private static Random random = new Random();

	private static int getParent(int i) {
		return (i - 1) / 2;
	}
	
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	private static int rightChild(int i) {
		return 2 * i + 2;
	}
}
