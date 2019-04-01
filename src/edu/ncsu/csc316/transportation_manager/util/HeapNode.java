package edu.ncsu.csc316.transportation_manager.util;

/**
 * Comparable HeapNode lets us compare element in the heap and K extends
 * Comparable K, E lets us use the K data type to compare the elements
 *
 * @author Chee Ng (cwng)
 *
 * @param <K>
 *            of priority to be compared
 * @param <E>
 *            of generic type
 */
public class HeapNode <K extends Comparable<K>, E> implements Comparable<HeapNode<K, E>> {
    /** K as key of priority **/
    public K priority;
    /** data of element **/
    public E data;

    /**
     * Constructor of HeapNode
     *
     * @param priority
     *            of Key
     * @param data
     *            of element
     */
    public HeapNode ( final K priority, final E data ) {
        this.data = data;
        this.priority = priority;
    }

    /**
     * Custom compareTo
     *
     * @param o
     *            of object to be compared
     * @return the order of compared
     */
    @Override
    public int compareTo ( final HeapNode<K, E> o ) {
        return this.priority.compareTo( o.priority );

    }

}
