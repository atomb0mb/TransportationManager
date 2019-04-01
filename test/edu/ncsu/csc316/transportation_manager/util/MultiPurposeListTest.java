package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for Custom MultiPurposeList class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class MultiPurposeListTest {

	/**
	 * Test for list if empty
	 */
	@Test(timeout = 1000)
	public void testBasic() {
		MultiPurposeList<String> list = new MultiPurposeList<>();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	/**
	 * Test for all throws
	 */
	@Test(timeout = 1000)
	public void testthrows() {
		MultiPurposeList<String> list = new MultiPurposeList<>();
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
	 * Test for add, index o, contain, remove
	 */
	@Test(timeout = 1000)
	public void testfunctionality() {
		MultiPurposeList<String> list = new MultiPurposeList<>();
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
		// Index of
		assertEquals(0, list.indexOf("z"));
		assertEquals(-1, list.indexOf("where"));
		assertTrue(list.contains("z"));
		assertFalse(list.contains("huh"));

	}

	/**
	 * Test for add
	 */
	@Test(timeout = 1000)
	public void testClear() {
		MultiPurposeList<String> list = new MultiPurposeList<>();
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

	/**
	 * Test for add
	 */
	@Test(timeout = 1000)
	public void testmergeSort() {
		MultiPurposeList<String> list = new MultiPurposeList<>();
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

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }

		list.mergeSort(0, list.size() - 1);
		// System.out.println("----After sorted-----------");
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }
		assertEquals(16, list.size());

	}
}
