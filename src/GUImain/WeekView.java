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
		Week w = MainWindow.selectedWeek;
		
		
		for(Day d : w.getDays()) {
			for(MealTime m : d.getMealTimes()) {
				MainWindow.TBweekTable.setValueAt(m.getMeal().getName(),  m.getHour(),d.getDay());
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
	
