package com.faculty.qss.project.unit.gui.userFriendlyMode;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class UserFriendlyModePanelTest{

	private UserFriendlyModePanel userFriendlyModePanel;

	@Before
	public void setUp() {
		userFriendlyModePanel = new UserFriendlyModePanel();
	}

	@Test
	public void checkIfClickDeleteDatabaseButton_ItCreatesPanelForDeleteDatabaseAndNotOthers() {
		JButton deleteDatabaseButton = userFriendlyModePanel.getButtonDeleteDatabase();

		// Check if before clicking delete database option, the panel was null
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());

		// Click on delete database option
		deleteDatabaseButton.doClick();

		// Check if creates the panel for delete database option
		assertNotNull(userFriendlyModePanel.getDeleteDatabasePanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}

	@Test
	public void checkIfClickCreateDatabaseButton_ItCreatesPanelForCreateDatabaseAndNotOthers() {
		JButton createDatabaseButton = userFriendlyModePanel.getButtonCreateDatabase();

		// Check if before clicking create database option, the panel was null
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());

		// Click on create database option
		createDatabaseButton.doClick();

		// Check if creates the panel for create database option
		assertNotNull(userFriendlyModePanel.getCreateDatabasePanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickCreateTableButton_ItCreatesPanelForCreateTableAndNotOthers() {
		JButton createTableButton = userFriendlyModePanel.getButtonCreateTable();

		// Check if before clicking create table option, the panel was null
		assertNull(userFriendlyModePanel.getCreateTablePanel());

		// Click on create table option
		createTableButton.doClick();

		// Check if creates the panel for create table option
		assertNotNull(userFriendlyModePanel.getCreateTablePanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickDeleteTableButton_ItCreatesPanelForDeleteTableAndNotOthers() {
		JButton deleteTableButton = userFriendlyModePanel.getButtonDeleteTable();

		// Check if before clicking delete table option, the panel was null
		assertNull(userFriendlyModePanel.getDeleteTablePanel());

		// Click on delete table option
		deleteTableButton.doClick();

		// Check if creates the panel for delete table option
		assertNotNull(userFriendlyModePanel.getDeleteTablePanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickAlterTableButton_ItCreatesPanelForAlterTableAndNotOthers() {
		JButton alterTableButton = userFriendlyModePanel.getButtonAlterTable();

		// Check if before clicking alter table option, the panel was null
		assertNull(userFriendlyModePanel.getAlterTablePanel());

		// Click on alter table option
		alterTableButton.doClick();

		// Check if creates the panel for alter table option
		assertNotNull(userFriendlyModePanel.getAlterTablePanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickInsertRecordButton_ItCreatesPanelForInsertRecordAndNotOthers() {
		JButton insertRecordButton = userFriendlyModePanel.getButtonInsertRecord();

		// Check if before clicking insert record option, the panel was null
		assertNull(userFriendlyModePanel.getInsertRecordPanel());

		// Click on insert record option
		insertRecordButton.doClick();

		// Check if creates the panel for insert record option
		assertNotNull(userFriendlyModePanel.getInsertRecordPanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickUpdateRecordButton_ItCreatesPanelForUpdateRecordAndNotOthers() {
		JButton updateRecordButton = userFriendlyModePanel.getButtonUpdateRecord();

		// Check if before clicking update record option, the panel was null
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());

		// Click on update record option
		updateRecordButton.doClick();

		// Check if creates the panel for update record option
		assertNotNull(userFriendlyModePanel.getUpdateRecordPanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
	}
	
	@Test
	public void checkIfClickDeleteRecordButton_ItCreatesPanelForDeleteRecordAndNotOthers() {
		JButton updateRecordButton = userFriendlyModePanel.getButtonDeleteRecord();

		// Check if before clicking delete record option, the panel was null
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());

		// Click on delete record option
		updateRecordButton.doClick();

		// Check if creates the panel for delete record option
		assertNotNull(userFriendlyModePanel.getDeleteRecordPanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getSelectRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
	@Test
	public void checkIfClickSelectRecordsButton_ItCreatesPanelForSelectRecordsAndNotOthers() {
		JButton selectRecordButton = userFriendlyModePanel.getButtonSelectRecords();

		// Check if before clicking select records option, the panel was null
		assertNull(userFriendlyModePanel.getSelectRecordPanel());

		// Click on select records option
		selectRecordButton.doClick();

		// Check if creates the panel for select records option
		assertNotNull(userFriendlyModePanel.getSelectRecordPanel());

		// Check if all other panels are not because just one was selected
		assertNull(userFriendlyModePanel.getAlterTablePanel());
		assertNull(userFriendlyModePanel.getCreateDatabasePanel());
		assertNull(userFriendlyModePanel.getCreateTablePanel());
		assertNull(userFriendlyModePanel.getDeleteDatabasePanel());
		assertNull(userFriendlyModePanel.getDeleteRecordPanel());
		assertNull(userFriendlyModePanel.getDeleteTablePanel());
		assertNull(userFriendlyModePanel.getInsertRecordPanel());
		assertNull(userFriendlyModePanel.getUpdateRecordPanel());
	}
	
//	@Test
//	public void checkIfPressBackButton_SetCurrentToBeInvisibleAndBringsInFrontWelcomePanel() {
//		JButton backButton = userFriendlyModePanel.getButtonBackToWelcomePage();
//		
//		assertNull(userFriendlyModePanel.getWelcomePanel());
//
//		backButton.doClick();
//		
//		assertEquals(false, userFriendlyModePanel.isVisible());
//		assertNotNull(userFriendlyModePanel.getWelcomePanel());		
//	}
}
