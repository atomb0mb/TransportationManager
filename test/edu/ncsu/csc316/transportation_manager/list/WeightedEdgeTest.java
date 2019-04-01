package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for weighted Edge Class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class WeightedEdgeTest {
	/**
	 * Test compareTo
	 */
	@Test
	public void test() {
		WeightedEdge<Integer, Integer> we1 = new WeightedEdge<Integer, Integer>(0, 1, 1000);
		WeightedEdge<Integer, Integer> we2 = new WeightedEdge<Integer, Integer>(1, 2, 1000);

		assertEquals(0, we1.compareTo(we2));

		we2 = new WeightedEdge<Integer, Integer>(0, 3, 1200);
		assertEquals(-1, we1.compareTo(we2));

		Vertex<Integer> v1 = new Vertex<Integer>(0);
		Vertex<Integer> v2 = new Vertex<Integer>(3);
		we1 = new WeightedEdge<Integer, Integer>(v1, v2, 1200);
		assertEquals(0, we1.compareTo(we2));

	}

	/**
	 * Test compareTo AND VALUE
	 */
	@Test
	public void test2() {
		Highway h1 = new Highway(0, 1, 2.0, 1.6);
		Highway h2 = new Highway(0, 2, 4.0, 1.6);
		WeightedEdge<Integer, Highway> we1 = new WeightedEdge<Integer, Highway>(0, 1, h1);
		WeightedEdge<Integer, Highway> we2 = new WeightedEdge<Integer, Highway>(0, 2, h2);
		assertEquals(-1, we1.compareTo(we2));
		// System.out.println(we1.weight);

		assertEquals(0, we1.v1.value, 0);
		assertEquals(1, we1.v2.value, 0);
		assertEquals(-1, we1.weight.compareTo(we2.weight));

	}

}
