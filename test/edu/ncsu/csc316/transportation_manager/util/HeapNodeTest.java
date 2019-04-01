package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for heapNode class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class HeapNodeTest {

	/**
	 * Test for HeapNode comparator
	 */
	@Test
	public void testHeapNode() {
		Highway h1 = new Highway(0, 1, 10.0, 30);
		Highway h2 = new Highway(1, 2, 12.0, 30);

		HeapNode<Double, Highway> hn1 = new HeapNode<Double, Highway>(h1.getCost(), h1);
		HeapNode<Double, Highway> hn2 = new HeapNode<Double, Highway>(h2.getCost(), h2);

		int expected = -1;
		assertEquals(expected, hn1.compareTo(hn2));
	}

}
