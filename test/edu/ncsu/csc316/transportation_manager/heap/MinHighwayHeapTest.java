package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

/**
 * Test for MinHighwayHeap class
 *
 * @author Chee Ng (cwng)
 *
 */
public class MinHighwayHeapTest {
    /**
     * Test Insertion of Cost as minimum Heap
     */
    @Test
    public void testInsertCost () {
        final MinHighwayHeap mh = new MinHighwayHeap( "COST" );
        final Highway h1 = new Highway( 2, 0, 7.0, 77.0 );
        final Highway h2 = new Highway( 3, 2, 12.0, 122.0 );
        final Highway h3 = new Highway( 0, 3, 14.0, 144.0 );
        final Highway h4 = new Highway( 1, 0, 5.0, 101.0 );
        final Highway h5 = new Highway( 3, 1, 10.0, 66.0 );
        final Highway h6 = new Highway( 1, 2, 6.0, 55.0 );

        mh.insert( h1 );
        mh.insert( h2 );
        mh.insert( h3 );
        mh.insert( h4 );
        mh.insert( h5 );
        mh.insert( h6 );

        assertEquals( "Heap[\n" + "   Highway[city1=1, city2=0, cost=5.0, asphalt=101.0],\n"
                + "   Highway[city1=2, city2=0, cost=7.0, asphalt=77.0],\n"
                + "   Highway[city1=1, city2=2, cost=6.0, asphalt=55.0],\n"
                + "   Highway[city1=3, city2=2, cost=12.0, asphalt=122.0],\n"
                + "   Highway[city1=3, city2=1, cost=10.0, asphalt=66.0],\n"
                + "   Highway[city1=0, city2=3, cost=14.0, asphalt=144.0]\n" + "]", mh.toString() );

        assertEquals( h4, mh.deleteMin() );
        assertEquals( h6, mh.deleteMin() );
        assertEquals( h1, mh.deleteMin() );
        assertEquals( h5, mh.deleteMin() );
        assertEquals( h2, mh.deleteMin() );
        assertEquals( h3, mh.deleteMin() );

    }

    /**
     * Test Insertion of ASPHALT as minimum Heap
     */
    @Test
    public void testInsertAshpalt () {
        final MinHighwayHeap mh = new MinHighwayHeap( "ASPHALT" );
        final Highway h1 = new Highway( 2, 0, 7.0, 77.0 );
        final Highway h2 = new Highway( 3, 2, 12.0, 122.0 );
        final Highway h3 = new Highway( 0, 3, 14.0, 144.0 );
        final Highway h4 = new Highway( 1, 0, 5.0, 101.0 );
        final Highway h5 = new Highway( 3, 1, 10.0, 66.0 );
        final Highway h6 = new Highway( 1, 2, 6.0, 55.0 );

        mh.insert( h1 );
        mh.insert( h2 );
        mh.insert( h3 );
        mh.insert( h4 );
        mh.insert( h5 );
        mh.insert( h6 );
        assertEquals( "Heap[\n" + "   Highway[city1=1, city2=2, cost=6.0, asphalt=55.0],\n"
                + "   Highway[city1=2, city2=0, cost=7.0, asphalt=77.0],\n"
                + "   Highway[city1=3, city2=1, cost=10.0, asphalt=66.0],\n"
                + "   Highway[city1=3, city2=2, cost=12.0, asphalt=122.0],\n"
                + "   Highway[city1=1, city2=0, cost=5.0, asphalt=101.0],\n"
                + "   Highway[city1=0, city2=3, cost=14.0, asphalt=144.0]\n" + "]", mh.toString() );
        assertEquals( h6, mh.deleteMin() );
        assertEquals( h5, mh.deleteMin() );
        assertEquals( h1, mh.deleteMin() );
        assertEquals( h4, mh.deleteMin() );
        assertEquals( h2, mh.deleteMin() );
        assertEquals( h3, mh.deleteMin() );

    }

    /**
     * Test for Teaching staff
     */
    @Test
    public void fixTS () {
        final Highway h1 = new Highway( 0, 1, 2.0, 90.0 );
        final Highway h2 = new Highway( 0, 1, 3.0, 80.0 );
        final Highway h3 = new Highway( 0, 1, 4.0, 70.0 );
        final Highway h4 = new Highway( 0, 1, 5.0, 60.0 );
        final Highway h5 = new Highway( 0, 1, 8.0, 30.0 );
        final Highway h6 = new Highway( 0, 1, 7.0, 40.0 );
        final Highway h7 = new Highway( 0, 1, 9.0, 20.0 );
        final Highway h8 = new Highway( 0, 1, 6.0, 50.0 );
        final Highway h9 = new Highway( 0, 1, 10.0, 10.0 );

        final MinHighwayHeap mh = new MinHighwayHeap( "ASPHALT" );
        mh.insert( h1 );
        mh.insert( h2 );
        mh.insert( h3 );
        mh.insert( h4 );
        mh.insert( h5 );
        mh.insert( h6 );
        mh.insert( h7 );
        mh.insert( h8 );
        mh.insert( h9 );

        // System.out.println(mh.toString());

        assertEquals( h9, mh.deleteMin() );
        assertEquals( h7, mh.deleteMin() );
        assertEquals( h5, mh.deleteMin() );
        assertEquals( h6, mh.deleteMin() );
        assertEquals( h8, mh.deleteMin() );
        assertEquals( h4, mh.deleteMin() );
        assertEquals( h3, mh.deleteMin() );
        assertEquals( h2, mh.deleteMin() );
        assertEquals( h1, mh.deleteMin() );

        final MinHighwayHeap mh2 = new MinHighwayHeap( "COST" );

        mh2.insert( h1 );
        mh2.insert( h2 );
        mh2.insert( h3 );
        mh2.insert( h4 );
        mh2.insert( h5 );
        mh2.insert( h6 );
        mh2.insert( h7 );
        mh2.insert( h8 );
        mh2.insert( h9 );

        // System.out.println(mh2.toString());

        assertEquals( h1, mh2.deleteMin() );
        assertEquals( h2, mh2.deleteMin() );
        assertEquals( h3, mh2.deleteMin() );
        assertEquals( h4, mh2.deleteMin() );
        assertEquals( h8, mh2.deleteMin() );
        assertEquals( h6, mh2.deleteMin() );
        assertEquals( h5, mh2.deleteMin() );
        assertEquals( h7, mh2.deleteMin() );
        assertEquals( h9, mh2.deleteMin() );

    }
}
