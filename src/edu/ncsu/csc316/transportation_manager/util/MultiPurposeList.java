package edu.ncsu.csc316.transportation_manager.util;

/**
 * Code from project2. MultiPurposeList with an array data structure. This
 * customArrayList mostly get from Typo and 316 Project 1 and slightly modified.
 * 
 * @author Chee Ng (cwng)
 * @param <E>
 *            object type of element
 *
 */
public class MultiPurposeList<E extends Comparable<E>> {
	/** initial size for MultiPurposeList */
	private final static int CAPACITY = 20;
	/** Generic array of list */
	private E[] elements;
	/** keep track of size */
	private int size;

	/**
	 * Construct a new arrayList
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MultiPurposeList() {
		elements = (E[]) new Comparable[CAPACITY];
		size = 0;
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 *
	 * @param index
	 *            the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range.
	 */
	public E remove(int index) {
		// Code from Project 3
		E removed;
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		// Last element of list or list contain only 1 element
		if (index == size - 1) {
			removed = elements[size - 1];
			elements[size - 1] = null;
			size--;
			return (E) removed;
		} else {
			// remove mid or first element
			removed = elements[index];
			for (int i = index; i < size; i++) {
				elements[i] = elements[i + 1];
			}
			elements[size - 1] = null;
			size--;
			return (E) removed;
		}
	}

	/**
	 * Custom clear method
	 */
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}

	/**
	 * Object set method
	 *
	 * @param index
	 *            of index
	 * @param element
	 *            of object
	 * @return element that is set to desire index
	 * @throws NullPointerException
	 *             if element is null.
	 */
	public E set(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E e = elements[index];
		elements[index] = element;
		return (E) e;
	}

	/**
	 * Adds the specified element to list unordered
	 *
	 * @param element
	 *            element to be appended to this list
	 * @throws NullPointerException
	 *             if e is null
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}

		if (size < elements.length) {
			elements[size] = element;
			size++;
		} else {
			// grow array
			int currentSize = elements.length;
			@SuppressWarnings("unchecked")
			E[] temp = (E[]) new Comparable[currentSize * 2];
			for (int i = 0; i < size(); i++) {
				temp[i] = elements[i];
			}
			elements = temp;
			elements[size] = element;
			size++;
		}

	}

	//

	/**
	 * Do sorting with MergeSort. It will need a helper to complete the full task
	 * recursively.
	 * 
	 * @param low
	 *            of index
	 * @param high
	 *            of index
	 */
	public void mergeSort(int low, int high) {
		// MergeSort Pseudocode from lecture slide C07 - Recursion and Recursive
		// Analysis
		if (low < high) {
			int mid = low + (high - low) / 2;

			mergeSort(low, mid); // Sorts the left side

			mergeSort(mid + 1, high); // sorts the right side

			// Merge both sides
			recursiveMerge(low, mid, high);

		}
	}

	/**
	 * This method merges level by level going up the merge-sort tree. Given an
	 * input array of elements, it begins by merging every successive pair of
	 * elements into sorted runs of length two.
	 * 
	 * @param low
	 *            of lowest index
	 * @param mid
	 *            of middle index
	 * @param high
	 *            of highest index
	 */
	private void recursiveMerge(int low, int mid, int high) {
		int currentSize = elements.length;
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Comparable[currentSize];
		for (int i = low; i <= high; i++) {
			temp[i] = elements[i];
		}
		// Modified some source codes from from textbook page 543
		int i = low; // index into run 1
		int j = mid + 1; // index into run 2
		int k = low; // index into output
		// Modified some source codes from from textbook page 543
		while (i <= mid && j <= high) {
			if (temp[i].compareTo(temp[j]) > 0) {
				elements[k++] = temp[j++]; // take next from run 2
			} else {
				elements[k++] = temp[i++]; // take next from run 1
			}
		}
		for (int z = i; z <= mid; z++) {
			elements[k++] = temp[z];
		}
	}

	/**
	 * This method find the list if contains the element
	 * 
	 * @param element
	 *            of data
	 * @return true if contain the element else false
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This function finds the index of searched element
	 * 
	 * @param e
	 *            of element
	 * @return index of that element or -1 if does not exist
	 */
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(get(i))) {
				return i;
			}
		}
		return -1;
	}

}
