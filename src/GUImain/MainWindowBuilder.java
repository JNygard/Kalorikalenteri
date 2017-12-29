package GUImain;

import java.awt.BorderLayout;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import GUImeal.MealWindow;
import Utility.MyTableModel;



public class MainWindowBuilder {


	//Build tabs
	protected static void buildView() {	
		buildDataPanel();
		buildWeekPanel();
	}
	

	
	//Build week view panel
	protected static void buildWeekPanel() {
		
		//Week table
		String[] columnNameWeek = {"Klo", "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai", "Sunnuntai"};
		Object[][] dataWeek = {
			    {"0:00", "", " ", " ", " ", "", " ", " "},{"1:00", "", " ", " ", " ", "", " ", " "},
			    {"2:00", "", " ", " ", " ", "", " ", " "},{"3:00", "", " ", " ", " ", "", " ", " "},
			    {"4:00", "", " ", " ", " ", "", " ", " "},{"5:00", "", " ", " ", " ", "", " ", " "},
			    {"6:00", "", " ", " ", " ", "", " ", " "},{"7:00", "", " ", " ", " ", "", " ", " "},
			    {"8:00", "", " ", " ", " ", "", " ", " "}, {"9:00", "", " ", " ", " ", "", " ", " "},
			    {"10:00", "", " ", " ", " ", "", " ", " "}, {"11:00", "", " ", " ", " ", "", " ", " "},
			    {"12:00", "", " ", " ", " ", "", " ", " "},{"13:00", "", " ", " ", " ", "", " ", " "},
			    {"14:00", "", " ", " ", " ", "", " ", " "},{"15:00", "", " ", " ", " ", "", " ", " "},
			    {"16:00", "", " ", " ", " ", "", " ", " "}, {"17:00", "", " ", " ", " ", "", " ", " "},
			    {"18:00", "", " ", " ", " ", "", " ", " "}, {"19:00", "", " ", " ", " ", "", " ", " "},
			    {"20:00", "", " ", " ", " ", "", " ", " "},{"21:00", "", " ", " ", " ", "", " ", " "},
			    {"22:00", "", " ", " ", " ", "", " ", " "},{"23:00", "", " ", " ", " ", "", " ", " "}
		};
		
		//Set cell editing false
		DefaultTableModel model = new DefaultTableModel(dataWeek, columnNameWeek);
		MainWindow.TBweekTable = new JTable(model) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; //Disallow the editing of any cell
			}
		};
		
		//MainWindow.TBweekTable  = new JTable(dataWeek, columnNameWeek);
		
		MainWindow.jsc  = new JScrollPane(MainWindow.TBweekTable);

		MainWindow.TBweekTable.setRowHeight(40);
		
		//MainWindow.TBweekTable.setPreferredScrollableViewportSize(new Dimension(700,450));
		
		//MainWindow.TBweekTable.setAutoResizeMode( MainWindow.TBweekTable.AUTO_RESIZE_OFF );
		//MainWindow.TBweekTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		//MainWindow.TBweekTable.setFillsViewportHeight(true);
		
		MainWindow.TBweekTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MainWindow.TBweekTable.setCellSelectionEnabled(true);
		MainWindow.TBweekTable.disable();
		
		MainWindow.inner.add(MainWindow.jsc,BorderLayout.CENTER );
		
	}
	
	
	//Build data panel
	protected static void buildDataPanel() {
		
		buildDataWeekPanel() ;
		buildDataMealPanel() ;
		
		MainWindow.inner.add(MainWindow.dataPanel, BorderLayout.LINE_START);
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
		MainWindow.dataWeekPanel.add(new JScrollPane(MainWindow.TAweek));

		//BTN
		JPanel wButtonPanel = new JPanel(new GridLayout(1,3));
		wButtonPanel.setMaximumSize(new Dimension(MainWindow.maxBTNwidth, MainWindow.maxBTNheigth));
		wButtonPanel.add(MainWindow.BTdeleteWeek);
		wButtonPanel.add(MainWindow.BTeditWeek);
		wButtonPanel.add(MainWindow.BTnewWeek);
		MainWindow.dataWeekPanel.add(wButtonPanel);
		
		MainWindow.dataWeekPanel.setMaximumSize(new Dimension(600,200));
		MainWindow.dataWeekPanel.setBorder(BorderFactory.createTitledBorder("Viikko"));
		MainWindow.dataPanel.add(MainWindow.dataWeekPanel,BorderLayout.CENTER);
		
	}
	
	//Build datameal Panel
	protected static void buildDataMealPanel() {
		
		//Label time		
		JPanel f1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		f1.add(MainWindow.LselectedCell);
		MainWindow.LselectedCell.setFont(MainWindow.LmealKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(f1);//Add to /////
		

		
		//Set MEAL list
		Box wListBox = Box.createVerticalBox();
		MainWindow.mealList.setListData(MainWindow.testList);
		MainWindow.mealList.setVisibleRowCount(5);
		MainWindow.mealList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MainWindow.mealList.setFocusable(false);
		wListBox.add(new JScrollPane(MainWindow.mealList));
		MainWindow.dataMealPanel.add(wListBox);//Add to /////
		
		
		//BTN
		JPanel wButtonPanel = new JPanel(new GridLayout(1,3));
		wButtonPanel.setMaximumSize(new Dimension(MainWindow.maxBTNwidth, MainWindow.maxBTNheigth));
		MainWindow.BTemptyMeal.setEnabled(false);
		wButtonPanel.add(MainWindow.BTemptyMeal);
		wButtonPanel.add(MainWindow.BTcontrolMeal);
		MainWindow.dataMealPanel.add(wButtonPanel);
		

		
		//Label meal name		
				JPanel f2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				f2.add(MainWindow.LmealName);
				MainWindow.LmealName.setFont(MainWindow.LmealKcal.getFont().deriveFont(14.0f));
				MainWindow.dataMealPanel.add(f2);//Add to /////
		
		//Incridient table
				MainWindow.TBmealIncridients.setEnabled(false);
		JScrollPane jsc = new JScrollPane(MainWindow.TBmealIncridients);
		jsc.setPreferredSize(new Dimension(150, 100));
		MainWindow.dataMealPanel.add(jsc);
				
		//Kcal 
		MainWindow.LmealKcal.setFont(MainWindow.LmealKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(MainWindow.LmealKcal);
		
		MainWindow.dataMealPanel.setMaximumSize(new Dimension(600,350));
		MainWindow.dataMealPanel.setBorder(BorderFactory.createTitledBorder("Ajankohta"));
		
		//Label day kcal
		
		JPanel f5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		f5.add(MainWindow.LdayKcal);
		MainWindow.LdayKcal.setFont(MainWindow.LdayKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(f5);//Add to /////
		
		//Label AVG day kcal		
		JPanel f4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		f4.add(MainWindow.LdayKcalAVG);
		MainWindow.LdayKcalAVG.setFont(MainWindow.LweekKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(f4);//Add to /////
		
		//Label week kcal		
		JPanel f3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		f3.add(MainWindow.LweekKcal);
		MainWindow.LweekKcal.setFont(MainWindow.LweekKcal.getFont().deriveFont(14.0f));
		MainWindow.dataMealPanel.add(f3);//Add to /////
		
		
		MainWindow.dataPanel.add(MainWindow.dataMealPanel);
	}
	
	
	
	
	
	//Build menu
	protected static void buildMenu() {
		MainWindow.menuBar.add(MainWindow.menu1);
		MainWindow.menuBar.add(MainWindow.menu3);
		MainWindow.menuBar.add(MainWindow.menu2);
		
		MainWindow.menu1.add(MainWindow.MIprint);
		MainWindow.menu1.add(MainWindow.MIsettings);
		MainWindow.menu1.add(MainWindow.MIexit);
		MainWindow.menu3.add(MainWindow.MIaddWeek);
		MainWindow.menu3.add(MainWindow.MIgoToMeal);
		MainWindow.menu2.add(MainWindow.MIhelp);
		MainWindow.menu2.add(MainWindow.MIinfo);
		
	}
	
}
