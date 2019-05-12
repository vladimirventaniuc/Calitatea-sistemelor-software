package com.faculty.qss.project.unit.gui.userFriendlyMode.alterTable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AlterTablePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.ChangeTableNamePanel;

public class ChangeTableNamePanelTest {

	private MainFrame mainFrame;

	private ChangeTableNamePanel changeTableNamePanel;

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

		JButton alterTableButton = userFriendlyModePanel.getButtonAlterTable();

		// Click on alter table option
		alterTableButton.doClick();

		AlterTablePanel alterTablePanel = userFriendlyModePanel.getAlterTablePanel();

		JRadioButton changeTableNameRadioButton = alterTablePanel.getRadioButtonChangeTableName();

		changeTableNameRadioButton.doClick();

		changeTableNamePanel = alterTablePanel.getChangeTableNamePanel();
	}

	@Test
	public void checkIfPressClearButton_ItClearsCompletedData() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JComboBox<String> tableNameComboBox = changeTableNamePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);

		JTextField tableNameTextField = changeTableNamePanel.getTextFieldNewTableName();
		tableNameTextField.setText("name-to-clear");

		JButton clearButton = changeTableNamePanel.getButtonClearData();
		clearButton.doClick();

		assertEquals(0, databaseNamesComboBox.getSelectedIndex());
		assertEquals(-1, tableNameComboBox.getSelectedIndex());
		assertEquals("", outputTextArea.getText());
		assertEquals("", tableNameTextField.getText());
	}

	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedADatabase() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(0);

		JButton executeButton = changeTableNamePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Choose a database from list";

		assertEquals(expectedOutput, resultedOutput);
	}

	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedATable() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = changeTableNamePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(0);

		JButton executeButton = changeTableNamePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Choose a table from list";

		assertEquals(expectedOutput, resultedOutput);
	}

	@Test
	public void checkIfPressExecuteButton_ChecksThatNewTableNameCantBeEmpty() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = changeTableNamePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);

		JTextField newTableNameTextField = changeTableNamePanel.getTextFieldNewTableName();
		newTableNameTextField.setText("");

		JButton executeButton = changeTableNamePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Type the new table name before executing";

		assertEquals(expectedOutput, resultedOutput);
	}

	@Test
	public void checkIfPressExecuteButtonAndAllDataIsValid_TableNamesIsChanged() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = changeTableNamePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);

		JTextField newTableNameTextField = changeTableNamePanel.getTextFieldNewTableName();
		newTableNameTextField.setText("new-table-name");

		String dbName = databaseNamesComboBox.getSelectedItem().toString().trim();
		String oldTableName = tableNameComboBox.getSelectedItem().toString().trim();
		String newTableName = newTableNameTextField.getText();
		
		TableImpl mockedTable = mock(TableImpl.class);
		when(mockedTable.changeTableName(dbName, oldTableName, newTableName))
				.thenReturn("Table was successfully renamed");

		changeTableNamePanel.setTable(mockedTable);

		JButton executeButton = changeTableNamePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Table was successfully renamed";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndAllDataIsValid_TableNamesIsNotChangedIfThisNameAlreadyExists() {
		JComboBox<String> databaseNamesComboBox = changeTableNamePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = changeTableNamePanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);

		JTextField newTableNameTextField = changeTableNamePanel.getTextFieldNewTableName();
		newTableNameTextField.setText("cati-table-1");

		String dbName = databaseNamesComboBox.getSelectedItem().toString().trim();
		String oldTableName = tableNameComboBox.getSelectedItem().toString().trim();
		String newTableName = newTableNameTextField.getText();
		
		TableImpl mockedTable = mock(TableImpl.class);
		when(mockedTable.changeTableName(dbName, oldTableName, newTableName))
				.thenReturn("File already exists");

		changeTableNamePanel.setTable(mockedTable);

		JButton executeButton = changeTableNamePanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = changeTableNamePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "File already exists";

		assertEquals(expectedOutput, resultedOutput);
	}
}
