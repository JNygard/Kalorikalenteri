package GUImain;

import java.awt.GridLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class MainWindowBuilder {


	//Build tabs
	protected static void buildView() {
		MainWindow.inner = new JPanel(new GridLayout(1,1,20,10));
		
		
		
	}
	
	
	//Build menu
	protected static void buildMenu() {
		MainWindow.menuBar.add(MainWindow.menu1);
		MainWindow.menuBar.add(MainWindow.menu3);
		MainWindow.menuBar.add(MainWindow.menu2);
		MainWindow.menu1.add(MainWindow.mi1);
		MainWindow.menu3.add(MainWindow.mi3);
		MainWindow.menu2.add(MainWindow.mi2);
	}
	
}
