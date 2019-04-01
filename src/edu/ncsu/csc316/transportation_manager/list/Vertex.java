package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.util.MultiPurposeList;

/**
 * Vertex maintain each vertex and also keep track of its neigbours
 *
 * @author Chee Ng (cwng)
 *
 * @param <E>
 *            generic of vertex
 */
public class Vertex <E extends Comparable<E>> implements Comparable<Vertex<E>> {
    /**
     * Data of value
     */
    public E                           value;
    /**
     * List of vertices
     */
    public MultiPurposeList<Vertex<E>> neighbors;

    /**
     * Construct a new vertex
     *
     * @param value
     *            of vertex
     */
    public Vertex ( final E value ) {
        this.value = value;
        neighbors = new MultiPurposeList<Vertex<E>>();
    }

    /**
     * Custom equals method for vertex
     *
     * @return true if same instance and equals
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public boolean equals ( final Object o ) {
        if ( o != null && o instanceof Vertex ) {
            return this.value.compareTo( ( (Vertex<E>) o ).value ) == 0;
        }
        return false;
    }

    /**
     * Compare to method
     *
     * @param o
     *            of object to be compared
     * @return the compared vertex order in integer
     */
    @Override
    public int compareTo ( final Vertex<E> o ) {

        return this.value.compareTo( o.value );
    }
}
