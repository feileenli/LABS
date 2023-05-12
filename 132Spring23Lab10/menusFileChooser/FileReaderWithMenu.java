package menusFileChooser;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;

public class FileReaderWithMenu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static int FRAME_WIDTH=350, FRAME_HEIGHT=300;
	private JFrame frame;
	private JMenuItem openFile, exitOption;
	private JTextArea display;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater( () -> {
			new FileReaderWithMenu();
		});
	}
	
	public FileReaderWithMenu() {
		frame = new JFrame("TextFileReader");
		this.setOpaque(true);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		/* Defining a menu bar for the frame */
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
	
		/* Setting the File Menu */
		openFile = new JMenuItem("Open");
		exitOption = new JMenuItem("Exit");
		JMenu fileMenu = new JMenu("File Options");
		fileMenu.add(openFile);
		fileMenu.addSeparator(); // separator here
		fileMenu.add(exitOption);
		menubar.add(fileMenu);
		
		/* Defining the functionality */
		openFile.addActionListener(this);
		exitOption.addActionListener(this);
		
		/* Defining a scroll bar text area */
		display = new JTextArea();
		JScrollPane scrollPane=new JScrollPane(display);
		scrollPane.setPreferredSize(new Dimension(8 * FRAME_WIDTH/10, 6 * FRAME_HEIGHT/10));
		add(scrollPane);
		
		frame.setVisible(true);
	}

	/* Handles several actions */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == openFile) {
			/* Defining and opening the file chooser */
			JFileChooser chooser = new JFileChooser();
			int status = chooser.showOpenDialog(FileReaderWithMenu.this);
			if (status == JFileChooser.APPROVE_OPTION) {
				String filename = chooser.getSelectedFile().getPath();
				display.setText(fileContents(filename));
			} else {
				JOptionPane.showMessageDialog(FileReaderWithMenu.this, "File opening cancelled.");
			}	
		} else if (event.getSource() == exitOption) {
			System.exit(0);
		} else {
			System.out.println("No action");
		}
	}

	private String fileContents(String filename) {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filename));
			String line = bufferedReader.readLine();
			boolean firstTime = true;
			while (line != null) {
				if (!firstTime) {
					stringBuffer.append("\n");
				}
				stringBuffer.append(line);
				firstTime = false;
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringBuffer.toString();
	}
	
	
}