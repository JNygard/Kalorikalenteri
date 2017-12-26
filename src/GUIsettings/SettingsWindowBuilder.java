package GUIsettings;

import GUImeal.MealWindow;

public class SettingsWindowBuilder {

	public SettingsWindowBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	
	protected static void buildWindow() {
		buildTabs();
	}
	
	
	//Build tabs
		private static void buildTabs() {
			
			buildTab1PanelLayout();
			buildTab2PanelLayout();
			
			SettingsWindow.tabbedPane.add(SettingsWindow.tab1title ,SettingsWindow.tab1panel);
			SettingsWindow.tabbedPane.add(SettingsWindow.tab2title , SettingsWindow.tab2panel);
			SettingsWindow.inner.add(SettingsWindow.tabbedPane);
		}


		//Tab1
		private static void buildTab2PanelLayout() {
			// TODO Auto-generated method stub
			
		}

		//Tab2
		private static void buildTab1PanelLayout() {
			// TODO Auto-generated method stub
			
		}

}
