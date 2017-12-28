package GUIsettings;

import DB.DBmanager;
import GUImain.MainWindow;

public class Settings {

	public Settings() {
		// TODO Auto-generated constructor stub
	}

	
	//Set default data to DB
	protected static boolean formatProgramData() {
		
		if(SettingsWindow.confirm("Poistetaan tiedot", "Oletko aivan varma, ett‰ haluat poistaa KAIKKI lis‰‰m‰si tiedot sovelluksesta?")){
			if(SettingsWindow.confirm("Poistetaan tiedot", "Viimeinen varmistus")){
				DBmanager.eraseAll();
				MainWindow.showMessage("Kaikki tiedot poistettu. Sovellus suljetaan");
				return true;
			}
		}
		return false;
	}
	
}
