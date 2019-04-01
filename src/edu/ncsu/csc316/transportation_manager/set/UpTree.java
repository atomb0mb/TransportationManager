package edu.ncsu.csc316.transportation_manager.set;

/**
 * Uptree class creates a vertex of uptree node then union as see determine
 * whose the parent based on count or size of tree
 *
 * @author Chee Ng (cwng)
 *
 * @param <K>
 *            is the Uptree Node
 * @param <E>
 *            is the Uptree Node
 */
public class UpTree <K, E> {
    /**
     * Find the parent node through traverse
     *
     * @param node
     *            of parent
     * @return the parent node
     */
    public UpTreeNode<K, E> find ( UpTreeNode<K, E> node ) {
        while ( node.parent != null ) {
            node = node.parent;
        }
        return node;
    }

    /**
     * Given two nodes, merge them together. Since these nodes only care about
     * their parents, the only change needed is to update a former root node to
     * have a parent
     *
     * @param n1
     *            of set of node
     * @param n2
     *            of set of node
     */
    public void union ( final UpTreeNode<K, E> n1, final UpTreeNode<K, E> n2 ) {
        if ( n1.count >= n2.count ) {
            n1.count += n2.count;
            // n2.count = n1.count;
            n2.parent = n1;
        }
        else {
            n2.count += n1.count;
            // n2.count = n1.count;
            n1.parent = n2;
        }
    }
}
