package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for vertex class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class VertexTest {
	/**
	 * Test equals and compareTo and neighbours
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void test() {
		Vertex<Character> v1 = new Vertex<Character>('A');
		Vertex<Character> v2 = new Vertex<Character>('B');
		Vertex<Character> v3 = new Vertex<Character>('A');

		int expected = -1;
		assertEquals(expected, v1.compareTo(v2));
		expected = 0;
		assertEquals(expected, v1.compareTo(v3));
		// System.out.println(v1.neighbors);
		assertEquals(v1.value, v3.value);
		v1.neighbors.add(v2);
		assertEquals(v1.neighbors.get(0).value, v2.value);
		assertTrue(v1.equals(v3));
		assertFalse(v1.equals(v2));
		char a = 'A';
		assertFalse(v1.equals(a));
		String dne = null;
		assertFalse(v1.equals(dne));
		// assertFalse(v1.isLinked);
		// v1.setLinked(true);
		// assertTrue(v1.isLinked);
		// boolean flag = v1.isLinked();
		// assertTrue(flag);
	}

}
