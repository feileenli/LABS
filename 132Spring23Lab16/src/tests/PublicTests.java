package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import implementation.Database;

public class PublicTests {
	static Database db;
	static {
		db = new Database();
		db.add("Joe", "CMSC131");
		db.add("Fred", "CMSC131");
		db.add("Susan", "CMSC131");
		db.add("Susan", "CMSC132");
		db.add("Susan", "CMSC250");
		db.add("Sam", "CMSC131");
		db.add("Sam", "CMSC132");
	}
	
	@Test
	public void testSimple1() {		
		assertTrue(db.courses.size() == 4);  // there are 4 students (keys)
	}
	
	@Test
	public void testSimple2() {
		List<String> courseList = db.courses.get("Susan");
		assertTrue(courseList.size() == 3);  // Susan is taking 3 courses
	}
		
	@Test
	public void testSimple3() {
		db.remove("Sam", "CMSC433");
		db.remove("Sam", "CMSC411");
		List<String> courseList = db.courses.get("Sam");
		assertTrue(courseList.size() == 2);   // nothing happened
		db.remove("Sam", "CMSC131");
		courseList = db.courses.get("Sam");
		assertTrue(courseList.size() == 1);   // one course was removed
	}
	
	@Test
	public void testSimple4() {
		assertTrue(db.isAnyoneTaking("CMSC132"));
		assertFalse(db.isAnyoneTaking("CMSC430"));
	}
	
	@Test
	public void testAdd() {
		Database d = new Database();
		for (int i = 0; i < 10; i++) {
			for (int j = 100; j < 200; j++) {
				String course = String.valueOf(j + i);
				d.add(String.valueOf(i), course);
			}
		}
		assertTrue(d.courses.size() == 10);
		for (int i = 0; i < 10; i++) {
			List<String> courses = d.courses.get(String.valueOf(i));
			assertTrue(courses.size() == 100);
			for (int j = 100; j < 200; j++) {
				String course = String.valueOf(j + i);
				assertTrue(courses.contains(course));
			}
		}
	}
	
	@Test
	public void testRemove() {
		Database d = new Database();
		for (int i = 0; i < 10; i++) {
			for (int j = 100; j < 200; j++) {
				String course = String.valueOf(j + i);
				d.add(String.valueOf(i), course);
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 100; j < 100 + i; j++) {
				String course = String.valueOf(i + j);
				d.remove(String.valueOf(i), course);
			}
		}
		for (int i = 0; i < 10; i++) {
			List<String> courses = d.courses.get(String.valueOf(i));
			assertTrue(courses.size() == 100 - i);
			for (int j = 100 + i; j < 200; j++) {
				String course = String.valueOf(i + j);
				assertTrue(courses.contains(course));
			}
		}
	}
	
	@Test
	public void testIsAnyoneTaking() {
		Database d = new Database();
		for (int i = 0; i < 10; i++) {
			for (int j = 100; j < 200; j++) {
				String course = String.valueOf(j + i);
				d.add(String.valueOf(i), course);
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 100; j < 200; j++) {
				String course = String.valueOf(i + j);
				assertTrue(d.isAnyoneTaking(course));
			}
		}
		assertFalse(d.isAnyoneTaking("math"));
	}

}
