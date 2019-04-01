package edu.ncsu.csc316.transportation_manager.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc316.transportation_manager.manager.TransportationManager;

/**
 * TransportationManagerUI that represent as view and controller of the
 * TransportationManager. Some codes from packScheduler and CSC316 Project 1 And
 * 2.
 *
 * @author Chee Ng (cwng)
 *
 */
public class TransportationManagerUI extends JFrame implements ActionListener {

    /** ID number used for object serialization. */
    private static final long          serialVersionUID          = 1L;
    /** Title for top of GUI. */
    private static final String        APP_TITLE                 = "TransportationManager";
    /** Text for the File menu item */
    private static final String        FILE_MENU_TITLE           = "File";
    /** Text for the Load Highway text file menu item. */
    private static final String        LOAD_PRE_TITLE            = "LoadHighWay";
    /** Text for the Quit menu item. */
    private static final String        QUIT_TITLE                = "Quit";
    /** Menu bar for the GUI that contains Menus. */
    private JMenuBar                   menuBar;
    /** Menu for the GUI. */
    private JMenu                      menu;
    /** Menu item for loading a file containing highway information. */
    private JMenuItem                  itemLoadHighway;
    /** Menu item for quitting the program. */
    private JMenuItem                  itemQuit;
    /** Panel that will contain different views for the application. */
    private JPanel                     panel;
    /** Reference to {@link CardLayout} for panel. Stacks all of the panels. */
    private CardLayout                 cardLayout;
    /** Constant to identify SecurityListPanel for {@link CardLayout}. */
    private static final String        TRANSPORTATION_LIST_PANEL = "TransportationListPanel";
    /** Panel of Transportation manager **/
    private TransportationListPanelUI  pnlTransportationList;
    /** Table content of Highway **/
    private TransportationTableModelUI transportationListTable;
    /** Instance of TransportationManager **/
    private TransportationManager      tm;

    /**
     * Starts the application
     *
     * @param args
     *            of command line args
     */
    public static void main ( final String[] args ) {
        new TransportationManagerUI();
    }

    /**
     * Constructs the GUI.
     */
    public TransportationManagerUI () {

        tm = TransportationManager.getInstance();
        setSize( 840, 700 );
        setLocation( 50, 50 );
        setTitle( APP_TITLE );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setUpMenuBar();

        initializeGUI();

        // Set the GUI visible
        setVisible( true );
    }

    /**
     * Method that initializes the GUI
     */
    private void initializeGUI () {

        panel = new JPanel();
        cardLayout = new CardLayout();
        panel.setLayout( cardLayout );

        pnlTransportationList = new TransportationListPanelUI();
        // add
        panel.add( pnlTransportationList, TRANSPORTATION_LIST_PANEL );
        transportationListTable.updateGraphData();
        cardLayout.show( panel, TRANSPORTATION_LIST_PANEL );
        // Add panel to the container
        final Container c = getContentPane();
        c.add( panel, BorderLayout.CENTER );

    }

    /**
     * Makes the GUI Menu bar that contains options for loading a file
     * containing issues or for quitting the application.
     */
    private void setUpMenuBar () {
        // Construct Menu items
        menuBar = new JMenuBar();
        menu = new JMenu( FILE_MENU_TITLE );
        itemLoadHighway = new JMenuItem( LOAD_PRE_TITLE );
        itemQuit = new JMenuItem( QUIT_TITLE );
        itemLoadHighway.addActionListener( this );
        itemQuit.addActionListener( this );

        // Build Menu and add to GUI
        menu.add( itemLoadHighway );
        menu.add( itemQuit );
        menuBar.add( menu );
        this.setJMenuBar( menuBar );
    }

    @Override
    public void actionPerformed ( final ActionEvent e ) {
        if ( e.getSource() == itemLoadHighway ) {
            doLoadHighWayFile();
        }
        else if ( e.getSource() == itemQuit ) {
            System.exit( 0 );
        }

    }

    /**
     * Returns a file name generated through interactions with a
     * {@link JFileChooser} object.
     *
     * @param chooserType
     *            true if open, false if save
     * @return the file name selected through {@link JFileChooser}
     */
    private String getFileName ( final boolean chooserType ) {
        final JFileChooser fc = new JFileChooser( "./" ); // Open JFileChoose to
        // current working directory
        fc.setApproveButtonText( "Open" );
        int returnVal = Integer.MIN_VALUE;
        if ( chooserType ) {
            fc.setDialogTitle( "Load" );
            returnVal = fc.showOpenDialog( this );
        }
        if ( returnVal != JFileChooser.APPROVE_OPTION ) {
            // Error or user canceled, either way no file name.
            throw new IllegalStateException();
        }
        final File catalogFile = fc.getSelectedFile();
        return catalogFile.getAbsolutePath();
    }

    /**
     * Private loadFile method provided by Dr Heckman
     */
    private void doLoadHighWayFile () {
        String filename = null;
        try {
            filename = getFileName( true );
        }
        catch ( final IllegalStateException i ) {
            JOptionPane.showMessageDialog( this, "Error loading from file. No file loaded.", "File not Loaded",
                    JOptionPane.ERROR_MESSAGE );
            return;
        }
        try {
            tm.loadHighWayFromFile( filename );
            transportationListTable.updateGraphData();
            transportationListTable.fireTableDataChanged();

        }
        catch ( final IllegalArgumentException iae ) {
            JOptionPane.showMessageDialog( this, iae.getMessage() );
        }
    }

