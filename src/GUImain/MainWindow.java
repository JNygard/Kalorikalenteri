package GUImain;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame{
	
	//String
	protected static String title = "P‰‰ikkuna";
	
	//Dimensions
	

	protected static JPanel inner = new JPanel(new GridLayout(1,1,20,10));;
	
	//Tablayout
	protected static JPanel mealPanel = new JPanel();
	protected static JPanel foodPanel = new JPanel();
	protected static JTabbedPane tabbedPane = new JTabbedPane();
	
	
	public MainWindow() {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindowBuilder.buildTabs();
		this.getContentPane().add(inner);
		setSize(500,500);
		this.setVisible(true);
	}

}
