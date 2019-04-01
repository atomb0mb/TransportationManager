package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.util.MultiPurposeList;

/**
 * AdjacencyList display list of adjacency of the graph
 * 
 * @author Chee Ng (cwng)
 *
 */
public class AdjacencyList {
	private MultiPurposeList<Highway>[] adjListMap;
	private int size = 0;

	/**
	 * Construct the Adjacency list map
	 * 
	 * @param numVertices
	 *            is number of vertices
	 */
	@SuppressWarnings("unchecked")
	public AdjacencyList(int numVertices) {
		size = numVertices;
		adjListMap = new MultiPurposeList[size];
		for (int i = 0; i < numVertices; i++) {
			// adjListMap[i] = new MultiPurposeList<Highway>();
			adjListMap[i] = new MultiPurposeList<Highway>();
		}
	}

	/**
	 * Add the edges to the Adjacency list map
	 * 
	 * @param hw
	 *            of highway object
	 */
	public void addEdges(Highway hw) {
		adjListMap[hw.getCity1()].add(hw);
		adjListMap[hw.getCity2()].add(hw);
	}

	/**
	 * outEdges return the current vertex in Adjacency list map
	 * 
	 * @param i
	 *            of index of current vertex
	 * @return the current vertex
	 */
	public MultiPurposeList<Highway> outEdges(int i) {
		return adjListMap[i];
	}
}
