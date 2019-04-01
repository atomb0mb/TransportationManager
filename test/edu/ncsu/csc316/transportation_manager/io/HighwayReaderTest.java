package edu.ncsu.csc316.transportation_manager.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.GenericGraph;

/**
 * Test highwayReader class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class HighwayReaderTest {
	/**
	 * Test for fail loading file
	 */
	@Test(timeout = 3000)
	public void testError() {
		String falseFileName = "input/fail.txt";

		try {
			GenericGraph<Integer, Highway> faillist = HighwayReader.readHighwayFile(falseFileName);
			assertNull(faillist);
		} catch (FileNotFoundException e) {
			assertEquals(falseFileName + " (No such file or directory)", e.getMessage());
		}

	}

	/**
	 * Test for success loading
	 * 
	 * @throws FileNotFoundException
	 *             if the file cannot be found
	 */
	@Test(timeout = 3000)
	public void testloadHighwaySmallFile() throws FileNotFoundException {
		String filename = "input/highways_small.txt";
		GenericGraph<Integer, Highway> graph = HighwayReader.readHighwayFile(filename);
		HighwayReader afr = new HighwayReader();
		assertEquals(4, graph.vertices.size());
		assertEquals(6, graph.edges.size());
		assertEquals(afr.getClass(), afr.getClass());

	}
}
