package GUImeal;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import GUImain.DataView;
import GUImain.MainWindow;
import GUImain.WeekView;
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
			MealWindow.showMessage("Virheellinen määrä");return;}
		
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
			MealWindow.BremoveIncridient.setEnabled(false);
		}catch(Exception e) {
			
		}
		if(MealWindow.mealIncridients.size()==0) {
			String[] s =  {" "};
			MealWindow.LmealIncridients.setListData(s);
		}
	}
	
	//Delete meal
	protected static void deleteMeal() {
		
		if(MealWindow.selectedMeal!=null) {
				if(MealWindow.confirm("Poistetaan ateria", "Haluatko varmasti poistaa aterian " + MealWindow.selectedMeal.getName() +  "?")) {
					int count = MealWindow.ameal.delete(MealWindow.selectedMeal.getId());
					if(count==0) {
						MealWindow.showMessage("Ateria poistettu");
						updateMealList();
						DataView.updateMealList();
	
					}else {
						MealWindow.showMessage("Ateriaa ei voida poistaa, koska sitä käytetään " + count + " ajankohdassa");
					}
				}
		}
		
	}
	
	//New meal mode
	protected static void addMealMode() {
		MealWindow.mode = 0;
		MealWindow.selectedMeal = null;
		MealWindow.JCmealList.setSelectedIndex(0);
		MealWindow.BmealDelete.setEnabled(false);
		emptyFields();
		showMealInputs(true);
	}
	
	//Set selected meal
	protected static void setSelectedMeal() {
		if(MealWindow.JCmealList.getSelectedItem()==null ||MealWindow.JCmealList.getSelectedItem()=="") {
			MealWindow.mode = 0;
			emptyFields();
			MealWindow.BmealDelete.setEnabled(false);
			return;
		}
		MealWindow.BmealDelete.setEnabled(true);
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
		MealWindow.mode = 1;
	}
	
	//Set selected food1
	protected static  void setSelectedFood1() {
		MealWindow.BaddNewIncridient.setEnabled(true);
		MealWindow.selectedFood = MealWindow.af100.get(MealWindow.LfoodList1.getSelectedValue().toString());
		MealWindow.LaddNewIncridient.setText(Utility.limitString(MealWindow.selectedFood.getName(),15) + " | " + MealWindow.selectedFood.getKcal() + " kcal/100g");
	}
	
	//Set selected incridient
	protected static void setSelectedIncridient() {
		try {
		
		MealWindow.selectedIncridient = MealWindow.mealIncridients.get(MealWindow.LmealIncridients.getSelectedIndex());
		MealWindow.BremoveIncridient.setEnabled(true);
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
	
	//Meal ready, ADD / EDIT to database
	protected static boolean mealReady() {
		String title = MealWindow.JTmealName.getText();
		
		//EDIT the meal
		if(MealWindow.ameal.get(title)!=null) {
			if(MealWindow.confirm("Muokataan ateriaa", "Haluatko varmasti muokata aterian '" + MealWindow.selectedMeal.getName() + "' sisältöä? Muutos vaikuttaa myös jokaiseen ajankohtaan, johon ateria on liitetty viikkonäkymässä")) {
				Meal updatedMeal = MealWindow.selectedMeal;
				//Delete old incridients
				MealWindow.afood.deleteByMeal(updatedMeal.getId());
				//Add new incridients
				for(Food f : MealWindow.mealIncridients) {
					f.setMeal_id(updatedMeal.getId());
					MealWindow.afood.add(f);
				}
				MealWindow.ameal.update(updatedMeal);
				MealWindow.showMessage("Ateria muokattu");
				updateMealList();
				emptyFields();
				DataView.setSelectedWeek();
				return true;
			}else {
				//Confirm denied
				return false;
			}
		}	
		
		
		//NEW meal
		if(title.length()<2) {
			//Too oshort title
			MealWindow.showMessage("Nimen täytyy olla pidempi kuin 1 merkki");
			return false;
		}
		Meal m = MealWindow.ameal.add(new Meal(0, title));
		for(Food f : MealWindow.mealIncridients) {
			f.setMeal_id(m.getId());
			MealWindow.afood.add(f);
		}
		MealWindow.showMessage(title + " lisätty");
		updateMealList();
		emptyFields();
		return true;
		
	}
	
	//Empty fields
	public static void emptyFields() {
		MealWindow.BremoveIncridient.setEnabled(false);
		MealWindow.BaddNewIncridient.setEnabled(false);


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
	
	//Update mealList
	protected static void updateMealList() {
		MealWindow.JCmealList.removeAllItems();
		MealWindow.JCmealList.addItem("");
		for(Meal m : MealWindow.ameal.getAll() ){
			MealWindow.JCmealList.addItem(m.getName());
		}
	}
	
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
