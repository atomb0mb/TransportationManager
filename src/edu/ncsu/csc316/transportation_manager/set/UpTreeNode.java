package edu.ncsu.csc316.transportation_manager.set;

/**
 * UpTreeNode will contain each node to be union. It also keep tracks of current
 * Uptree Node count.
 *
 * @author Chee Ng (cwng)
 *
 * @param <K>
 *            of Key
 * @param <E>
 *            of element
 */
public class UpTreeNode <K, E> {
    /** Key to be look **/
    public K                key;
    /** Element of data **/
    public E                data;
    /** Keep track of total of nodes connected or size of tree **/
    public int              count;
    /** Uptree node **/
    public UpTreeNode<K, E> parent;

    /**
     * Constructor of UpTreeNode
     *
     * @param key
     *            of Key to be compared
     * @param data
     *            of element
     */
    public UpTreeNode ( final K key, final E data ) {
        this.key = key;
        this.data = data;
        this.count = 1;
    }
}
