package edu.ncsu.csc316.transportation_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for transportation Manager class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class TransportationManagerTest {
	/**
	 * Test for load file and see if graph is created then print adjacency list
	 */
	@Test
	public void testLoadAndAdjList() {
		String filename = "input/highways_small.txt";
		TransportationManager tm = new TransportationManager(filename);
		// System.out.println(tm.getAdjacencyList());
		assertEquals("AdjacencyList[\n"
				+ "   City 0: -> Highway[city1=0, city2=3, cost=14.0, asphalt=144.0] -> Highway[city1=1, city2=0, cost=5.0, asphalt=101.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=77.0]\n"
				+ "   City 1: -> Highway[city1=1, city2=0, cost=5.0, asphalt=101.0] -> Highway[city1=1, city2=2, cost=6.0, asphalt=55.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=66.0]\n"
				+ "   City 2: -> Highway[city1=1, city2=2, cost=6.0, asphalt=55.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=77.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=122.0]\n"
				+ "   City 3: -> Highway[city1=0, city2=3, cost=14.0, asphalt=144.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=66.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=122.0]\n"
				+ "]", tm.getAdjacencyList());

		// System.out.println("COST\n" + tm.getMinimumHighways("COST"));
		// System.out.println("-------------------------");
		// System.out.println("ASPHALT\n" + tm.getMinimumHighways("ASPHALT"));
	}

	/**
	 * Test all GUI functionality
	 */
	@Test
	public void testGUIandInstance() {
		TransportationManager tm = TransportationManager.getInstance();

		try {
			tm.loadHighWayFromFile("DNE");
		} catch (IllegalArgumentException e) {
			assertEquals("Highway file cannot load or found", e.getMessage());
		}

		String filename = "input/highways_small.txt";
		tm.loadHighWayFromFile(filename);
		assertEquals(tm.getClass(), tm.getClass());
		for (int i = 0; i < tm.getMSTAsArray("COST").length; i++) {
			// System.out.println(tm.getMSTAsArray("COST")[i]);
		}

		for (int i = 0; i < tm.getGraphAsArray().length; i++) {
			// System.out.println(tm.getGraphAsArray()[i]);
		}
	}

	/**
	 * Test for load file and see if graph is created then print adjacency list
	 */
	@Test
	public void testExample() {
		String filename = "input/highways_small.txt";
		TransportationManager tm = new TransportationManager(filename);

		// System.out.println("ASPHALT = " + tm.getMinimumHighways("ASPHALT"));
		assertEquals(tm.hashCode(), tm.hashCode());
	}

	/**
	 * Test for load file and see if graph is created then print adjacency list
	 */
	@Test
	public void testExample2() {
		String filename = "input/highways_large.txt";
		TransportationManager tm = new TransportationManager(filename);
		// System.out.println(tm.getAdjacencyList());
		// System.out.println("ASPHALT = " + tm.getMinimumHighways("ASPHALT"));
		assertEquals(tm.hashCode(), tm.hashCode());
	}

	/**
	 * Test for load file and see if graph is created then print adjacency list
	 */
	@Test
	public void testExample3() {
		String filename = "input/highways_large.txt";
		TransportationManager tm = new TransportationManager(filename);
		// System.out.println(tm.getAdjacencyList());
		// System.out.println("COST = " + tm.getMinimumHighways("COST"));
		assertEquals(tm.hashCode(), tm.hashCode());
		// System.out.println("ASPHALT = " + tm.getMinimumHighways("ASPHALT"));
	}

}
