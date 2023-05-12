import static org.junit.Assert.*;

import org.junit.Test;

public class PublicTests {

	@Test
	public void testEasyIterator() {
		Triple<Integer> t = new Triple<Integer>(2, 3, 1);
		Integer[] correctAnswers = {1, 2, 3};
		int counter = 0;
		for (Integer i : t) {
			assertTrue(correctAnswers[counter++].equals(i));
		}
	}
	
	private static class Apple implements Comparable<Apple> {
		private String flavor;
		public Apple(String flavor) {
			this.flavor = flavor;
		}
		@Override
		public int compareTo(Apple o) {
			return flavor.compareTo(o.flavor);
		}
	}
	
	@Test 
	public void testEasyCompareTo() {
		Apple small = new Apple("Aardvark Flavor");
		Apple medium = new Apple("Medium Flavor");
		Apple big = new Apple("Zebra Flavor");
		Triple<Apple> t1 = new Triple<>(big, small, small);
		Triple<Apple> t2 = new Triple<>(small, medium, medium);
		assertTrue(t1.compareTo(t2) > 0);
	}

}
