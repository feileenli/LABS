import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionTests {

	@Test
	public void testTriangle() {
		assertEquals(0, Recursion.triangle(0));
		assertEquals(1, Recursion.triangle(1));
		assertEquals(3, Recursion.triangle(2));
		assertEquals(6, Recursion.triangle(3));
		assertEquals(5050, Recursion.triangle(100));
	}
	
	@Test
	public void testCountX() {
		assertEquals(4, Recursion.countX("xxhixx"));
		assertEquals(0, Recursion.countX("adsjkajweijefiei"));
		assertEquals(6, Recursion.countX("xyxyxyxyxyx"));
	}
	
	@Test
	public void testSumDigits() {
		assertEquals(7, Recursion.sumDigits(7));
		assertEquals(11, Recursion.sumDigits(29));
		assertEquals(16, Recursion.sumDigits(10345021));
	}
	
	@Test
	public void testPairString() {
		assertEquals("abc", Recursion.pairStar("abc"));
		assertEquals("ab*bc", Recursion.pairStar("abbc"));
		assertEquals("a*ab*b", Recursion.pairStar("aabb"));
		assertEquals("a*a*a*a", Recursion.pairStar("aaaa"));
		assertEquals("ab*b*bc*cd*d*d*d*defg*ghi*i*i", Recursion.pairStar("abbbccdddddefgghiii"));
	}

}
