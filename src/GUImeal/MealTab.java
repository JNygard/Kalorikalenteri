package GUImeal;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Food;
import Model.Food100g;
import Model.Meal;
import Utility.Utility;

public class MealTab {

	
	//Add incridient
	protected static void addIncridient() {
		if(MealWindow.selectedFood==null) {
			MealWindow.showMessage("Ei valittu elintarviketta.");
			return;
		}
		int amount = 0;
		try { amount = Integer.parseInt(MealWindow.TFweight.getText());
		} catch(Exception e) {
			MealWindow.showMessage("Virheellinen m‰‰r‰");return;}
		
		MealWindow.mealIncridients.add(new Food(0, MealWindow.selectedFood, amount, 0));
		MealWindow.TFweight.setText("");
		updateIncridientList();
		updateTotalKcal();
	}
	
	//Remove incridient
	protected static  void removeIncridient() {
		try {
			MealWindow.mealIncridients.remove(MealWindow.LmealIncridients.getSelectedIndex());
			MealWindow.selectedIncridient = null;
			updateIncridientList();
			updateTotalKcal();
		}catch(Exception e) {
			
		}
		if(MealWindow.mealIncridients.size()==0) {
			String[] s =  {" "};
			MealWindow.LmealIncridients.setListData(s);
		}
	}
	
	//Set selected meal
	protected static void setSelectedMeal() {
		MealWindow.selectedMeal = MealWindow.ameal.get(String.valueOf(MealWindow.JCmealList.getSelectedItem()));
		MealWindow.JTmealName.setText(MealWindow.selectedMeal.getName());
		MealWindow.mealIncridients.clear();
		for(Food f : MealWindow.selectedMeal.getFoods()) {
			MealWindow.mealIncridients.add(new Food(0, f.getFood100g(), f.getGrams(), 0));
		}
		MealWindow.TFweight.setText("");
		updateIncridientList();
		updateTotalKcal();
		showMealInputs(true);
	}
	
	//Set selected food1
	protected static  void setSelectedFood1() {
		MealWindow.selectedFood = MealWindow.af100.get(MealWindow.LfoodList1.getSelectedValue().toString());
		MealWindow.LaddNewIncridient.setText(Utility.limitString(MealWindow.selectedFood.getName(),15) + " | " + MealWindow.selectedFood.getKcal() + " kcal/100g");
	}
	
	//Set selected incridient
	protected static void setSelectedIncridient() {
		try {
		
		MealWindow.selectedIncridient = MealWindow.mealIncridients.get(MealWindow.LmealIncridients.getSelectedIndex());
		
		MealWindow.LselectedIncridient.setText(
				Utility.limitString(MealWindow.selectedIncridient.getFood100g().getName(),20) + " " +
				Utility.calculateFoodCalories(MealWindow.selectedIncridient) +
				"Kcal"
				);	
		MealWindow.LselectedIncridient.show();
		}catch (Exception e){
			MealWindow.LselectedIncridient.hide();
		}
		
	}
	
	//Meal ready, add to database and close window
	protected static boolean mealReady() {
		String title = MealWindow.JTmealName.getText();
		if(title.length()<2) {
			MealWindow.showMessage("Nimen t‰ytyy olla pidempi kuin 1 merkki");
			return false;
		}
		Meal m = MealWindow.ameal.add(new Meal(0, title));
		
		for(Food f : MealWindow.mealIncridients) {
			f.setMeal_id(m.getId());
			MealWindow.afood.add(f);
		}
		MealWindow.showMessage(title + " lis‰tty");
		emptyFields();
		return true;
		
	}
	
	
	public static void emptyFields() {
		MealWindow.mealIncridients = new ArrayList();	
		String[] s =  {" "};
		MealWindow.LmealIncridients.setListData(s);
		MealWindow.JTmealName.setText("");
		updateTotalKcal();
	}
	
	//Hide edit/new inputs
	protected static void showMealInputs(boolean n) {
		MealWindow.mealGrid.setVisible(n);
	}
	
	//UPDATE VIEW--------------------------------------------------------------------
	
	//Update foodlist tab1
	protected static  void updateFoodlist1() {
		MealWindow.LfoodList1.setListData(MealWindow.af100.getAllString(0).toArray());
	}
	//Update incridient list
	protected static void updateIncridientList() {
		if(MealWindow.mealIncridients!=null) {
			ArrayList<String> sa = Utility.toFood100toStringArray(MealWindow.mealIncridients);
			MealWindow.LmealIncridients.setListData(sa.toArray());
		}
	}
	//Update total kcal
	protected static void updateTotalKcal() {
		int total = 0;
		
		for(Food f : MealWindow.mealIncridients) {
			total+= Utility.calculateFoodCalories(f);
		}
		
		MealWindow.LkcalsCount.setText("Yht: " + total+" Kcal");
	}
	
	

	
}
