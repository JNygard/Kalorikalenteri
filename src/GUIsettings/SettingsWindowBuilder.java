package GUIsettings;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;

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
			//SettingsWindow.tabbedPane.add(SettingsWindow.tab2title , SettingsWindow.tab2panel);
			SettingsWindow.inner.add(SettingsWindow.tabbedPane);
			
			SettingsWindow.buttonPanel.add(SettingsWindow.BTcancel);
			//SettingsWindow.buttonPanel.add(SettingsWindow.BTready);
			SettingsWindow.inner.add(SettingsWindow.buttonPanel);
		}


		//Tab1
		private static void buildTab2PanelLayout() {
			Box box = Box.createHorizontalBox();
			box.setBorder(BorderFactory.createTitledBorder("Poista tiedot"));
			box.setPreferredSize(new Dimension(SettingsWindow.windowWidth-SettingsWindow.margin1X, 100));
			
			box.add(SettingsWindow.LformatWarning);
			box.add(SettingsWindow.BTdefaultData);
			
			SettingsWindow.tab1panel.add(box);
			SettingsWindow.tab1panel.setPreferredSize(new Dimension(SettingsWindow.windowWidth-SettingsWindow.margin1X, SettingsWindow.windowHeigth-SettingsWindow.margin1Y));
			
		}

		//Tab2
		private static void buildTab1PanelLayout() {
			
		}

}
