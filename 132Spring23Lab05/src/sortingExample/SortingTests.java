package sortingExample;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortingTests {

	private static ArrayList<Integer> originalSortedList; // sorted list that never changes
	private static ArrayList<Integer> testList;  // list to be shuffled before each test
	
	/* When you use "@BeforeClass", the method must be static 
	 * This method will run ONCE before anything else happens */
	@BeforeClass
	public static void prepareOriginalList() {
		Random random = new Random();
		originalSortedList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			originalSortedList.add(random.nextInt(1000));
		}
		Collections.sort(originalSortedList); // makes the original sorted list 
	}
	
	/* When you use "@Before", the method must NOT be static.
	 * This method will run before EACH JUnit test. */
	@Before
	public void shuffleTestList() {
		testList = new ArrayList<>(originalSortedList);
		Collections.shuffle(testList); //shuffles the original sorted list before each test. 
	}
	
	@Test
	public void testSort1() {
		BrokenSortingAlgorithms.doSort1(testList);
		assertEquals(testList, originalSortedList); //tests the sorting method on the shuffled list and checks it w the og sorted list 
	}
	
	@Test
	public void testSort2() {
		BrokenSortingAlgorithms.doSort2(testList);
		assertEquals(testList, originalSortedList);
	}
	
	@Test
	public void testSort3() {
		BrokenSortingAlgorithms.doSort3(testList);
		assertEquals(testList, originalSortedList);
	}
	
	@Test
	public void testSort4() {
		BrokenSortingAlgorithms.doSort4(testList);
		assertEquals(testList, originalSortedList);
	}

}
