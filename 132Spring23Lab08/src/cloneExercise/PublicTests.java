package cloneExercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class PublicTests {

	@Test
	public void TriangleCloneTest() {
		Triangle t = new Triangle(3, 4, 5);
		Triangle s = t.clone();   // should not generate any errors
		assertTrue(t.equals(s));  // should have the same state
		assertFalse(t == s);      // should not be the same object
	}
	
	@Test
	public void TriangleListCloneTest() {
		Triangle[] arr = {new Triangle(1, 2, 3), 
				          new Triangle(4, 5, 6),
				          new Triangle(7, 8, 9)};
		TriangleList original = new TriangleList(arr);
		TriangleList copy = original.clone();   // should not generate any errors
		assertTrue(copy.list.length == 3);
		for (int i = 0; i < copy.list.length; i++) {
			assertTrue(copy.list[i].equals(original.list[i]));
		}
		assertTrue(original != copy);  // should not be the same object
		assertTrue(original.list != copy.list);  // arrays should not be aliases
		for (int i = 0; i < original.list.length; i++) {
			assertTrue(original.list[i] != copy.list[i]);   // Triangles should not be aliases either
		}
	}

}
