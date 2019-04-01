package edu.ncsu.csc316.transportation_manager.util;

/**
 * Traditional list of PriotityQueue heap extends Comparable.
 *
 * @author Chee Ng (cwng)
 *
 * @param <K>
 *            of Key
 * @param <E>
 *            of generic element
 */
public class Heap <K extends Comparable<K>, E> {
    /** Keep Track of levels **/
    private int      levels;
    /** Keep track of capacity **/
    private int      capacity;
    /** Array Based Heap **/
    private Object[] tree;
    /** Next to be insert **/
    private int      next;

    /**
     * Constructor of Heap
     */
    public Heap () {
        levels = 10;
        capacity = (int) Math.pow( 2, levels );
        // System.out.println(capacity); 1024 so big?
        tree = new Object[capacity];
        next = 0;
    }

    /**
     * Keep tack of Next/size
     *
     * @return get the size
     */
    public int getNext () {
        return next;
    }

    /**
     * Get the HeapNode of current Element
     *
     * @param idx
     *            of index
     * @return current index element
     */
    @SuppressWarnings ( "unchecked" )
    public HeapNode<K, E> get ( final int idx ) {
        return (HeapNode<K, E>) tree[idx];
    }

    /**
     * Insert will add the node to the next available. It will propagate up(
     * Sorting) the minimum value every insertion.
     *
     * @param priority
     *            of key
     * @param element
     *            of element
     */
    public void insert ( final K priority, final E element ) {
        final HeapNode<K, E> newNode = new HeapNode<K, E>( priority, element );
        tree[next] = newNode;
        bubbleUp( next );
        next += 1;

        // Grow capacity
        if ( next >= capacity ) {
            levels = levels * 2;
            // to minimize the doubling the array size each time
            capacity = (int) Math.pow( 2, levels );
            final Object[] temp = new Object[capacity];
            final int size = tree.length;
            for ( int i = 0; i < size; i++ ) {
                temp[i] = tree[i];
            }
            tree = temp;
        }
    }

    /**
     * Peek the current Minimum
     *
     * @return the current minimum in heap
     * @throws IllegalArgumentException
     *             if heap is empty
     */
    @SuppressWarnings ( "unchecked" )
    public HeapNode<K, E> peekMin () {
        if ( next == 0 ) {
            throw new IllegalArgumentException();
        }
        return (HeapNode<K, E>) tree[0];
    }

    /**
     * RemoveMin removes the highest priority elment from the heap
     *
     * @return the minimum node
     */
    @SuppressWarnings ( "unchecked" )
    public HeapNode<K, E> removeMin () {
        if ( next == 0 ) {
            return null;
        }
        final HeapNode<K, E> root = (HeapNode<K, E>) tree[0];
        if ( next == 1 ) {
            tree[0] = null;
        }
        else {
            // need to copy the array
            final Object[] newTree = new Object[tree.length - 1];
            newTree[0] = tree[next - 1]; // set last element to root
            for ( int i = 1; i < next - 1; i++ ) {
                newTree[i] = tree[i];
            }
            tree = newTree;
        }
        next = next - 1;
        bubbleDown( 0 );
        return root;

    }

    /**
     * Private helper to swap two nodes
     *
     * @param i
     *            of index
     */
    @SuppressWarnings ( "unchecked" )
    private void bubbleUp ( int i ) {
        while ( i > 0 && ( (HeapNode<K, E>) tree[ ( i - 1 ) / 2] ).compareTo( (HeapNode<K, E>) tree[i] ) > 0 ) {
            final HeapNode<K, E> temp = (HeapNode<K, E>) tree[ ( i - 1 ) / 2];
            tree[ ( i - 1 ) / 2] = tree[i]; // (i-1) /2 is parent of i
            tree[i] = temp;
            i = ( i - 1 ) / 2;
        }
    }

    /**
     * Swapped to left or right when removed if lower priority its children
     *
     * @param i
     *            of index
     */
    @SuppressWarnings ( "unchecked" )
    private void bubbleDown ( int i ) {
        // int j = (2 * i) + 1;
        while ( ( 2 * i ) + 1 < next ) {
            int j = 2 * i + 1;
            final HeapNode<K, E> self = (HeapNode<K, E>) tree[i];
            final HeapNode<K, E> leftChild = (HeapNode<K, E>) tree[j];
            final HeapNode<K, E> rightChild = (HeapNode<K, E>) tree[j + 1];
            if ( j < next - 1 && leftChild.compareTo( rightChild ) > 0 ) {
                j++;
            }

            final HeapNode<K, E> childToCompare = (HeapNode<K, E>) tree[j];
            if ( self.compareTo( childToCompare ) < 0 ) {
                break;
            }
            final HeapNode<K, E> temp = (HeapNode<K, E>) tree[j];
            tree[j] = tree[i];
            tree[i] = temp;
            i = j;

        }
    }
}
