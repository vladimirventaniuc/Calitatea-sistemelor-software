package com.faculty.qss.project.unit.gui.userFriendlyMode;

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
import com.faculty.qss.project.gui.userFriendlyMode.CreateTablePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class CreateTablePanelTest {

	private MainFrame mainFrame;

	private CreateTablePanel createTablePanel;

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

		JButton createTableButton = userFriendlyModePanel.getButtonCreateTable();

		// Click on create table option
		createTableButton.doClick();

		createTablePanel = userFriendlyModePanel.getCreateTablePanel();
	}

	@Test
	public void checkIfPressClearButton_ItClearsCompletedData() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);

		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		outputTextArea.setText("Output to clear");

		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("table-name-to-clear");
		
		createTablePanel.getComboBoxColumnType().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType1().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType2().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType3().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType4().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType5().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType6().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType7().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType8().setSelectedIndex(1);
		createTablePanel.getComboBoxColumnType9().setSelectedIndex(1);
		
		createTablePanel.getTextFieldColumnName().setText("Column name");
		createTablePanel.getTextFieldColumnName1().setText("Column name");
		createTablePanel.getTextFieldColumnName2().setText("Column name");
		createTablePanel.getTextFieldColumnName3().setText("Column name");
		createTablePanel.getTextFieldColumnName4().setText("Column name");
		createTablePanel.getTextFieldColumnName5().setText("Column name");
		createTablePanel.getTextFieldColumnName6().setText("Column name");
		createTablePanel.getTextFieldColumnName7().setText("Column name");
		createTablePanel.getTextFieldColumnName8().setText("Column name");
		createTablePanel.getTextFieldColumnName9().setText("Column name");

		JButton clearButton = createTablePanel.getButtonClearData();
		clearButton.doClick();

		assertEquals(0, databaseNamesComboBox.getSelectedIndex());
		assertEquals("", outputTextArea.getText());
		assertEquals("", textFieldTableName.getText());

		Component[] panelColumnComponents = createTablePanel.getPanelColumns().getComponents();
		for (int i = 0; i < panelColumnComponents.length; i++) {
			if (panelColumnComponents[i] instanceof JTextField) {
				assertEquals("", ((JTextField) panelColumnComponents[i]).getText());
			} else if (panelColumnComponents[i] instanceof JComboBox) {
				assertEquals(0, ((JComboBox) panelColumnComponents[i]).getSelectedIndex());
			}
		}
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeSelectedADatabaseToBeRemoved() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(0);

		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You have to select a database name from list";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatTableNameCantBeEmpty() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);
		
		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("");

		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table name can\'t be empty or to contain spaces.";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatTableNameCantContainSpaces() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);
		
		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("table with spaces");

		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table name can\'t be empty or to contain spaces.";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButton_ChecksThatHasToBeCreatedAtLeastOneColumn() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);
		
		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("new-tbl");
		
		createTablePanel.getComboBoxColumnType().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType1().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType2().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType3().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType4().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType5().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType6().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType7().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType8().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType9().setSelectedIndex(0);
		
		createTablePanel.getTextFieldColumnName().setText("");
		createTablePanel.getTextFieldColumnName1().setText("");
		createTablePanel.getTextFieldColumnName2().setText("");
		createTablePanel.getTextFieldColumnName3().setText("");
		createTablePanel.getTextFieldColumnName4().setText("");
		createTablePanel.getTextFieldColumnName5().setText("");
		createTablePanel.getTextFieldColumnName6().setText("");
		createTablePanel.getTextFieldColumnName7().setText("");
		createTablePanel.getTextFieldColumnName8().setText("");
		createTablePanel.getTextFieldColumnName9().setText("");

		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "You need to have at least a column created";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndDataIsValidAndTableNotExists_CreatesNewTable() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);
		
		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("new-tbl");
		
		createTablePanel.getComboBoxColumnType().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType1().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType2().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType3().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType4().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType5().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType6().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType7().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType8().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType9().setSelectedIndex(0);
		
		createTablePanel.getTextFieldColumnName().setText("Column 1");
		createTablePanel.getTextFieldColumnName1().setText("Column 2");
		createTablePanel.getTextFieldColumnName2().setText("Column 3");
		createTablePanel.getTextFieldColumnName3().setText("Column 4");
		createTablePanel.getTextFieldColumnName4().setText("Column 5");
		createTablePanel.getTextFieldColumnName5().setText("Column 6");
		createTablePanel.getTextFieldColumnName6().setText("Column 7");
		createTablePanel.getTextFieldColumnName7().setText("Column 8");
		createTablePanel.getTextFieldColumnName8().setText("Column 9");
		createTablePanel.getTextFieldColumnName9().setText("Column 10");

		
		List<JTextField> columnTextFields = new ArrayList<JTextField>();
		List<JComboBox> columnsComboBoxes = new ArrayList<JComboBox>();

		Component[] panelColumnComponents = createTablePanel.getPanelColumns().getComponents();
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
		String newTblName = textFieldTableName.getText();
		
		TableImpl mockedTable = mock(TableImpl.class);
		
		when(mockedTable.createTable(dbName, newTblName, columnsNamesAndTypes))
				.thenReturn("Table successfully created");
		
		createTablePanel.setTable(mockedTable);
		
		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table successfully created";

		assertEquals(expectedOutput, resultedOutput);
	}
	
	@Test
	public void checkIfPressExecuteButtonAndDataIsValidAndTableExists_ItDoesntCreateTheTable() {
		JComboBox<String> databaseNamesComboBox = createTablePanel.getComboBoxDatabaseNames();
		databaseNamesComboBox.setSelectedIndex(1);
		
		JTextField textFieldTableName = createTablePanel.getTextFieldTableName();
		textFieldTableName.setText("cati-tbl");
		
		createTablePanel.getComboBoxColumnType().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType1().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType2().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType3().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType4().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType5().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType6().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType7().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType8().setSelectedIndex(0);
		createTablePanel.getComboBoxColumnType9().setSelectedIndex(0);
		
		createTablePanel.getTextFieldColumnName().setText("Column 1");
		createTablePanel.getTextFieldColumnName1().setText("Column 2");
		createTablePanel.getTextFieldColumnName2().setText("Column 3");
		createTablePanel.getTextFieldColumnName3().setText("Column 4");
		createTablePanel.getTextFieldColumnName4().setText("Column 5");
		createTablePanel.getTextFieldColumnName5().setText("Column 6");
		createTablePanel.getTextFieldColumnName6().setText("Column 7");
		createTablePanel.getTextFieldColumnName7().setText("Column 8");
		createTablePanel.getTextFieldColumnName8().setText("Column 9");
		createTablePanel.getTextFieldColumnName9().setText("Column 10");

		
		List<JTextField> columnTextFields = new ArrayList<JTextField>();
		List<JComboBox> columnsComboBoxes = new ArrayList<JComboBox>();

		Component[] panelColumnComponents = createTablePanel.getPanelColumns().getComponents();
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
		String newTblName = textFieldTableName.getText();
		
		TableImpl mockedTable = mock(TableImpl.class);
		
		when(mockedTable.createTable(dbName, newTblName, columnsNamesAndTypes))
				.thenReturn("Table already exists");
		
		createTablePanel.setTable(mockedTable);
		
		JButton executeButton = createTablePanel.getButtonExecuteCommand();
		executeButton.doClick();
		
		JTextArea outputTextArea = createTablePanel.getTextAreaOutput();
		String resultedOutput = outputTextArea.getText();
		
		String expectedOutput = "Table already exists";

		assertEquals(expectedOutput, resultedOutput);
	}
}
