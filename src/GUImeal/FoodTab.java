package GUImeal;

import javax.swing.JOptionPane;

import GUImain.DataView;
import GUImain.MainWindow;
import GUImain.WeekView;
import Model.Food100g;

public class FoodTab {

	
	
	
	//Add food
	protected static void addFood() {
		String name = MealWindow.JTfoodName.getText();
		boolean newFood = true;
		
		if(MealWindow.af100.get(name)!=null) {
			if(MealWindow.confirm("Muokataan elintarviketta", "Muokataan elintarviketta. Jos haluat luoda uuden elintarvikkeen, muuta \"nimi\" kentt��.")) {
				//Edit food100g
				newFood = false;
			}else {
				return;
			}
		}
		
		if(name.length()<2 || name.length() > MealWindow.maxNameLength) {
			MealWindow.showMessage("Nimen t�ytyy olla 2 - " + MealWindow.maxNameLength + " merkki� pitk�");
			return;
		}
		int kcal = 0;
		try {
			kcal = Integer.parseInt(MealWindow.JTfoodKcal.getText());
		}catch (Exception e) {
			MealWindow.showMessage("Virheellinen kcal sy�te");
			return;
		}
		if(kcal>MealWindow.maxKcal) {
			MealWindow.showMessage("Liian suuri sy�te. Sy�te alle " + MealWindow.maxKcal + " Kcal");
			return;
		}
		if(newFood) {
			MealWindow.af100.add(new Food100g(0,name, kcal));
			MealWindow.showMessage(name + " lis�tty elintarvikkeisiin");
		}else {
			MealWindow.selectedFood2.setKcal(kcal);
			MealWindow.af100.update(MealWindow.selectedFood2);
			MealWindow.showMessage(name + " muokattu");
			DataView.updateAll();
			
		}
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
		MealWindow.JTfoodName.setText(MealWindow.selectedFood2.getName());
		MealWindow.JTfoodKcal.setText(MealWindow.selectedFood2.getKcal()+"");
	}
	
	//Delete food
	protected static void deleteFood() {
		String fName = MealWindow.selectedFood2.getName();
		int count = 0;
		if(MealWindow.confirm("Poista elintarvike", "Haluatko varmasti poistaa elintarvikkeen?")) {
			count = MealWindow.af100.delete(MealWindow.selectedFood2.getId());
		}else {
			return;
		}
		if(count==0) {
			updateFoodlist2();
			MealTab.updateFoodlist1();
		}else {
			MealWindow.showMessage("Elintarviketta " +fName+ " ei voi poistaa koska sit� k�ytet��n " + count + " kertaa eri aterioissa. Elintarvike tulee poistaa aterioista, tai ateria poistaa, jotta se voitaisiin poistaa kokonaan ohjelmasta.");
		}
	}
	
	
	//Set selected food
	protected static void setSelectedFood() {
		if(MealWindow.LfoodList2.getSelectedValue()!=null) {
			try {
			MealWindow.selectedFood2 = MealWindow.af100.get(MealWindow.LfoodList2.getSelectedValue().toString());
			MealWindow.BfoodRemove.setEnabled(true);
			MealWindow.BfoodEdit.setEnabled(true);
			}catch(Exception e) {
				
			}
		}else {
			MealWindow.BfoodRemove.setEnabled(false);
			MealWindow.BfoodEdit.setEnabled(false);
		}
	}
	
	
	
	
	//View update methods----------------------------------------------------------
	
	
	//Update foodlist tab2
	protected static void updateFoodlist2() {
		MealWindow.LfoodList2.setListData(MealWindow.af100.getAllString(0).toArray());
	}

}
