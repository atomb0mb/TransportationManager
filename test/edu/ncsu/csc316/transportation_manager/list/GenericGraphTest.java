package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for generic graph class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class GenericGraphTest {
	/**
	 * Test inserting the Edge
	 */
	@Test
	public void testINsert() {
		GenericGraph<Character, Integer> graph = new GenericGraph<Character, Integer>();

		WeightedEdge<Character, Integer> edge = new WeightedEdge<Character, Integer>('A', 'B', 1);
		assertTrue(graph.edges.isEmpty());
		graph.insertEdge(edge);
		assertTrue(graph.edges.contains(edge));

		edge = new WeightedEdge<Character, Integer>('B', 'E', 1);
		graph.insertEdge(edge);
		assertFalse(graph.edges.isEmpty());
		edge = new WeightedEdge<Character, Integer>('B', 'D', 1);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('B', 'C', 1);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('F', 'G', 3);
		graph.insertEdge(edge);
	}

}
