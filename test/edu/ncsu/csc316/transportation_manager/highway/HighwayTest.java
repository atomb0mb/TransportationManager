package edu.ncsu.csc316.transportation_manager.highway;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for highway class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class HighwayTest {
	/**
	 * Test for Highway constructor, getter, to string,
	 */
	@Test
	public void testFullFFunctionality() {
		Highway h1 = new Highway(0, 1, 10, 30);
		Highway h2 = new Highway(1, 2, 12.2, 34);

		assertEquals(0, h1.getCity1());
		assertEquals(1, h1.getCity2());
		assertEquals(1, h2.getCity1());
		assertEquals(2, h2.getCity2());
		assertEquals(10, h1.getCost(), 0);
		assertEquals(12.2, h2.getCost(), 0);
		assertEquals(30, h1.getAsphalt(), 0);
		assertEquals(34, h2.getAsphalt(), 0);

		assertEquals("Highway[city1=0, city2=1, cost=10.0, asphalt=30.0]", h1.toString());
		assertEquals("Highway[city1=1, city2=2, cost=12.2, asphalt=34.0]", h2.toString());

	}

	/**
	 * Test Comparable
	 */
	@Test
	public void testComparable() {
		Highway h1 = new Highway(0, 1, 10, 30);
		Highway h2 = new Highway(0, 2, 12.2, 34);
		Highway h3 = new Highway(1, 2, 10, 30);
		Highway h4 = new Highway(1, 2, 12.2, 34);
		Highway h5 = new Highway(1, 2, 10, 31);
		Highway h6 = new Highway(1, 2, 10, 31);

		assertEquals(0, h5.compareTo(h6));
		assertEquals(-1, h1.compareTo(h2));
		assertEquals(-1, h1.compareTo(h3));
		assertEquals(-2, h3.compareTo(h4));
	}

}
