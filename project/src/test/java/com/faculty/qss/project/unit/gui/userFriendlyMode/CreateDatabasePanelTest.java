package com.faculty.qss.project.unit.gui.userFriendlyMode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
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

		// Click on next button
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
	public void checkIfPressExecuteAndTableNameIsValid_ItsCreatedANewDatabase() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("new-db");

		DatabaseImpl mockedDatabase = mock(DatabaseImpl.class);

		when(mockedDatabase.createDatabase(databaseNameTextField.getText()))
				.thenReturn("Database successfully created");
		
		createDatabasePanel.setDatabase(mockedDatabase);
		
		JButton executeButton = createDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String notExpectedOutput1 = "The database name can\'t be empty.";
		String notExpectedOutput2 = "The database name can\'t contain spaces.";

		assertNotEquals(notExpectedOutput1, resultedOutput);
		assertNotEquals(notExpectedOutput2, resultedOutput);
		assertEquals("Database successfully created", resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteAndTableNameExists_ItsNotCreatedANewDatabase() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("cati-db");

		DatabaseImpl mockedDatabase = mock(DatabaseImpl.class);

		when(mockedDatabase.createDatabase(databaseNameTextField.getText()))
				.thenReturn("Database already exists");
		
		createDatabasePanel.setDatabase(mockedDatabase);
		
		JButton executeButton = createDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String notExpectedOutput1 = "The database name can\'t be empty.";
		String notExpectedOutput2 = "The database name can\'t contain spaces.";

		assertNotEquals(notExpectedOutput1, resultedOutput);
		assertNotEquals(notExpectedOutput2, resultedOutput);
		assertEquals("Database already exists", resultedOutput);
	}

	@Test
	public void checkIfPressClearButton_ItClearsDatabaseFieldAndOutputAreaText() {
		JTextField databaseNameTextField = createDatabasePanel.getTextFieldDatabaseName();
		databaseNameTextField.setText("name-to-clear");

		JTextArea outputTextArea = createDatabasePanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JButton clearButton = createDatabasePanel.getButtonClearData();
		clearButton.doClick();

		assertEquals("", databaseNameTextField.getText());
		assertEquals("", outputTextArea.getText());
	}
}
