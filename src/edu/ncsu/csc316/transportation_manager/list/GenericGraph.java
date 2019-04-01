package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.util.MultiPurposeList;

/**
 * Code from Adam Gaweda TYPOS. GenericGraph V and E extends the comparable and
 * it creates a graph contains all edges.
 * 
 * @author Chee Ng (cwng)
 *
 * @param <V>
 *            of vertices to be compared
 * @param <E>
 *            of Weightedge to be compared
 */
public class GenericGraph<V extends Comparable<V>, E extends Comparable<E>> {
	/**
	 * ArrayList of vertices
	 */
	public MultiPurposeList<Vertex<V>> vertices;
	/**
	 * ArrayList of weight edges
	 */
	public MultiPurposeList<WeightedEdge<V, E>> edges;

	/**
	 * Construct list for vertices and list for edges
	 */
	public GenericGraph() {
		vertices = new MultiPurposeList<Vertex<V>>();
		edges = new MultiPurposeList<WeightedEdge<V, E>>();
	}

	/**
	 * Insert edge contains vertex 1 and vertex 2
	 * 
	 * @param edge
	 *            of weighted edge to be add
	 */
	public void insertEdge(WeightedEdge<V, E> edge) {
		// Help reduce amount of typing
		Vertex<V> v1 = edge.v1;
		Vertex<V> v2 = edge.v2;
		// Find the vertices of this edge on the graph
		if (!vertices.contains(v1)) {
			vertices.add(v1);
			v1 = vertices.get(vertices.indexOf(v1));
		}
		// Repeat for the other vertex
		if (!vertices.contains(v2)) {
			vertices.add(v2);
			v2 = vertices.get(vertices.indexOf(v2));
		}
		// See if the edge between these two vertices exists
		if (!edges.contains(edge)) {
			edges.add(edge);
		}
		// finally add v1 and v2 to each other neighbors if they are not already
		// neighbors; note, a graph could have multiple edges between two nodes.

		if (!v1.neighbors.contains(v2)) {
			v1.neighbors.add(v2);
		}

		if (!v2.neighbors.contains(v1)) {
			v2.neighbors.add(v1);
		}
	}

}
