package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for UpTreeNode CLASS
 * 
 * @author Chee Ng (cwng)
 *
 */
public class UpTreeNodeTest {
	/**
	 * Test for UpTreeNode make set
	 */
	@Test
	public void testUpTreeNode() {
		Highway h1 = new Highway(0, 1, 10.0, 30);
		UpTreeNode<Integer, Highway> utn = new UpTreeNode<Integer, Highway>(h1.getCity1(), h1);
		assertEquals(1, utn.count);
		assertEquals(0, utn.key, 0);
		assertEquals(h1, utn.data);
	}

}
