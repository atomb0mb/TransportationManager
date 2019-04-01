package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for adjacencyList class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class AdjacencyListTest {
	/**
	 * Test for insert and print the list of adjacency list
	 */
	@Test
	public void testFunctionality() {

		GenericGraph<Integer, Highway> graph = new GenericGraph<Integer, Highway>();
		Highway h1 = new Highway(2, 3, 10, 11);
		Highway hw1 = new Highway(0, 1, 10, 20);
		Highway hw2 = new Highway(1, 2, 11, 20);
		WeightedEdge<Integer, Highway> edge = new WeightedEdge<Integer, Highway>(2, 3, h1);
		WeightedEdge<Integer, Highway> edge2 = new WeightedEdge<Integer, Highway>(0, 1, hw1);
		WeightedEdge<Integer, Highway> edge3 = new WeightedEdge<Integer, Highway>(1, 2, hw2);

		graph.insertEdge(edge2);
		graph.insertEdge(edge3);
		graph.insertEdge(edge);

		assertEquals(4, graph.vertices.size());
		for (int i = 0; i < graph.vertices.size(); i++) {
			Vertex<Integer> v = graph.vertices.get(i);
			assertEquals(i, v.value, 0);
			// System.out.print(v.value + " -> ");
			// for (int j = 0; j < v.neighbors.size(); j++) {
			// System.out.println(v.neighbors.get(j).value + " -> ");
			// }
			// System.out.println("null");
		}

		AdjacencyList graphj = new AdjacencyList(graph.edges.size() + 1);
		// Size is 3
		assertEquals(3, graph.edges.size());
		// Add to Adjacency list map
		for (int x = 0; x < graph.edges.size(); x++) {
			graphj.addEdges(graph.edges.get(x).weight);
		}
		// Size is 4
		for (int i = 0; i < graph.vertices.size(); i++) {
			// System.out.print("City " + i + ": -> ");
			for (int j = 0; j < graphj.outEdges(i).size(); j++) {
				// System.out.print(graphj.outEdges(i).get(j));
				// if (j + 1 == graphj.outEdges(i).size()) {
				// // System.out.println();
				// } else {
				// // System.out.print(" -> ");
				// }
			}

		}

	}
}
