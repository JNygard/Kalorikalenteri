package GUImain;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Day;
import Model.MealTime;
import Model.Week;

public class WeekView {


	
	//Update weekview
	public static void updateWeekView() {
		setEmptyTable();
		if(MainWindow.selectedWeek!=null) {
			MainWindow.selectedWeek = MainWindow.aweek.get(MainWindow.selectedWeek.getId());
			MainWindow.TBweekTable.enable();
			
			
			
			for(Day d : MainWindow.selectedWeek.getDays()) {
				for(MealTime m : d.getMealTimes()) {
					MainWindow.TBweekTable.setValueAt(m.getMeal().getName(),  m.getHour(),d.getDay());
				}
			}
		}
		
	}
	
	//Set empty table
	public static void setEmptyTable() {
		int x = 1;
		while(x<=7) {
			int y = 1;
			while(y<=23) {
				MainWindow.TBweekTable.setValueAt("", y, x);
				y++;
			}
			x++;
		}
		
		
	}
}
	
