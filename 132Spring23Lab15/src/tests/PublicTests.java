package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import implementation.MyArrayStack;
import implementation.MyLinkedListStack;
import implementation.MyStack;

public class PublicTests {

	@Test
	public void testEasyArrayImplementation() {
		stackTest(new MyArrayStack<Integer>());
	}
	
	@Test
	public void testEashLinkedListImplementation() {
		stackTest(new MyLinkedListStack<Integer>());
	}
	
	private static void stackTest(MyStack<Integer> s) {
		s.push(5);
		s.push(8);
		s.push(11);
		assertTrue(s.pop().equals(11));
		assertTrue(s.pop().equals(8));
		assertTrue(s.pop().equals(5));
	}
	
	@Test
	public void verifyLinkedListPush() {
		MyLinkedListStack<String> s = new MyLinkedListStack<String>();
		s.push("hi");
		s.push("there");
		s.push("friend");
		MyLinkedListStack<String>.Node h = s.head;
		assertTrue(h.data.equals("friend"));
		assertTrue(h.next.data.equals("there"));
		assertTrue(h.next.next.data.equals("hi"));
		
		for (int i = 0; i < 60; i++) {
			s.push("aaa");
		}
		
		h = s.head;
		for (int i = 0; i < 62; i++) {
			h = h.next;
		}
		assertTrue(h.data.equals("hi"));
		assertTrue(h.next == null);
	}
	
	@Test
	public void testLinkedListStructurePop() {
		MyLinkedListStack<String> s = new MyLinkedListStack<String>();
		s.push("hi");
		s.push("there");
		s.push("friend");
		MyLinkedListStack<String>.Node h = s.head;
		
		for (int i = 0; i < 60; i++) {
			s.push(String.valueOf(i));
		}
		
		for (int i = 0; i < 30; i++) {
			String c = String.valueOf(59 - i);
			String d = s.pop();
			assertTrue(c.equals(d));
		}
		h = s.head;
		for (int i = 0; i < 32; i++) {
			h = h.next;
		}
		assertTrue(h.data.equals("hi"));
		assertTrue(h.next == null);
	}
	
	@Test
	public void verifyArrayStructurePush() {
		MyArrayStack<String> a = new MyArrayStack<String>();
		a.push("hi");
		a.push("there");
		a.push("friend");
		Object[] x = a.array;
		assertTrue(x.length == 10);
		assertTrue(((String)x[0]).equals("hi"));
		assertTrue(((String)x[1]).equals("there"));
		assertTrue(((String)x[2]).equals("friend"));
		
		for (int i = 0; i < 60; i++) {
			a.push(String.valueOf(i));
		}
		x = a.array;
		assertTrue(x.length == 80);
		assertTrue(((String)x[62]).equals("59"));
		assertTrue(x[63] == null);
	}

	@Test
	public void testArrayStructurePop() {
		MyArrayStack<String> a = new MyArrayStack<String>();
		a.push("hi");
		a.push("there");
		a.push("friend");
		Object[] x = a.array;
		
		assertTrue(a.pop().equals("friend"));
		assertTrue(a.pop().equals("there"));
		assertTrue(a.pop().equals("hi"));
		
		for (int i = 0; i < 60; i++) {
			a.push(String.valueOf(i));
		}
		for (int i = 0; i < 30; i++) {
			String c = a.pop();
			String d = String.valueOf(59 - i);
			assertTrue(c.equals(d));
		}
		x = a.array;
		assertTrue(((String)x[29]).equals("29"));
		assertTrue(a.size == 30);
		
	}

}
