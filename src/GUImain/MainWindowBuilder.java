package GUImain;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import GUImeal.MealWindow;



public class MainWindowBuilder {


	//Build tabs
	protected static void buildView() {
		
		buildWeekPanel();
		buildDataPanel();
		
		
		
	}
	

	
	//Build week view panel
	protected static void buildWeekPanel() {
		
		//Week table
		JScrollPane jsc = new JScrollPane(MainWindow.TBweekTable);
		MainWindow.TBweekTable.setRowHeight(30);
		MainWindow.TBweekTable.setPreferredScrollableViewportSize(new Dimension(700,450));
		
		
		
		MainWindow.weekPanel.add(jsc);

		
		MainWindow.inner.add(MainWindow.weekPanel);
	}
	
	
	
	
	//Build data panel
	protected static void buildDataPanel() {
		
		buildDataWeekPanel() ;
		buildDataMealPanel() ;
		MainWindow.inner.add(MainWindow.dataPanel);
	}
	
	
	
	
	
	
	//Build dataWeekPanel
	protected static void buildDataWeekPanel() {

		
		//Set WEEK list
		Box wListBox = Box.createVerticalBox();
		MainWindow.weekList.setListData(MainWindow.testList);
		MainWindow.weekList.setVisibleRowCount(5);
		MainWindow.weekList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wListBox.add(new JScrollPane(MainWindow.weekList));
		MainWindow.dataWeekPanel.add(wListBox);//Add to /////
		

		
		//TA
		MainWindow.TAweek.setEditable(false);
		MainWindow.TAweek.setLineWrap(true);
		MainWindow.TAweek.setText("AFDFSDFSDFSD j jidgfsi js jgs oisg ksfgk sgjdkgjs sadg gsd f sdf s df sdf ");
		MainWindow.dataWeekPanel.add(new JScrollPane(MainWindow.TAweek));

		//BTN
		JPanel wButtonPanel = new JPanel(new GridLayout(1,3));
		wButtonPanel.add(MainWindow.BTdeleteWeek);
		wButtonPanel.add(MainWindow.BTeditWeek);
		wButtonPanel.add(MainWindow.BTnewWeek);
		MainWindow.dataWeekPanel.add(wButtonPanel);
		
		MainWindow.dataWeekPanel.setBorder(BorderFactory.createTitledBorder("Viikko"));
		MainWindow.dataPanel.add(MainWindow.dataWeekPanel);
		
	}
	
	//Build datameal Panel
	protected static void buildDataMealPanel() {
		
		//Label time		
		JPanel f1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		f1.add(new JLabel("Maanantai Klo 15 "));
		MainWindow.dataMealPanel.add(f1);//Add to /////
		

		
		//Set MEAL list
		Box wListBox = Box.createVerticalBox();
		MainWindow.mealList.setListData(MainWindow.testList);
		MainWindow.mealList.setVisibleRowCount(5);
		MainWindow.mealList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		wListBox.add(new JScrollPane(MainWindow.mealList));
		MainWindow.dataMealPanel.add(wListBox);//Add to /////
		
		
		//BTN
		JPanel wButtonPanel = new JPanel(new GridLayout(1,3));
		wButtonPanel.add(MainWindow.BTemptyMeal);
		wButtonPanel.add(MainWindow.BTcontrolMeal);
		MainWindow.dataMealPanel.add(wButtonPanel);
		
		
		//Incridient table
		JScrollPane jsc = new JScrollPane(MainWindow.TBmealIncridients);
		jsc.setPreferredSize(new Dimension(150, 100));
		MainWindow.dataMealPanel.add(jsc);
				
		//Kcal 
		MainWindow.LmealKcal.setFont(MainWindow.LmealKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(MainWindow.LmealKcal);
		
		
		MainWindow.dataMealPanel.setBorder(BorderFactory.createTitledBorder("Ajankohta"));
		MainWindow.dataPanel.add(MainWindow.dataMealPanel);
	}
	
	
	
	
	
	
	
	
	
	//Build menu
	protected static void buildMenu() {
		MainWindow.menuBar.add(MainWindow.menu1);
		MainWindow.menuBar.add(MainWindow.menu3);
		MainWindow.menuBar.add(MainWindow.menu2);
		MainWindow.menu1.add(MainWindow.MIexit);
		MainWindow.menu3.add(MainWindow.MIgoToMeal);
		MainWindow.menu2.add(MainWindow.MIhelp);
		MainWindow.menu2.add(MainWindow.MIinfo);
		
	}
	
}
