package GUImain;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import GUImeal.MealWindow;
import GUImeal.FoodTab;

public class MainWindow extends JFrame{
	
	
	//String
	protected static String title = "Kalorikalenteri";
	
	//Dimensions
	protected static int windowWidth = 800;
	protected static int windowHeigth = 600;
	
	
	//View components------------------------------------------------------------------------------------
	
	
	
	//Menubar
	protected static JMenuBar menuBar = new JMenuBar();
	protected static JMenu menu1 = new JMenu("Tiedosto");
	protected static JMenu menu3 = new JMenu("Lis‰‰");
	protected static JMenu menu2 = new JMenu("Tietoja");
	protected static JMenuItem mi1 = new JMenuItem("Lopeta");
	protected static JMenuItem mi3 = new JMenuItem("Hallitse aterioita");
	protected static JMenuItem mi2 = new JMenuItem("Apua");

	

	protected static JPanel inner = new JPanel(new GridLayout(1,1,20,10));;
	
	//Tablayout
	protected static JPanel mealPanel = new JPanel();
	protected static JPanel foodPanel = new JPanel();
	protected static JTabbedPane tabbedPane = new JTabbedPane();
	
	
	public MainWindow() {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//Set menu
		MainWindowBuilder.buildMenu();
		this.setJMenuBar(menuBar);
		//Buildwindow
		MainWindowBuilder.buildView();
		
		this.getContentPane().add(inner);
		
		this.setVisible(true);
		setMenuListeners();
	}
	
	private void setMenuListeners(){
		
		mi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
		mi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MealWindow();
			}});
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("Ohje");
			}});
	}
	
	
	
	
	

	//Confirm dialog
	public static boolean confirm(String title, String msg) {
		Object[] options = {"Peruuta", "Kyll‰"};
		int n = JOptionPane.showOptionDialog(inner,msg,title,
		    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
		    null,options,options[1]);
				
		if(n==1) {
			return true;
		}
		return false;
	}
	
	//Show dialog message
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(inner, msg);
	}
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}
}
