package GUImain;

import Model.Cell;
import Model.Day;
import Utility.Utility;

public class DataView {


	
	
	//set Selected week
	public static void setSelectedWeek() {
		MainWindow.selectedWeek = MainWindow.aweek.get(MainWindow.weekList.getSelectedValue().toString());
		MainWindow.TAweek.setText(MainWindow.selectedWeek.getDescription());
		WeekView.updateWeekView();
	}
	
	//Set selected cell
	public static void setTime(int day, int hour) {
		//MainWindow.selectedMealTime = MainWindow.selectedWeek.getDay(day).getMealTimes().get(hour);
		MainWindow.selectedCell = new Cell(day, hour);
		MainWindow.LselectedCell.setText(Utility.weekDayToString(day+7) + " Klo " + hour + ":00");
		
		setSelectedMeal();
	}
	
	//
	public static void setSelectedMeal() {
		Day d = MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX());
		MainWindow.showMessage(d.getMealTimes().toString());
		//MainWindow.selectedMealTime = MainWindow.amealTime.get(id);
		
	}
	
	
	//Update view----------------------------------------------------------------------------
	
	//Set update weeklist
	protected static void updateWeekList() {
		MainWindow.weekList.setListData(Utility.weektoStringArray(MainWindow.aweek.getAll()).toArray());
	}
	
	//Set update meal
	protected static void updateMealList() {
		MainWindow.mealList.setListData(Utility.mealToStringArray(MainWindow.ameal.getAll()).toArray());
	}
	
	//Set update meal incridients
	protected static void updateMealIncridientsList() {
		//MainWindow.mealList.setListData(Utility.mealToStringArray(MainWindow.ameal.getAll()).toArray());
		//MainWindow.
	}





}
