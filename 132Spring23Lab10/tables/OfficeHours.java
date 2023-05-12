package tables;
/**
 * Example that illustrates how to display information using JTables.
 * Click on the "TAs Info" button to see information about TAs and on the
 * "Instructors Info" button to see instructors' information. 
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class OfficeHours extends JPanel {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private TableDisplay tableDisplay;
	private String title = "Office Hours";
	private static int FRAME_WIDTH=400, FRAME_HEIGHT=250;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(()-> {
			new OfficeHours().defineFrame();
		});
	}

	/* Information for TAs */
	private Object[] columnNamesTAs = new String[] {"TA Name", "Office Hours"};
	private Object[][] twoDimDataArrayTAs = new String[][] { 
			{ "Mary", "1-2" }, { "John", "2-3" }, { "Kathy", "4-5" }, 
			{ "Jose", "2-5" }, { "Liz", "2-3" }, { "Brenda", "4-5" },
			{ "Liping", "1-2" }, { "Eric", "2-3" }, { "Saket", "4-5" }, 
			{ "Adam", "2-5" }, { "Jonathan", "2-3" }, { "Nick", "4-5" }};
	
	/* Information for Instructors */
	private Object[] columnNamesInstructors = new String[] {"Instructor",
			"Office", "Office Hours" };
	private Object[][] twoDimDataArrayInstructors = new String[][] {
			{ "Pat", "CSS1420", "1-2" }, { "Kim", "CSI1000", "4-5" },
			{ "Robert", "CSS1330", "4-5" }, { "Laura", "CSS1311", "5-6" },
			{ "Mary", "CSS1530", "8-9" }, { "Peter", "CSS1311", "10-11" },
			{ "Larry", "CSS1330", "4-5" }, { "Jan", "CSS1311", "5-6" },
			{ "Ben", "CSS1530", "8-9" }, { "Fawzi", "CSS1311", "10-11" }};

	public OfficeHours() {
		setLayout(new BorderLayout());
		
		tableDisplay = new TableDisplay();
		add(tableDisplay, BorderLayout.NORTH);

		/* By default we display TA information */
		tableDisplay.updateTable(twoDimDataArrayTAs, columnNamesTAs);

		/* A button to display TAs information */
		JButton tasInfoButton = new JButton("TAs Info");
		/* We are defining as action the updating of the table with TA's information */
		tasInfoButton.addActionListener( (e) -> {
			tableDisplay.updateTable(twoDimDataArrayTAs, columnNamesTAs);
		});

		
		/* A button to display Instructors' information */
		JButton instructorsInfoButton = new JButton("Instructors Info");		
		/* We are defining as action the updating of the table with instructors' information */
		instructorsInfoButton.addActionListener( (e)-> {
			tableDisplay.updateTable(twoDimDataArrayInstructors, columnNamesInstructors);
		});

		/* This panel will hold the buttons */
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(tasInfoButton);
		buttonsPanel.add(instructorsInfoButton);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	private class TableDisplay extends JPanel {
		private static final long serialVersionUID = 1L;
		private JTable table;
		private DefaultTableModel tableModel;

		public TableDisplay() {
			/* Creating the table object and setting some table properties */
			/* Remember, the JTable represents the view of our data (View of MVC Model) */
			table = new JTable();
			table.setPreferredScrollableViewportSize(new Dimension(8 * FRAME_WIDTH/10, FRAME_HEIGHT/2));
			table.getTableHeader().setForeground(Color.YELLOW);
			table.getTableHeader().setBackground(Color.LIGHT_GRAY);
			table.setGridColor(Color.RED);
			table.setForeground(Color.BLUE);
			table.setSelectionBackground(Color.ORANGE);

			/* Setting the scrollPane */
			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane);
		}

		public void updateTable(Object[][] twoDimDataArray, Object[] columnNames) {

			/* Defining our table model object which holds the data */
			/* We construct a new model object each time we want to */
			/* update our table and set the table model to the new object */
			tableModel = new DefaultTableModel(twoDimDataArray, columnNames);
			table.setModel(tableModel);
		}
	}

	public void defineFrame() {
		frame = new JFrame(title);
		
		/* Sets the panel as the content pane for the frame. */
		this.setOpaque(true);
		frame.setContentPane(this);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setVisible(true);
	}
	
	
}