package com.faculty.qss.project.unit.gui.userFriendlyMode;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.DeleteTablePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class DeleteTablePanelTest {

	private MainFrame mainFrame;

	private DeleteTablePanel deleteTablePanel;

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

		JButton deleteTableButton = userFriendlyModePanel.getButtonDeleteTable();

		// Click on delete table option
		deleteTableButton.doClick();

		deleteTablePanel = userFriendlyModePanel.getDeleteTablePanel();
	}
	
	@Test
	public void checkIfPressClearButton_ItClearsCompletedData() {
		JComboBox<String> databaseNamesComboBox = deleteTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		JTextArea outputTextArea = deleteTablePanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JComboBox<String> tableNameComboBox = deleteTablePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);


		JButton clearButton = deleteTablePanel.getButtonClearData();
		clearButton.doClick();

		assertEquals(0, databaseNamesComboBox.getSelectedIndex());
		assertEquals(-1, tableNameComboBox.getSelectedIndex());
		assertEquals("", outputTextArea.getText());
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedADatabase() {
		JComboBox<String> databaseNamesComboBox = deleteTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(0);

		JButton executeButton = deleteTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = deleteTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You have to select a database name from list";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedATable() {
		JComboBox<String> databaseNamesComboBox = deleteTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);
		
		JComboBox<String> tableNameComboBox = deleteTablePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(0);

		JButton executeButton = deleteTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = deleteTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You have to select a table name from list";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndDataIsValidAndTableNotExists_CreatesNewTable() {
		JComboBox<String> databaseNamesComboBox = deleteTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);
		
		JComboBox<String> tableNameComboBox = deleteTablePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);

		String dbName = databaseNamesComboBox.getSelectedItem().toString().trim();
		String tableToDelete = tableNameComboBox.getSelectedItem().toString().trim();
		
		TableImpl mockedTable = mock(TableImpl.class);
		
		when(mockedTable.deleteTable(dbName, tableToDelete))
				.thenReturn("Table has been successfully deleted");
		
		deleteTablePanel.setTable(mockedTable);
		
		JButton executeButton = deleteTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = deleteTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table has been successfully deleted";

		assertEquals(expectedOutput, resultedOutput);
	}
}
