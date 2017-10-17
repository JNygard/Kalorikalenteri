package GUImain;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainWindowBuilder {


	//Build tabs
	public static void buildTabs() {
		MainWindow.inner = new JPanel(new GridLayout(1,1,20,10));
		
	
		
		MainWindow.tabbedPane.add("asd", MainWindow.mealPanel);
		MainWindow.tabbedPane.add("asddd", MainWindow.foodPanel);
		MainWindow.inner.add(MainWindow.tabbedPane);
	}
	
}
