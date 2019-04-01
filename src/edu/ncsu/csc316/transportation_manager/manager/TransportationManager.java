package edu.ncsu.csc316.transportation_manager.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.transportation_manager.heap.MinHighwayHeap;
import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.GenericGraph;
import edu.ncsu.csc316.transportation_manager.set.UpTree;
import edu.ncsu.csc316.transportation_manager.set.UpTreeNode;
import edu.ncsu.csc316.transportation_manager.util.ArrayList1;
import edu.ncsu.csc316.transportation_manager.util.MultiPurposeList;

/**
 * TransportationManager provide user to manage and Estimates for highway
 * construction cost and amount of asphalt (in terms of miles needed to be
 * paved) between each city. It displays a minimum weight spanning tree and
 * adjacencyList of the graph.
 *
 * @author Chee Ng (cwng)
 *
 */
public class TransportationManager {
    /** Graph for the highway **/
    private GenericGraph<Integer, Highway> graph;
    /** Adjacency List Map **/
    private final AdjacencyList            adjListMap;
    /** Minimum Spanning Tree List **/
    private MultiPurposeList<Highway>      mst;
    /** Minimum Spanning Tree List for GUI **/
    private MultiPurposeList<Highway>      mstUI;
    /** Minimum Heap of cost or asphalt **/
    private MinHighwayHeap                 minHeap;
    /** Uptree structure **/
    private UpTree<Integer, Integer>       uptree;
    /** Instance of TransportationManager **/
    private static TransportationManager   instance;

    /** To do time out analysis **/
    // static Long start = System.currentTimeMillis();

    private TransportationManager () {
        graph = new GenericGraph<Integer, Highway>();
        adjListMap = new AdjacencyList( graph.vertices.size() );
    }

    /**
     * Check to see if the singleton field has been created, if not, it should
     * create a new instance of TransportationManager
     *
     * @return the instance of TransportationManager
     */
    public static TransportationManager getInstance () {
        if ( instance == null ) {
            instance = new TransportationManager();
        }
        return instance;
    }

    /**
     * Constructs a new TransportationManager
     *
     * @param pathToFile
     *            the path to the file that contains the set of highways in the
     *            graph
     */
    public TransportationManager ( final String pathToFile ) {
        loadHighWayFromFile( pathToFile ); // load the file
        adjListMap = new AdjacencyList( graph.vertices.size() ); // initialize
    }

    /**
     * Custom load method for GUI
     *
     * @param filename
     *            of highway text file
     */
    public void loadHighWayFromFile ( final String filename ) {
        try {
            graph = HighwayReader.readHighwayFile( filename );
        }
        catch ( final FileNotFoundException e ) {
            throw new IllegalArgumentException( "Highway file cannot load or found" );
            // e.printStackTrace();
        }
    }

    /**
     * Returns a string representation of the AdjacencyList in the following
     * format, where (for each city) the Highways are in sorted order by city1,
     * then city2, then cost, then asphalt:
     *
     *
     * @return the string representation of the AdjacencyLists
     */
    public String getAdjacencyList () {

        // sort the graph first
        graph.edges.mergeSort( 0, graph.edges.size() - 1 );

        // Add all edges into adjacency list
        for ( int x = 0; x < graph.edges.size(); x++ ) {
            adjListMap.addEdges( graph.edges.get( x ).weight );
        }
        // Print exact the require format
        final StringBuilder sb = new StringBuilder();
        sb.append( "AdjacencyList[\n" );
        for ( int i = 0; i < graph.vertices.size(); i++ ) {
            sb.append( "   " ).append( "City " ).append( i ).append( ": -> " );
            for ( int j = 0; j < adjListMap.outEdges( i ).size(); j++ ) {
                sb.append( adjListMap.outEdges( i ).get( j ) );
                if ( j + 1 == adjListMap.outEdges( i ).size() ) {
                    sb.append( "\n" );
                }
                else {
                    sb.append( " -> " );
                }
            }
        }
        sb.append( "]" );
        return sb.toString();
    }

