package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for Heap Class
 * 
 * @author Chee Ng (cwng)
 *
 */
public class HeapTest {

	/**
	 * Test for HeapNode of cost as the key
	 */
	@Test
	public void testHeapNode() {
		Heap<HeapNode<Double, Highway>, Highway> h = new Heap<>();
		// cost
		Highway h1 = new Highway(0, 1, 10.0, 30);
		Highway h2 = new Highway(1, 2, 12.0, 30);

		HeapNode<Double, Highway> hn1 = new HeapNode<Double, Highway>(h1.getCost(), h1);
		HeapNode<Double, Highway> hn2 = new HeapNode<Double, Highway>(h2.getCost(), h2);
		h.insert(hn1, h1);
		h.insert(hn2, h2);

		HeapNode<HeapNode<Double, Highway>, Highway> expected1 = h.removeMin();
		HeapNode<HeapNode<Double, Highway>, Highway> expected2 = h.removeMin();

		assertEquals(expected1.data, hn1.data);
		assertEquals(expected2.data, hn2.data);

	}

	/**
	 * Test for HeapNode of Asphalt as the key
	 */
	@Test
	public void testHeapAsphalt() {
		Heap<Double, HeapNode<Double, Highway>> h = new Heap<Double, HeapNode<Double, Highway>>();
		// Asphalt
		Highway h1 = new Highway(0, 1, 15.0, 300); // 6
		HeapNode<Double, Highway> hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		// System.out.println("Current min = " + h.peekMin().priority);

		h1 = new Highway(0, 1, 9.0, 150); // 4
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		// System.out.println("Current min = " + h.peekMin().priority);

		h1 = new Highway(0, 1, 11.0, 100); // 2
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		// System.out.println("Current min = " + h.peekMin().priority);

		h1 = new Highway(0, 1, 15.0, 222); // 5
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		// System.out.println("Current min = " + h.peekMin().priority);

		h1 = new Highway(0, 1, 22.0, 80); // 1
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		// System.out.println("Current min = " + h.peekMin().priority);

		h1 = new Highway(1, 2, 9.0, 320); // 7
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		h1 = new Highway(0, 1, 2.0, 120); // 3
		hn1 = new HeapNode<Double, Highway>(h1.getAsphalt(), h1);
		h.insert(hn1.priority, hn1);

		HeapNode<Double, HeapNode<Double, Highway>> expected1 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected2 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected3 = h.removeMin();
		// System.out.println("Removed min is " + expected3.priority);
		HeapNode<Double, HeapNode<Double, Highway>> expected4 = h.removeMin();
		// System.out.println("Removed min is " + expected4.priority);
		HeapNode<Double, HeapNode<Double, Highway>> expected5 = h.removeMin();
		// System.out.println("Removed min is " + expected5.priority);
		HeapNode<Double, HeapNode<Double, Highway>> expected6 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected7 = h.removeMin();

		assertEquals(expected1.priority, 80, 0);
		assertEquals(expected2.priority, 100, 0);
		assertEquals(expected3.priority, 120, 0);
		assertEquals(expected4.priority, 150, 0);
		assertEquals(expected5.priority, 222, 0);
		assertEquals(expected6.priority, 300, 0);
		assertEquals(expected7.priority, 320, 0);

	}

