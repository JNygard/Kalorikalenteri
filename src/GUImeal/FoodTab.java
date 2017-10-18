package GUImeal;

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
	
	
	
	
	
	
	
	
	
	
	//View update methods----------------------------------------------------------
	
	
	//Update foodlist tab2
	protected static void updateFoodlist2() {
		MealWindow.LfoodList2.setListData(MealWindow.af100.getAllString(0).toArray());
	}

}
