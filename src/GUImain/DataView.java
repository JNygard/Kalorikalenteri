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
		if(!MainWindow.weekList.isSelectionEmpty()) {
			if(MainWindow.weekList.getSelectedValue()!=null) {
				MainWindow.selectedWeek = MainWindow.aweek.get(MainWindow.weekList.getSelectedValue().toString());
				MainWindow.TAweek.setText(MainWindow.selectedWeek.getDescription());
			
				updateAVGdayKcal();
				updateDayCalories() ;
				updateWeekCalories();
				WeekView.updateWeekView();
			}
			
		}else {
			if(MainWindow.aweek.getAll().size()!=0) {
				updateWeekList();
				MainWindow.weekList.setSelectedIndex(0);
				setSelectedWeek();
			}else {
				//No weeks, must create new week
				MainWindow.showMessage("Ei yht‰‰n viikkon‰kym‰‰. Sovelluksen k‰yttˆ vaatii v‰hint‰‰n yhden viikkon‰kym‰n.");
				MainWindow.cww.show();
				
			}
		}
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
					MainWindow.BTemptyMeal.setEnabled(true);
					
					MainWindow.mealList.setSelectedIndex(jmealListIndex());
				}else {
					MainWindow.BTemptyMeal.setEnabled(false);
					MainWindow.selectedMealTime = null;
					MainWindow.selectedMeal = null;
					MainWindow.mealList.clearSelection();
					
					MainWindow.mealList.clearSelection();
				}
				
				
				updateMealIncridientsList() ;
				updateDayCalories() ;
				updateAVGdayKcal();
				updateWeekCalories();
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
			if(MainWindow.selectedMealTime!=null && MainWindow.selectedCell!=null) {
				MainWindow.selectedMealTime.setMeal(MainWindow.selectedMeal);
				MainWindow.amealTime.update(MainWindow.selectedMealTime);
				
				
				WeekView.updateWeekView();
			}else if(MainWindow.selectedCell!=null) {
				
				MealTime nm = new MealTime(0, MainWindow.selectedMeal, MainWindow.selectedCell.getY(), MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX()).getId());
				MainWindow.selectedMealTime = MainWindow.amealTime.add(nm);
								
				MainWindow.BTemptyMeal.setEnabled(true);
				WeekView.updateWeekView();
			}else {
				
				
				MainWindow.showMessage("Valitse ensin viereisest‰ taulukosta ajankohtaa kuvaava solu");
			}
			
			
			updateAVGdayKcal();
			updateDayCalories() ;
			updateWeekCalories();
			updateMealIncridientsList() ;
		}else {
			MainWindow.LmealName.setText("");
		}
	}
	
	//Empty cell
	public static void emptyCell() {
		if(MainWindow.selectedCell!=null) {
			if(MainWindow.selectedMealTime!=null) {
				
					MainWindow.amealTime.delete(MainWindow.selectedMealTime.getId());
					MainWindow.BTemptyMeal.setEnabled(false);
					
					WeekView.updateWeekView();
					updateDayCalories() ;
					updateAVGdayKcal();
					updateWeekCalories();
				
			}else {
				MainWindow.showMessage("Ajankohta on jo tyhj‰");
			}
		}else {
			MainWindow.showMessage("Ei valittua ajankohtaa");
		}
		
	}
	
	//Delete week
	public static void deleteWeek() {
		if(MainWindow.selectedWeek!=null) {
			if(MainWindow.confirm("Poistetaan viikkoaikataulu", "Haluatko aivan varmasti poistaa viikkoaikataulun? Kaikki viikon tiedot poistuvat")) {
				MainWindow.aweek.delete(MainWindow.selectedWeek);
				MainWindow.selectedWeek=null;
				WeekView.updateWeekView();
				updateAll();
			}
			
			
		}else {
			MainWindow.showMessage("Ei valittua viikkoa");
		}
	}
	
	
	
	//Update view----------------------------------------------------------------------------
	//Update ALL
	public static void updateAll() {
		updateWeekCalories();
		updateAVGdayKcal() ;
		updateWeekCalories() ;
		MainWindow.weekList.clearSelection();
		updateWeekList();
		updateMealList();
		updateMealIncridientsList();
	}
	
	//Set day kcal
	public static void updateDayCalories() {
		
		int k = 0;
		if(MainWindow.selectedCell!=null) {
			Day d =  MainWindow.selectedWeek.getDay(MainWindow.selectedCell.getX());
			k =  d.getKcals();
			MainWindow.LdayKcal.setText(Utility.weekDayToString(d.getDay()+7)+": " + k + " Kcal");
		}else {
			MainWindow.LdayKcal.setText("");

		}
			
	}
	
	//Set week kcal
	public static void updateWeekCalories() {
		int k = 0;
		if(MainWindow.selectedWeek!=null) 
			k =  MainWindow.selectedWeek.getKcal();
		MainWindow.LweekKcal.setText("Viikossa: " + k + " Kcal");
		
			
	}
	
	//Set AVG day kcal
	public static void updateAVGdayKcal() {
		int k = 0;
		if(MainWindow.selectedWeek!=null)
			 k = MainWindow.selectedWeek.getKcal()/7;
		MainWindow.LdayKcalAVG.setText("Keskim‰‰rin: " + k + " Kcal/p‰iv‰");
	}
	
	
	//Set update weeklist
	public static void updateWeekList() {
		MainWindow.weekList.setListData(Utility.weektoStringArray(MainWindow.aweek.getAll()).toArray());
	}
	
	//Set update meal
	public static void updateMealList() {
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
			MainWindow.LmealName.setText(MainWindow.selectedMeal.getName());
			
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
			MainWindow.LmealName.setText(" ");
			
		}
		

	}
	
	//Return selected Jmeallist index of meal
	private static int jmealListIndex() {
		String s = MainWindow.selectedMeal.getName();
		
		int i = 0;
		while(i<MainWindow.mealList.getModel().getSize()) {
			if(MainWindow.mealList.getModel().getElementAt(i).equals(s)) {
				return i;
			}
			i++;
		}
		
		
		return 0;
	}





}
