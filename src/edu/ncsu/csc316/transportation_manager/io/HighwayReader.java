package edu.ncsu.csc316.transportation_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.GenericGraph;
import edu.ncsu.csc316.transportation_manager.list.Vertex;
import edu.ncsu.csc316.transportation_manager.list.WeightedEdge;

/**
 * HighwayReader opens and reads a textfile that contains city connections and
 * budget of building highway cost and amount of asphalt to build highway.
 * Partial Codes from packScheduler and 316 project 1, 2
 * 
 * @author Chee Ng (cwng)
 *
 */
public class HighwayReader {

	/**
	 * Reads a file and generates a list of highway building budget via city1 to
	 * city2. If the file to read cannot be found or the permissions are incorrect a
	 * FileNotFoundException is thrown.
	 * 
	 * @param filename
	 *            of highway textfile
	 * @return A list of highway building budget
	 * @throws FileNotFoundException
	 *             If the file cannot be found or read
	 */
	public static GenericGraph<Integer, Highway> readHighwayFile(String filename) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(filename));
		GenericGraph<Integer, Highway> graph = new GenericGraph<Integer, Highway>();
		while (fileReader.hasNextLine()) {
			try {

				WeightedEdge<Integer, Highway> edge = readFile(fileReader.nextLine());
				graph.insertEdge(edge);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} // end of while
		fileReader.close();
		return graph;

	}

	/**
	 * Parses a single line to create a new course object with properties: city1,
	 * city2, cost, and asphalt
	 * 
	 * @param nextLine
	 *            A single line from the input file denoting a class and its
	 *            properties
	 * @return WeightedEdge object
	 */
	private static WeightedEdge<Integer, Highway> readFile(String nextLine) {
		Scanner lineReader = new Scanner(nextLine);
		// lineReader.useDelimiter("\\s*");
		try {
			int city1 = lineReader.nextInt();

			int city2 = lineReader.nextInt();

			double cost = lineReader.nextDouble();

			double asphalt = lineReader.nextDouble();

			lineReader.close();
			Highway hw = new Highway(city1, city2, cost, asphalt);
			Vertex<Integer> v1 = new Vertex<Integer>(city1);
			Vertex<Integer> v2 = new Vertex<Integer>(city2);
			WeightedEdge<Integer, Highway> edge = new WeightedEdge<Integer, Highway>(v1, v2, hw);
			// System.out.println("WeightedEdge is " + edge.weight);
			return edge;

		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Error in Read HighwayFile");
		}
	}

}
