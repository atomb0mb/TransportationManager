package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for Custom ArrayList1 class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class ArrayList1Test {

	/**
	 * Test for list if empty
	 */
	@Test(timeout = 1000)
	public void testBasic() {
		ArrayList1<String> list = new ArrayList1<>();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	/**
	 * Test for all throws
	 */
	@Test(timeout = 1000)
	public void testthrows() {
		ArrayList1<String> list = new ArrayList1<>();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		// add null
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			//
		}
		// get out of bound
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}

		// get out of bound
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}

		// remove out of bound
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}

		// remove out of bound
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}

		// set out of bound
		try {
			list.set(-1, "element");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}

		// set out of bound
		try {
			list.set(0, "element");
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
		list.add("something");
		// set null
		try {
			list.set(0, null);
			fail();
		} catch (NullPointerException e) {
			//
		}
	}

	/**
	 * Test for add
	 */
	@Test(timeout = 1000)
	public void testfunctionality() {
		ArrayList1<String> list = new ArrayList1<>();
		list.add("z");
		list.add("b");
		list.add("j");
		list.add("i");
		list.add("a");
		list.add("b");
		list.add("h");
		list.add("o");
		list.add("y");
		list.add("k");
		list.add("l");
		list.add("n");
		list.add("f");
		list.add("d");
		list.add("c");
		list.add("m");

		assertEquals(16, list.size());
		assertEquals("m", list.get(list.size() - 1));
		assertFalse(list.isEmpty());

		list.remove(0);
		list.set(0, "z");
		list.set(list.size() - 2, "m");

		assertEquals(15, list.size());
		assertEquals("z", list.get(0));
		assertEquals("m", list.get(list.size() - 1));
		assertEquals("m", list.get(list.size() - 2));

		list.remove(list.size() - 1);

	}

	/**
	 * Test for add
	 */
	@Test(timeout = 1000)
	public void testClear() {
		ArrayList1<String> list = new ArrayList1<>();
		list.add("z");
		list.add("b");
		list.add("j");
		list.add("i");
		list.add("a");
		list.add("b");
		list.add("h");
		list.add("o");
		list.add("y");
		list.add("k");
		list.add("l");
		list.add("n");
		list.add("f");
		list.add("d");
		list.add("c");
		list.add("m1");
		list.add("mk");
		list.add("m2");
		list.add("m3");
		list.add("ms");
		list.add("m0");
		list.add("m6");
		list.add("md");
		list.add("zz");
		list.add("mmm");
		list.add("oo");
		assertEquals(26, list.size());
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

	}

	// /**
	// * Test for add update capacity
	// */
	// @Test
	// public void testCapacity() {
	// ArrayList1<String> list = new ArrayList1<>(10);
	// list.add("z");
	// list.add("b");
	// list.add("j");
	// list.add("i");
	// list.add("a");
	//
	// assertEquals(5, list.size());
	//
	// }
}
