package com.faculty.qss.project.unit.gui.userFriendlyMode;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.CreateDatabasePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class CreateDatabasePanelTest {

	private MainFrame mainFrame;
	
	private CreateDatabasePanel createDatabasePanel;
	
	@Before
	public void setUp() {
		mainFrame = new MainFrame();
		
		WelcomePanel welcomePanel = new WelcomePanel();
		
		mainFrame.add(welcomePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
		
		JRadioButton userFriendlyModeRadioButton = welcomePanel.getRadioButtonUserFriendlyMode();
		
		// Click on user-friendly mode radio button
		userFriendlyModeRadioButton.doClick();
		
		JButton buttonNextInteractionMode = welcomePanel.getButtonNextInteractionMode();
		
		//Click on next button
		buttonNextInteractionMode.doClick();
		
		UserFriendlyModePanel userFriendlyModePanel = welcomePanel.getUserfriendlyPanel();
		
		JButton createDatabaseButton = userFriendlyModePanel.getButtonCreateDatabase();

		// Click on create database option
		createDatabaseButton.doClick();
		
		createDatabasePanel = userFriendlyModePanel.getCreateDatabasePanel();
	}
	
	@Test
	public void checkIfPressExecute_ItsCheckedThatNameIsEmpty() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("");
		
		JButton executeButton = createDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "The database name can\'t be empty.";
		
		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecute_ItsCheckedThatNameItCantContainSpaces() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("test database");
		
		JButton executeButton = createDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "The database name can\'t contain spaces.";
		
		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteAndTableNameRespectConventions_ItsCheckedThatGetResponseFromBackEnd() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("cati-db");
		
		JButton executeButton = createDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String notExpectedOutput1 = "The database name can\'t be empty.";
		String notExpectedOutput2 = "The database name can\'t contain spaces.";
		
		assertNotEquals(notExpectedOutput1, resultedOutput);
		assertNotEquals(notExpectedOutput2, resultedOutput);
		assertNotEquals("", resultedOutput);
	}	
}
