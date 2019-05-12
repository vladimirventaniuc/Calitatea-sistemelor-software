package com.faculty.qss.project.unit.gui.userFriendlyMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.DeleteDatabasePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class DeleteDatabasePanelTest {

	private MainFrame mainFrame;

	private DeleteDatabasePanel deleteDatabasePanel;

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

		JButton deleteDatabaseButton = userFriendlyModePanel.getButtonDeleteDatabase();

		// Click on delete database option
		deleteDatabaseButton.doClick();

		deleteDatabasePanel = userFriendlyModePanel.getDeleteDatabasePanel();
	}
	
	@Test
	public void checkIfPressClearButton_ItClearsDatabaseFieldAndOutputAreaText() {
		JComboBox<String> databaseNamesComboBox = deleteDatabasePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		JTextArea outputTextArea = deleteDatabasePanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JButton clearButton = deleteDatabasePanel.getButtonClearData();
		clearButton.doClick();

		assertEquals(0, databaseNamesComboBox.getSelectedIndex());
		assertEquals("", outputTextArea.getText());
	}
	
	@Test
	public void checkIfPressExecuteButton_CheckThatHasToBeSelectedADatabaseToBeRemoved() {
		JComboBox<String> databaseNamesComboBox = deleteDatabasePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(0);

		JButton executeButton = deleteDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = deleteDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You have to select a database name from list";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndSelectDatabaseName_DatabaseItsDeleted() {
		JComboBox<String> databaseNamesComboBox = deleteDatabasePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		DatabaseImpl mockedDatabase = mock(DatabaseImpl.class);

		when(mockedDatabase.deleteDatabase((String) databaseNamesComboBox.getSelectedItem()))
				.thenReturn("Database has been successfully deleted");
		
		deleteDatabasePanel.setDatabase(mockedDatabase);

		
		JButton executeButton = deleteDatabasePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = deleteDatabasePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		assertEquals("Database has been successfully deleted", resultedOutput);
	}
}
