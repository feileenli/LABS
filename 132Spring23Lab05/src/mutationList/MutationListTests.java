package mutationList;

import static org.junit.Assert.*;

import org.junit.Test;

public class MutationListTests {

	@Test
	public void testAdd() {
		MutationList list = new MutationList();
		list.add(7);
		assertTrue(list.contains(7));
		assertFalse(list.contains(22));
		assertEquals(list.get(0), Integer.valueOf(7));
	}

	@Test
	public void testMutation() {
		MutationList list = new MutationList();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		list.mutate();
		for (int i = 0; i < 50; i++) {
			assertTrue(list.get(i) == i + 1 || list.get(i) == i - 1);
		}
	}

	@Test
	public void testRemoveObject() {
		MutationList list = new MutationList();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		assertThrows(UnsupportedOperationException.class, ()->{
			list.remove(Integer.valueOf(7));
		});
	}

	@Test
	public void testRemoveByIndex() {
		MutationList list = new MutationList();

		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		assertThrows(UnsupportedOperationException.class, ()->{
			list.remove(12);
		});
	}

}
