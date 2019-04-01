package edu.ncsu.csc316.transportation_manager.list;

/**
 * WeightedEdge contains vertices and the weight of the data.
 *
 * @author Chee Ng (cwng)
 *
 * @param <V>
 *            of vertices to be compared
 * @param <E>
 *            of weight to be compared
 */
public class WeightedEdge <V extends Comparable<V>, E extends Comparable<E>> implements Comparable<WeightedEdge<V, E>> {
    /**
     * data of weight
     */
    public E         weight;
    /**
     * Vertex one
     */
    public Vertex<V> v1;
    /**
     * Vertex two
     */
    public Vertex<V> v2;

    /**
     * Constructor of weightedEdge
     *
     * @param v1
     *            of vertex one
     * @param v2
     *            of vertex two
     * @param weight
     *            of data
     */
    public WeightedEdge ( final Vertex<V> v1, final Vertex<V> v2, final E weight ) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Constructor of WeightedEdge
     *
     * @param v1
     *            of vertex one
     * @param v2
     *            of vertex two
     * @param weight
     *            of data
     */
    public WeightedEdge ( final V v1, final V v2, final E weight ) {
        this.weight = weight;
        this.v1 = new Vertex<V>( v1 );
        this.v2 = new Vertex<V>( v2 );
    }

    /**
     * Custom compare to method
     *
     * @param o
     *            of object to be compared
     * @return compared weight
     */
    @Override
    public int compareTo ( final WeightedEdge<V, E> o ) {
        return this.weight.compareTo( o.weight );
    }

}
