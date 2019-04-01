package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for Uptree Class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class UpTreeTest {
	/**
	 * Test for UpTree such as union and find the parent count
	 */
	@Test
	public void test() {
		Highway h1 = new Highway(0, 1, 10.0, 30);
		Highway h2 = new Highway(1, 2, 12.0, 25);
		Highway h3 = new Highway(1, 3, 14.0, 40);
		Highway h4 = new Highway(2, 3, 9.0, 12);

		UpTreeNode<Integer, Highway> h1v1 = new UpTreeNode<Integer, Highway>(h1.getCity1(), h1);
		UpTreeNode<Integer, Highway> h1v2 = new UpTreeNode<Integer, Highway>(h1.getCity2(), h1);
		UpTreeNode<Integer, Highway> h2v1 = new UpTreeNode<Integer, Highway>(h2.getCity1(), h2);
		UpTreeNode<Integer, Highway> h2v2 = new UpTreeNode<Integer, Highway>(h2.getCity2(), h2);

		UpTreeNode<Integer, Highway> h3v1 = new UpTreeNode<Integer, Highway>(h3.getCity1(), h3);
		UpTreeNode<Integer, Highway> h3v2 = new UpTreeNode<Integer, Highway>(h3.getCity2(), h3);
		UpTreeNode<Integer, Highway> h4v1 = new UpTreeNode<Integer, Highway>(h4.getCity1(), h4);
		UpTreeNode<Integer, Highway> h4v2 = new UpTreeNode<Integer, Highway>(h4.getCity2(), h4);

		UpTree<Integer, Highway> uptree = new UpTree<Integer, Highway>();

		// Join 0 and 1 got 0 as parent
		uptree.union(h1v1, h1v2);
		// System.out.println("Parent of this " + h1v1.key + " is " +
		// uptree.find(h1v1).key);
		// System.out.println("Parent of this " + h1v2.key + " is " +
		// uptree.find(h1v2).key);
		assertEquals(h1v1.key, uptree.find(h1v2).key);
		// Now h1v1 is the parent
		assertEquals(2, h1v1.count);
		assertEquals(1, h1v2.count);

		// Now h2v1 is the parent
		uptree.union(h2v1, h2v2); // got vertex 1 as parent
		assertEquals(2, h2v1.count);

		// Now h3v1 is the parent
		uptree.union(h3v1, h3v2); // got vertex 1 as parent
		assertEquals(2, h2v1.count);

		// Now h3v1 is the parent
		uptree.union(h4v1, h4v2); // got vertex 2 as parent
		assertEquals(2, h4v1.count);

		// Parent of vertex 2 and parent of vertex 1 = 2
		// Now h3v1 is the parent therefore
		uptree.union(h4v1, h3v1); // got vertex 2 as parent
		assertEquals(4, h4v1.count);
		assertEquals(2, h3v1.count);

		// Parent of vertex 1 vs parent of vertex 2 = 2
		// Since h4v1 is the bigger parent
		uptree.union(h2v1, h4v1); // got vertex 2 as parent
		assertEquals(6, h4v1.count);
		assertEquals(2, h2v1.count);

	}

}
