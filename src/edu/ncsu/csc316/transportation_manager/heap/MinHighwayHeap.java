package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.util.Heap;
import edu.ncsu.csc316.transportation_manager.util.HeapNode;

/**
 * MinHighwayHeap will manage the highway minimum cost or asphalt as priority
 * 
 * @author Chee Ng (cwng)
 *
 */
public class MinHighwayHeap {
	/** String of Cost **/
	public static final String HW_COST = "COST";
	/** String of Bug **/
	public static final String HW_ASPHALT = "ASPHALT";
	/** To determine the type of HeapNode to be insert **/
	public boolean flag = false;
	/** Minimum Heap Priority Queue **/
	public Heap<HeapNode<Double, Highway>, Highway> mh;

	// /**
	// * Get the size of Heap
	// *
	// * @return size of Heap
	// */
	// public int getSize() {
	// return mh.getNext();
	// }

	/**
	 * Constructs a new Highway heap
	 * 
	 * @param type
	 *            the type of weight to consider ("COST" or "ASPHALT") when
	 *            operating on the heap
	 */
	public MinHighwayHeap(String type) {
		if (type.equals(HW_COST)) {
			flag = true;
			mh = new Heap<HeapNode<Double, Highway>, Highway>();
		}
		if (type.equals(HW_ASPHALT)) {
			flag = false;
			mh = new Heap<HeapNode<Double, Highway>, Highway>();
		}
	}

	/**
	 * Inserts the given Highway into the minheap
	 * 
	 * @param hwy
	 *            the Highway to insert into the minheap
	 */
	public void insert(Highway hwy) {
		if (flag) {
			HeapNode<Double, Highway> hw1 = new HeapNode<Double, Highway>(hwy.getCost(), hwy);
			// System.out.println("Insertion in MinHeap = " + hwy);
			mh.insert(hw1, hwy);
		}
		if (!flag) {
			HeapNode<Double, Highway> hw2 = new HeapNode<Double, Highway>(hwy.getAsphalt(), hwy);
			// System.out.println("Insertion in MinHeap = " + hwy);
			mh.insert(hw2, hwy);
		}
	}

	/**
	 * Returns the Highway with minimum weight in the minheap
	 * 
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin() {
		return mh.removeMin().data;
	}

	/**
	 * Returns a string representation of the level-order traversal of the heap in
	 * the following format:
	 * 
	 * Heap[ Highway[city1=X, city2=X, cost=X.X, asphalt=X.X], Highway[city1=X,
	 * city2=X, cost=X.X, asphalt=X.X], Highway[city1=X, city2=X, cost=X.X,
	 * asphalt=X.X] ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Heap[\n");
		for (int i = 0; i < mh.getNext(); i++) {
			sb.append("   ").append(mh.get(i).data);
			if (i + 1 < mh.getNext()) {
				sb.append(",\n");
			}
		}
		sb.append("\n]");
		return sb.toString();
	}
}
