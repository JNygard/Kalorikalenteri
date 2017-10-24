package GUImain;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Cell;
import Model.Day;
import Model.Food;
import Model.MealTime;
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
		if(day!=0) {
			if(MainWindow.selectedWeek!=null) {
				MainWindow.selectedCell = new Cell(day, hour);
				MainWindow.LselectedCell.setText(Utility.weekDayToString(day+7) + " Klo " + hour + ":00");
				
				Day d = MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX());
				MainWindow.selectedMealTime = d.getMealTime(MainWindow.selectedCell.getY());
				
				if(MainWindow.selectedMealTime!=null) {
					MainWindow.selectedMeal = MainWindow.selectedMealTime.getMeal();
					MainWindow.mealList.setSelectedIndex(MainWindow.selectedMeal.getId()-1);
				}else {
					MainWindow.selectedMealTime = null;
					MainWindow.selectedMeal = null;
					MainWindow.mealList.clearSelection();
				}
				
				updateMealIncridientsList() ;
			}
		}else {
			MainWindow.TBweekTable.clearSelection();
			MainWindow.TBweekTable.getSelectionModel().clearSelection();
		}
	}
	
	//Set selected meal
	public static void setSelectedMeal() {
		if(MainWindow.mealList.getSelectedValue()!=null) {
			MainWindow.selectedMeal = MainWindow.ameal.get(MainWindow.mealList.getSelectedValue().toString());
			MainWindow.LmealName.setText(MainWindow.selectedMeal.getName());
			if(MainWindow.selectedMealTime!=null && MainWindow.selectedCell!=null) {
				MainWindow.selectedMealTime.setMeal(MainWindow.selectedMeal);
				MainWindow.amealTime.update(MainWindow.selectedMealTime);
				
				
				WeekView.updateWeekView();
			}else if(MainWindow.selectedCell!=null) {
				
				MealTime nm = new MealTime(0, MainWindow.selectedMeal, MainWindow.selectedCell.getY(), MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX()).getId());
				MainWindow.selectedMealTime = MainWindow.amealTime.add(nm);
								
				WeekView.updateWeekView();
			}else {
				
				
				MainWindow.showMessage("Et ole valinnut ajankohtaa");
			}
			
			
			
			updateMealIncridientsList() ;
		}else {
			MainWindow.LmealName.setText("");
		}
	}
	
	//Empty cell
	public static void emptyCell() {
		if(MainWindow.selectedCell!=null) {
			if(MainWindow.selectedMealTime!=null) {
				
				if(MainWindow.confirm("Tyhjenn‰ ajankohta", "Haluatko tyhjent‰‰ ajankohdan?")) {
				
					MainWindow.amealTime.delete(MainWindow.selectedMealTime.getId());
					
					WeekView.updateWeekView();
					
				}
			}else {
				MainWindow.showMessage("No selecred mealtime");
			}
		}else {
			MainWindow.showMessage("No selecred cell");
		}
		
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
		
		
		
		if(MainWindow.selectedMeal!=null) {
			DefaultTableModel dtm = new DefaultTableModel(MainWindow.selectedMeal.getFoods().size(), 3);
			dtm.setColumnIdentifiers(MainWindow.mealIncridientscolumnNames);
			MainWindow.TBmealIncridients.setModel(dtm);
			
			int x = 0;
			int foodKcal = 0;
			for(Food d : MainWindow.selectedMeal.getFoods()) {
				MainWindow.TBmealIncridients.setValueAt(d.getFood100g().getName(),  x,0);
				MainWindow.TBmealIncridients.setValueAt(d.getGrams(),  x,1);
				MainWindow.TBmealIncridients.setValueAt(Utility.calculateFoodCalories(d),  x,2);
				foodKcal+= Utility.calculateFoodCalories(d);
				x++;
			}
			
			MainWindow.LmealKcal.setText("Ateria: " + foodKcal + " Kcal");
		}else {
			DefaultTableModel dtm = new DefaultTableModel(0, 3);
			dtm.setColumnIdentifiers(MainWindow.mealIncridientscolumnNames);
			MainWindow.TBmealIncridients.setModel(dtm);
			MainWindow.LmealKcal.setText("Ateria: 0 Kcal");
			
		}
		
		
		//MainWindow.mealList.setListData(Utility.mealToStringArray(MainWindow.ameal.getAll()).toArray());
		//MainWindow.
	}





}
