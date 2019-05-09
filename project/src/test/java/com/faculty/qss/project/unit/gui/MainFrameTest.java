package com.faculty.qss.project.unit.gui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;

public class MainFrameTest {
	
	private MainFrame mainFrame;
	
	@Test
	public void checkIfWelcomePanelIsInitialized() {
		mainFrame = new MainFrame();
		
		WelcomePanel welcomePanel = mainFrame.getWelcomePanel();
		
		assertNotNull(welcomePanel);
	}
}