    /**
     * TransportationListPanelUI display the button for user to manage list
     *
     * @author Chee Ng (cwng)
     *
     */
    private class TransportationListPanelUI extends JPanel implements ActionListener {

        /** ID number used for object serialization. */
        private static final long serialVersionUID = 1L;
        /** Button for generate Minimum cost */
        private final JButton     btnMinCost;
        /** Button for generate Minimum Asphalt */
        private final JButton     btnMinAsphalt;
        /** Table for highway **/
        private final JTable      roadTable;

        /**
         * SecurityTreeList contains left and right panel which is AttackTree
         * and LogEntry
         */
        public TransportationListPanelUI () {
            super( new BorderLayout() );

            setLayout( new BorderLayout() );
            // Panel for left
            final JPanel roadInfoPanel = new JPanel();
            roadInfoPanel.setLayout( new BorderLayout() );
            // Border code
            final Border lowerEtched = BorderFactory.createEtchedBorder( EtchedBorder.LOWERED );
            final TitledBorder border = BorderFactory.createTitledBorder( lowerEtched, "Roads Project Information" );
            roadInfoPanel.setBorder( border );
            roadInfoPanel.setToolTipText( "Highway" );

            // Adding the road project info to the main panel
            add( roadInfoPanel, BorderLayout.WEST );

            // road button panel
            final JPanel roadButtonPanel = new JPanel();
            roadButtonPanel.setLayout( new GridLayout( 3, 1 ) );

            btnMinCost = new JButton( "Minimum Cost" );
            btnMinCost.addActionListener( this );

            btnMinAsphalt = new JButton( "Minimum Asphalt" );
            btnMinAsphalt.addActionListener( this );

            roadButtonPanel.add( btnMinCost );
            roadInfoPanel.add( roadButtonPanel, BorderLayout.SOUTH );
            roadButtonPanel.add( btnMinAsphalt );
            roadInfoPanel.add( roadButtonPanel, BorderLayout.SOUTH );

            // Road Table
            final JPanel realRoadListPanel = new JPanel();
            transportationListTable = new TransportationTableModelUI();
            roadTable = new JTable( transportationListTable );

            roadTable.setPreferredScrollableViewportSize( new Dimension( 800, 700 ) );
            final JScrollPane listScroll = new JScrollPane( roadTable );
            realRoadListPanel.add( listScroll );
            roadInfoPanel.add( realRoadListPanel, BorderLayout.CENTER );

            // Final
            roadInfoPanel.add( roadButtonPanel, BorderLayout.SOUTH );
        }

        @Override
        public void actionPerformed ( final ActionEvent e ) {
            if ( e.getSource() == btnMinCost ) {
                transportationListTable.updateMinCostData();
            }
            else if ( e.getSource() == btnMinAsphalt ) {
                transportationListTable.updateMinAsphaltData();
            }

        }

    }

    /**
     * TransportationTableModelUI display the list of highways
     *
     * @author Chee Ng (cwng)
     *
     */
    private class TransportationTableModelUI extends AbstractTableModel {
        /** ID number used for object serialization. */
        private static final long serialVersionUID = 1L;
        /** Column names for the table */
        private final String[]    columnNames      = { "Set of Highways Overview" };
        /** Data stored in the table */
        private Object[]          data;

        /**
         * Constructor for the Product Table model
         */
        public TransportationTableModelUI () {
            updateGraphData();
        }

        /**
         * GetColumn length method
         *
         * @return column length
         */
        @Override
        public int getColumnCount () {
            return columnNames.length;
        }

        /**
         * Returns the column name at the given index.
         *
         * @return the column name at the given column.
         */
        @Override
        public String getColumnName ( final int col ) {
            return columnNames[col];
        }

        /**
         * GetRow data length method
         *
         * @return row count
         */
        @Override
        public int getRowCount () {
            if ( data == null ) {
                return 0;
            }
            return data.length;
        }

        /**
         * Get value at
         *
         * @return value of data
         * @param row
         *            of row
         * @param col
         *            of column
         */
        @Override
        public Object getValueAt ( final int row, final int col ) {
            if ( data == null ) {
                return null;
            }
            return data[row];
        }

        /**
         * Sets the given value to the given {row, col} location.
         *
         * @param value
         *            Object to modify in the data.
         * @param row
         *            location to modify the data.
         * @param column
         *            location to modify the data.
         */
        @Override
        public void setValueAt ( final Object value, final int row, final int col ) {
            data[row] = value;
            fireTableCellUpdated( row, col );
        }

        /**
         * Update GraphData
         */
        public void updateGraphData () {
            tm = TransportationManager.getInstance();
            data = tm.getGraphAsArray();
            TransportationManagerUI.this.repaint();
            TransportationManagerUI.this.validate();
        }

        /**
         * Update Minimum cost Data
         */
        public void updateMinCostData () {
            tm = TransportationManager.getInstance();
            data = tm.getMSTAsArray( "COST" );
            TransportationManagerUI.this.repaint();
            TransportationManagerUI.this.validate();
        }

        /**
         * Update Minimum Asphalt data
         */
        public void updateMinAsphaltData () {
            tm = TransportationManager.getInstance();
            data = tm.getMSTAsArray( "ASPHALT" );
            TransportationManagerUI.this.repaint();
            TransportationManagerUI.this.validate();
        }

    }
}
