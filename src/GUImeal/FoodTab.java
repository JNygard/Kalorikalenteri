package GUImeal;

import javax.swing.JOptionPane;

import Model.Food100g;

public class FoodTab {

	
	
	
	//Add food
	protected static void addFood() {
		String name = MealWindow.JTfoodName.getText();
		if(name.length()<2) {
			MealWindow.showMessage("Anna pidempi nimi");
			return;
		}
		int kcal = 0;
		try {
			kcal = Integer.parseInt(MealWindow.JTfoodKcal.getText());
		}catch (Exception e) {
			MealWindow.showMessage("Virheellinen kcal syöte");
			return;
		}
		
		MealWindow.af100.add(new Food100g(0,name, kcal));
		MealWindow.showMessage(name + " lisätty elintarvikkeisiin");
		updateFoodlist2();
		MealTab.updateFoodlist1();
		emptyFields();
	}
	
	//Empty fields
	protected static void emptyFields() {
		MealWindow.JTfoodName.setText("");
		MealWindow.JTfoodKcal.setText("");
	}
	
	
	//Edit food
	protected static void editFood() {
		
	}
	
	//Delete food
	protected static void deleteFood() {
		String fName = MealWindow.selectedFood2.getName();
		boolean confirm = MealWindow.confirm("Poista elintarvike", "Haluatko varmasti poistaa elintarvikkeen?");
		int count = 0;
		if(confirm) {
			count = MealWindow.af100.delete(MealWindow.selectedFood2.getId());
		}
		if(count==0) {
			updateFoodlist2();
			MealTab.updateFoodlist1();
		}else {
			MealWindow.showMessage("Elintarviketta " +fName+ " ei voi poistaa koska sitä käytetään " + count + " kertaa eri aterioissa. Elintarvike tulee poistaa aterioista, tai ateria poistaa, jotta se voitaisiin poistaa kokonaan ohjelmasta.");
		}
	}
	
	
	//Set selected food
	protected static void setSelectedFood() {
		try {
		MealWindow.selectedFood2 = MealWindow.af100.get(MealWindow.LfoodList2.getSelectedValue().toString());
		}catch(Exception e) {
			
		}
	}
	
	
	
	
	//View update methods----------------------------------------------------------
	
	
	//Update foodlist tab2
	protected static void updateFoodlist2() {
		MealWindow.LfoodList2.setListData(MealWindow.af100.getAllString(0).toArray());
	}

}
