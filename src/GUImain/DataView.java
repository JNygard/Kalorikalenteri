package GUImain;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Cell;
import Model.Day;
import Model.Food;
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
	
	//Set selected meal
	public static void setSelectedMeal() {
		Day d = MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX());
		MainWindow.selectedMealTime = d.getMealTime(MainWindow.selectedCell.getY());
		
		if(MainWindow.selectedMealTime!=null) {
			MainWindow.selectedMeal = MainWindow.selectedMealTime.getMeal();
			MainWindow.mealList.setSelectedIndex(MainWindow.selectedMeal.getId()-1);
		}else {
			MainWindow.selectedMeal = null;
			MainWindow.mealList.clearSelection();
		}
		
		
		updateMealIncridientsList() ;
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
		ArrayList<Object> ojs = new ArrayList();
		String[] mealIncridientscolumnNames = {"Nimi","g/ml","Kcal"};
		Object[][] mealIncridientsData = {
			    {"Name", 50, 50},{"Name2", 50, 50},{"Name3", 50, 50},{"Name4", 50, 50}, {"Name5", 50, 50},
			    {"Name6", 50, 50}, {"Name6", 50, 50},{"Name6", 50, 50},{"Name6", 50, 50},{"Name6", 50, 50}
		};
		
		for(Food d : MainWindow.selectedMeal.getFoods()) {

		}
		
		
		//MainWindow.mealList.setListData(Utility.mealToStringArray(MainWindow.ameal.getAll()).toArray());
		//MainWindow.
	}





}
