package edu.ncsu.csc316.transportation_manager.util;

/**
 * ArrayList1 with an array data structure. This customArrayList1 mostly get
 * from Typo and 316 Project 1 and slightly modified.
 * 
 * @author Chee Ng (cwng)
 * @param <E>
 *            object type of element
 *
 */
public class ArrayList1<E> {
	/** initial size for ArrayList1 */
	private final static int CAPACITY = 20;
	/** Generic array of list */
	private E[] elements;
	/** keep track of size */
	private int size;

	/**
	 * Construct a new ArrayList1
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList1() {
		elements = (E[]) new Object[CAPACITY];
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
			E[] temp = (E[]) new Object[currentSize * 2];
			for (int i = 0; i < size(); i++) {
				temp[i] = elements[i];
			}
			elements = temp;
			elements[size] = element;
			size++;
		}

	}

}