    /**
     * Returns a string representation of the list of Highways contained in the
     * minimum spanning set of Highways. The returned string is in the following
     * format, where the Highways are in sorted order by city1, city2, then
     * cost, then asphalt:
     *
     * List[ Highway[city1=X, city2=X, cost=X.X, asphalt=X.X], Highway[city1=X,
     * city2=X, cost=X.X, asphalt=X.X], Highway[city1=X, city2=X, cost=X.X,
     * asphalt=X.X] ]
     *
     * @param type
     *            the type ("COST" or "ASPHALT") of field to minimize
     * @return a string representation of the minimum spanning set of Highways
     */
    public String getMinimumHighways ( final String type ) {
        // Up tree
        uptree = new UpTree<Integer, Integer>();
        // Type of cost of asphalt
        minHeap = new MinHighwayHeap( type );
        // List for added edge
        mst = new MultiPurposeList<Highway>();
        // List for uptreeNode
        final ArrayList1<UpTreeNode<Integer, Integer>> ut = new ArrayList1<>();
        // Inserting the priority type in heap
        for ( int i = 0; i < graph.edges.size(); i++ ) {
            minHeap.insert( graph.edges.get( i ).weight );

        }

        // Disjoint set of Up tree
        // Make set
        uptree = new UpTree<>();
        for ( int i = 0; i < graph.vertices.size(); i++ ) {
            final UpTreeNode<Integer, Integer> utn = new UpTreeNode<Integer, Integer>( i, i );
            ut.add( utn );

        }
        // Size of vertices
        int v = graph.vertices.size();
        final int bp = v - 1; // for in case
        while ( v > 1 ) {
            final Highway temp = minHeap.deleteMin();

            final int idx1 = temp.getCity1(); // index of first city
            final int idx2 = temp.getCity2(); // index of second city

            if ( ! ( uptree.find( ut.get( idx1 ) ).key.equals( uptree.find( ut.get( idx2 ) ).key ) ) ) {
                uptree.union( uptree.find( ut.get( idx1 ) ), uptree.find( ut.get( idx2 ) ) );

                v--;
                mst.add( temp );
            }

            // In case but not necessary
            if ( mst.size() == bp ) {
                break;
            }

        }
        // Sort it so it print in order
        mst.mergeSort( 0, mst.size() - 1 );
        final StringBuilder sb = new StringBuilder();
        mstUI = new MultiPurposeList<>(); // For UI
        sb.append( "List[\n" );
        for ( int i = 0; i < mst.size(); i++ ) {
            mstUI.add( mst.get( i ) );
            sb.append( "   " ).append( mst.get( i ).toString() );
            if ( i + 1 < mst.size() ) {
                sb.append( ",\n" );
            }
        }
        sb.append( "\n]" );
        // System.out.println("The current list:\n" + sb.toString());
        return sb.toString();
    }

    /**
     * getGraph of Highway as array For GUI
     *
     * @return Graph as String Object Dimensional array
     */
    public String[] getGraphAsArray () {
        final String[] graphs = new String[graph.edges.size()];
        for ( int i = 0; i < graph.edges.size(); i++ ) {
            graphs[i] = graph.edges.get( i ).weight.toString();
        }
        return graphs;
    }

    /**
     * Get Minimum Spanning Tree of Highway as array For GUI
     *
     * @param type
     *            of cost or asphalt
     * @return Minimum Spanning Tree as String Object Dimensional array
     */
    public String[] getMSTAsArray ( final String type ) {
        getMinimumHighways( type );
        final String[] getMSTAsArray = new String[mstUI.size() + 2];
        getMSTAsArray[0] = "List[";
        for ( int i = 1; i <= mstUI.size(); i++ ) {
            getMSTAsArray[i] = "   " + mstUI.get( i - 1 ).toString();
        }
        getMSTAsArray[mstUI.size() + 1] = "]";
        return getMSTAsArray;
    }

}