	/**
	 * Test capacity
	 */
	public void testCapacity() {
		Heap<Double, HeapNode<Double, Highway>> h = new Heap<>();
		assertNull(h.removeMin());
		// Asphalt
		Highway h1 = new Highway(0, 1, 19.0, 31); // 14
		Highway h2 = new Highway(0, 1, 11.0, 12); // 9
		Highway h3 = new Highway(0, 1, 16.0, 320); // 12
		Highway h4 = new Highway(0, 1, 14.0, 300); // 11
		Highway h5 = new Highway(0, 1, 10.0, 300); // 8
		Highway h6 = new Highway(0, 1, 12.0, 300); // 10
		Highway h7 = new Highway(0, 1, 5.0, 310); // 4
		Highway h8 = new Highway(0, 1, 9.0, 300); // 7
		Highway h9 = new Highway(0, 1, 18.0, 360); // 13
		Highway h10 = new Highway(0, 1, 1.0, 50); // 1
		Highway h11 = new Highway(0, 1, 4.0, 300); // 3
		Highway h12 = new Highway(0, 1, 2.0, 45); // 2
		Highway h13 = new Highway(0, 1, 20.0, 322); // 15
		Highway h14 = new Highway(0, 1, 8.6, 311); // 6
		Highway h15 = new Highway(0, 1, 7.0, 100); // 5

		HeapNode<Double, Highway> hn1 = new HeapNode<Double, Highway>(h1.getCost(), h1);
		HeapNode<Double, Highway> hn2 = new HeapNode<Double, Highway>(h2.getCost(), h2);
		HeapNode<Double, Highway> hn3 = new HeapNode<Double, Highway>(h3.getCost(), h3);
		HeapNode<Double, Highway> hn4 = new HeapNode<Double, Highway>(h4.getCost(), h4);
		HeapNode<Double, Highway> hn5 = new HeapNode<Double, Highway>(h5.getCost(), h5);
		HeapNode<Double, Highway> hn6 = new HeapNode<Double, Highway>(h6.getCost(), h6);
		HeapNode<Double, Highway> hn7 = new HeapNode<Double, Highway>(h7.getCost(), h7);
		HeapNode<Double, Highway> hn8 = new HeapNode<Double, Highway>(h8.getCost(), h8);
		HeapNode<Double, Highway> hn9 = new HeapNode<Double, Highway>(h9.getCost(), h9);
		HeapNode<Double, Highway> hn10 = new HeapNode<Double, Highway>(h10.getCost(), h10);
		HeapNode<Double, Highway> hn11 = new HeapNode<Double, Highway>(h11.getCost(), h11);
		HeapNode<Double, Highway> hn12 = new HeapNode<Double, Highway>(h12.getCost(), h12);
		HeapNode<Double, Highway> hn13 = new HeapNode<Double, Highway>(h13.getCost(), h13);
		HeapNode<Double, Highway> hn14 = new HeapNode<Double, Highway>(h14.getCost(), h14);
		HeapNode<Double, Highway> hn15 = new HeapNode<Double, Highway>(h15.getCost(), h15);

		h.insert(hn1.priority, hn1);
		h.insert(hn2.priority, hn2);
		h.insert(hn3.priority, hn3);
		h.insert(hn4.priority, hn4);
		h.insert(hn5.priority, hn5);
		h.insert(hn6.priority, hn6);
		h.insert(hn7.priority, hn7);
		h.insert(hn8.priority, hn8);
		h.insert(hn9.priority, hn9);
		h.insert(hn10.priority, hn10);
		h.insert(hn11.priority, hn11);
		h.insert(hn12.priority, hn12);
		h.insert(hn13.priority, hn13);
		h.insert(hn14.priority, hn14);
		h.insert(hn15.priority, hn15);

		HeapNode<Double, HeapNode<Double, Highway>> expected1 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected2 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected3 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected4 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected5 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected6 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected7 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected8 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected9 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected10 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected11 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected12 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected13 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected14 = h.removeMin();
		HeapNode<Double, HeapNode<Double, Highway>> expected15 = h.removeMin();

		assertEquals(expected1.priority, hn10.priority);
		assertEquals(expected2.priority, hn12.priority);
		assertEquals(expected3.priority, hn11.priority);
		assertEquals(expected4.priority, hn7.priority);
		assertEquals(expected5.priority, hn15.priority);
		assertEquals(expected6.priority, hn14.priority);
		assertEquals(expected7.priority, hn8.priority);
		assertEquals(expected8.priority, hn5.priority);
		assertEquals(expected9.priority, hn2.priority);
		assertEquals(expected10.priority, hn6.priority);
		assertEquals(expected11.priority, hn4.priority);
		assertEquals(expected12.priority, hn3.priority);
		assertEquals(expected13.priority, hn9.priority);
		assertEquals(expected14.priority, hn1.priority);
		assertEquals(expected15.priority, hn13.priority);

	}

