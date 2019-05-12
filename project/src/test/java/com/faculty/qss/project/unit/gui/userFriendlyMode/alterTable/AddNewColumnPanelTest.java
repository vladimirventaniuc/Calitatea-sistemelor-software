package com.faculty.qss.project.unit.gui.userFriendlyMode.alterTable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AddNewColumnPanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AlterTablePanel;

public class AddNewColumnPanelTest {

	private MainFrame mainFrame;

	private AddNewColumnPanel addNewColumnPanel;

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

		JRadioButton addNewTableColumnRadioButton = alterTablePanel.getRadioButtonAddColumn();

		addNewTableColumnRadioButton.doClick();

		addNewColumnPanel = alterTablePanel.getAddNewColumnPanel();
	}
	
	@Test
	public void checkIfPressClearButton_ItClearsCompletedData() {
		JComboBox<String> databaseNamesComboBox = addNewColumnPanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		JTextArea outputTextArea = addNewColumnPanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JComboBox<String> tableNameComboBox = addNewColumnPanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);
		
		addNewColumnPanel.getComboBoxColumnType().setSelectedIndex(1);
		addNewColumnPanel.getComboBoxColumnType1().setSelectedIndex(1);
		addNewColumnPanel.getComboBoxColumnType2().setSelectedIndex(1);
		addNewColumnPanel.getComboBoxColumnType3().setSelectedIndex(1);
		
		addNewColumnPanel.getTextFieldColumnName().setText("Column name");
		addNewColumnPanel.getTextFieldColumnName1().setText("Column name");
		addNewColumnPanel.getTextFieldColumnName2().setText("Column name");
		addNewColumnPanel.getTextFieldColumnName3().setText("Column name");

		JButton clearButton = addNewColumnPanel.getButtonClearData();
		clearButton.doClick();

		assertEquals(0, databaseNamesComboBox.getSelectedIndex());
		assertEquals(-1, tableNameComboBox.getSelectedIndex());
		assertEquals("", outputTextArea.getText());
		
		Component[] panelColumnComponents = addNewColumnPanel.getPanelColumns().getComponents();
		for (int i = 0; i < panelColumnComponents.length; i++) {
			if (panelColumnComponents[i] instanceof JTextField) {
				assertEquals("", ((JTextField) panelColumnComponents[i]).getText());
			} else if (panelColumnComponents[i] instanceof JComboBox) {
				assertEquals(0, ((JComboBox) panelColumnComponents[i]).getSelectedIndex());
			}
		}
	}

	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedADatabase() {
		JComboBox<String> databaseNamesComboBox = addNewColumnPanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(0);

		JButton executeButton = addNewColumnPanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = addNewColumnPanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Choose a database from list";

		assertEquals(expectedOutput, resultedOutput);
	}

	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedATable() {
		JComboBox<String> databaseNamesComboBox = addNewColumnPanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = addNewColumnPanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(0);

		JButton executeButton = addNewColumnPanel.getButtonExecuteCommand();
		executeButton.doClick();

		JTextArea outputTextArea = addNewColumnPanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();

		String expectedOutput = "Choose a table from list";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeAddedAtLeastOneColumn() {
		JComboBox<String> databaseNamesComboBox = addNewColumnPanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = addNewColumnPanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);
		
		addNewColumnPanel.getComboBoxColumnType().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType1().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType2().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType3().setSelectedIndex(0);
		
		addNewColumnPanel.getTextFieldColumnName().setText("");
		addNewColumnPanel.getTextFieldColumnName1().setText("");
		addNewColumnPanel.getTextFieldColumnName2().setText("");
		addNewColumnPanel.getTextFieldColumnName3().setText("");

		JButton executeButton = addNewColumnPanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = addNewColumnPanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You need to have at least a column to add";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndDataIsValid_AltersTable() {
		JComboBox<String> databaseNamesComboBox = addNewColumnPanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(3);

		JComboBox<String> tableNameComboBox = addNewColumnPanel.getComboBoxTableNames();
		tableNameComboBox.setSelectedIndex(1);
		
		addNewColumnPanel.getComboBoxColumnType().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType1().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType2().setSelectedIndex(0);
		addNewColumnPanel.getComboBoxColumnType3().setSelectedIndex(0);
		
		addNewColumnPanel.getTextFieldColumnName().setText("Column 1");
		addNewColumnPanel.getTextFieldColumnName1().setText("Column 2");
		addNewColumnPanel.getTextFieldColumnName2().setText("Column 3");
		addNewColumnPanel.getTextFieldColumnName3().setText("Column 4");

		
		List<JTextField> columnTextFields = new ArrayList<JTextField>();
		List<JComboBox> columnsComboBoxes = new ArrayList<JComboBox>();

		Component[] panelColumnComponents = addNewColumnPanel.getPanelColumns().getComponents();
		for (int i = 0; i < panelColumnComponents.length; i++) {
			if (panelColumnComponents[i] instanceof JTextField) {
				columnTextFields.add((JTextField) panelColumnComponents[i]);
			} else if (panelColumnComponents[i] instanceof JComboBox) {
				columnsComboBoxes.add((JComboBox) panelColumnComponents[i]);
			}
		}
		HashMap<String, String> columnsNamesAndTypes = new HashMap<String, String>();
		int completedColumnsNumber = 0;
		for (int i = 0; i < columnTextFields.size(); i++) {
			String columnName = columnTextFields.get(i).getText().trim();
			String columnType = ((String) columnsComboBoxes.get(i).getSelectedItem()).trim();
			if (columnName.length() != 0) {
				columnsNamesAndTypes.put(columnName, columnType);
			}
		}
		String dbName = databaseNamesComboBox.getSelectedItem().toString().trim();
		String tblName = tableNameComboBox.getSelectedItem().toString().trim();
		
		TableImpl mockedTable = mock(TableImpl.class);
		
		when(mockedTable.addNewColumns(dbName, tblName, columnsNamesAndTypes))
				.thenReturn("Table successfully altered");
		
		addNewColumnPanel.setTable(mockedTable);
		
		JButton executeButton = addNewColumnPanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = addNewColumnPanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table successfully altered";

		assertEquals(expectedOutput, resultedOutput);
	}
}
