package com.faculty.qss.project.unit.gui.userFriendlyMode.alterTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AddNewColumnPanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AlterTablePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.ChangeTableNamePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.DeleteColumnPanel;

public class AlterTablePanelTest {

	private MainFrame mainFrame;

	private AlterTablePanel alterTablePanel;

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

		alterTablePanel = userFriendlyModePanel.getAlterTablePanel();
	}
	
	@Test
	public void checkIfSelectRadioButtonChangeTableName_RadioGroupSelectsGood() {
		JRadioButton changeTableNameRadioButton = alterTablePanel.getRadioButtonChangeTableName();
		changeTableNameRadioButton.setSelected(true);

		alterTablePanel.setRadioButtonChangeTableName(changeTableNameRadioButton);

		assertEquals(true, changeTableNameRadioButton.isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonAddColumn().isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonDeleteColumn().isSelected());
	}
	
	@Test
	public void checkIfSelectRadioButtonAddNewTableColumn_RadioGroupSelectsGood() {
		JRadioButton addColumnRadioButton = alterTablePanel.getRadioButtonAddColumn();
		addColumnRadioButton.setSelected(true);

		alterTablePanel.setRadioButtonAddColumn(addColumnRadioButton);

		assertEquals(true, addColumnRadioButton.isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonChangeTableName().isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonDeleteColumn().isSelected());
	}
	
	@Test
	public void checkIfSelectRadioButtonDeleteTableColumn_RadioGroupSelectsGood() {
		JRadioButton deleteColumnRadioButton = alterTablePanel.getRadioButtonDeleteColumn();
		deleteColumnRadioButton.setSelected(true);

		alterTablePanel.setRadioButtonDeleteColumn(deleteColumnRadioButton);

		assertEquals(true, deleteColumnRadioButton.isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonAddColumn().isSelected());
		assertEquals(false, alterTablePanel.getRadioButtonChangeTableName().isSelected());
	}
	
	@Test
	public void checkIfClickRadioButtonChangeTableName_ItCreatesChangeTableNamePanel() {
		JRadioButton changeTableNameRadioButton = alterTablePanel.getRadioButtonChangeTableName();
		
		changeTableNameRadioButton.doClick();

		ChangeTableNamePanel changeTableNamePanel = alterTablePanel.getChangeTableNamePanel();
		AddNewColumnPanel addNewColumnPanel = alterTablePanel.getAddNewColumnPanel();
		DeleteColumnPanel deleteColumnPanel = alterTablePanel.getDeleteColumnPanel();

		assertNotNull(changeTableNamePanel);
		assertNull(addNewColumnPanel);
		assertNull(deleteColumnPanel);
	}
	
	@Test
	public void checkIfClickRadioButtonAddNewTableColumn_ItCreatesAddNewColumnPanel() {
		JRadioButton addNewTableColumnRadioButton = alterTablePanel.getRadioButtonAddColumn();
		
		addNewTableColumnRadioButton.doClick();
		
		AddNewColumnPanel addNewColumnPanel = alterTablePanel.getAddNewColumnPanel();
		ChangeTableNamePanel changeTableNamePanel = alterTablePanel.getChangeTableNamePanel();	
		DeleteColumnPanel deleteColumnPanel = alterTablePanel.getDeleteColumnPanel();

		assertNotNull(addNewColumnPanel);
		assertNull(changeTableNamePanel);
		assertNull(deleteColumnPanel);
	}
	
	@Test
	public void checkIfClickRadioButtonDeleteTableColumn_ItCreatesDeleteColumnPanel() {
		JRadioButton deleteTableColumnRadioButton = alterTablePanel.getRadioButtonDeleteColumn();
		
		deleteTableColumnRadioButton.doClick();
		
		DeleteColumnPanel deleteColumnPanel = alterTablePanel.getDeleteColumnPanel();
		AddNewColumnPanel addNewColumnPanel = alterTablePanel.getAddNewColumnPanel();
		ChangeTableNamePanel changeTableNamePanel = alterTablePanel.getChangeTableNamePanel();	

		assertNotNull(deleteColumnPanel);
		assertNull(addNewColumnPanel);
		assertNull(changeTableNamePanel);
	}
}