	/**
	 * Test for HeapNode of cost as the key
	 */
	@Test
	public void testHeapInsertionOrdered() {
		Heap<Integer, Integer> h = new Heap<Integer, Integer>();

		h.insert(3, 15);
		h.insert(4, 15);
		h.insert(7, 20);
		h.insert(8, 11);
		h.insert(10, 10);
		h.insert(12, 11);

		for (int i = 0; i < h.getNext(); i++) {
			// System.out.println(h.get(i).priority);
		}

		HeapNode<Integer, Integer> expected1 = h.removeMin();
		HeapNode<Integer, Integer> expected2 = h.removeMin();
		HeapNode<Integer, Integer> expected3 = h.removeMin();
		HeapNode<Integer, Integer> expected4 = h.removeMin();
		// System.out.println(h.peekMin().priority);
		HeapNode<Integer, Integer> expected5 = h.removeMin();
		// System.out.println(h.peekMin().priority);
		HeapNode<Integer, Integer> expected6 = h.removeMin();

		assertEquals(expected1.priority, 3, 0);
		assertEquals(expected2.priority, 4, 0);
		assertEquals(expected3.priority, 7, 0);
		assertEquals(expected4.priority, 8, 0);
		assertEquals(expected5.priority, 10, 0);
		assertEquals(expected6.priority, 12, 0);

	}

	/**
	 * Test for Insertion unordered and peek and get and grow capacity
	 */
	@Test
	public void testHeaptestHeapInsertionUnordered() {
		Heap<Integer, Integer> h = new Heap<Integer, Integer>();

		assertEquals(null, h.removeMin());
		assertEquals(0, h.getNext());

		try {
			h.peekMin();
			fail();
		} catch (IllegalArgumentException e) {
			//
		}

		h.insert(3, 15);
		h.insert(10, 15);
		h.insert(2, 20);
		h.insert(4, 11);
		h.insert(1, 10);
		h.insert(5, 11);
		h.insert(7, 10);
		h.insert(6, 11);

		assertEquals(1, h.get(0).priority, 0);

		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		// Test grow capacity
		assertEquals(1, h.peekMin().priority, 0);
		assertEquals(1, h.removeMin().priority, 0);
		Heap<Integer, Integer> h2 = new Heap<Integer, Integer>();
		for (int i = 0; i < 1030; i++) {
			h2.insert(i, i + 2);
		}
	}

	/**
	 * Test if insertion and remove works properly
	 */
	@Test
	public void diablolicalTestInsertionRemove() {
		Heap<Integer, Integer> h = new Heap<Integer, Integer>();

		h.insert(50, 15);
		h.insert(72, 15);
		h.insert(22, 20);
		h.insert(46, 11);
		h.insert(15, 10);
		h.insert(52, 11);
		h.insert(76, 10);
		h.insert(67, 11);
		h.insert(11, 15);
		h.insert(23, 15);
		h.insert(30, 20);
		h.insert(5, 11);
		h.insert(4, 10);
		h.insert(3, 11);
		h.insert(2, 10);
		h.insert(1, 11);
		assertEquals(16, h.getNext());
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		// int temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// System.out.println(h.get(i).priority);
		// }
		//
		// temp = h.removeMin().priority;
		// System.out.println("Removed min is = " + temp + "\n");
		// for (int i = 0; i < h.getNext(); i++) {
		// if (h.getNext() == 0) {
		// System.out.println("Finish");
		// }
		// System.out.println(h.get(i).priority);
		// }
		// if (h.getNext() == 0) {
		// System.out.println("Finish: Heap is empty");
		// }

	}
}
