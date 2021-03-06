package com.faculty.qss.project.unit.gui;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import com.faculty.qss.project.gui.MainFrame;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.commandLineMode.CommandLineModePanel;
import com.faculty.qss.project.gui.userFriendlyMode.UserFriendlyModePanel;

public class WelcomePanelTest {

	private MainFrame mainFrame;

	private WelcomePanel welcomePanel;

	@Before
	public void setUp() {
		mainFrame = new MainFrame();

		welcomePanel = new WelcomePanel();

		mainFrame.add(welcomePanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	@Test
	public void checkIfSelectRadioButtonCommandLineMode_RadioGroupSelectsGood() {
		// Check radio button for command line mode
		JRadioButton commandLineModeRadioButton = welcomePanel.getRadioButtonCommandLineMode();
		commandLineModeRadioButton.setSelected(true);

		welcomePanel.setRadioButtonCommandLineMode(commandLineModeRadioButton);

		// Get all other radio buttons in order to check their values, that are not
		// selected
		JRadioButton userFriendlyModeRadioButton = welcomePanel.getRadioButtonUserFriendlyMode();

		assertEquals(true, commandLineModeRadioButton.isSelected());
		assertEquals(false, userFriendlyModeRadioButton.isSelected());
	}

	@Test
	public void checkIfSelectRadioButtonUserFriendlyMode_RadioGroupSelectsGood() {
		// Select radio button for user-friendly mode
		JRadioButton userFriendlyModeRadioButton = welcomePanel.getRadioButtonUserFriendlyMode();
		userFriendlyModeRadioButton.setSelected(true);

		// Check that user-friendly mode radio button is selected
		welcomePanel.setRadioButtonUserFriendlyMode(userFriendlyModeRadioButton);
		assertEquals(true, userFriendlyModeRadioButton.isSelected());

		// Get all other radio buttons in order to check their values, that are not
		// selected
		JRadioButton commandLineModeRadioButton = welcomePanel.getRadioButtonCommandLineMode();
		assertEquals(false, commandLineModeRadioButton.isSelected());
	}

	@Test
	public void checkIfClickUserFiendlyModeRadionButton_IsUserFriendlyModeBooleanIsTrue() {
		JRadioButton userFriendlyModeRadioButton = welcomePanel.getRadioButtonUserFriendlyMode();

		// Click on user-friendly mode radio button
		userFriendlyModeRadioButton.doClick();

		// Check that user-friendly mode boolean field is true
		boolean isUserFriendlyModeSelected = welcomePanel.isFriendlyModeSelected();
		assertEquals(true, isUserFriendlyModeSelected);

		// Check that all others booleans fields are false
		boolean isCommandLineModeSelected = welcomePanel.isCommandLineModeSelected();
		assertEquals(false, isCommandLineModeSelected);
	}

	@Test
	public void checkIfClickCommandLineModeRadionButton_IsCommandLineModeBooleanIsTrue() {
		JRadioButton commandLineModeRadioButton = welcomePanel.getRadioButtonCommandLineMode();

		// Click on command line mode radio button
		commandLineModeRadioButton.doClick();

		// Check that command line mode boolean field is true
		boolean isCommandLineModeSelected = welcomePanel.isCommandLineModeSelected();
		assertEquals(true, isCommandLineModeSelected);

		// Check that all others booleans fields are false
		boolean isUserFriendlyModeSelected = welcomePanel.isFriendlyModeSelected();
		assertEquals(false, isUserFriendlyModeSelected);
	}

	@Test
	public void checkIfClickNextButtonAndIsCommandLineModeSelected_ItCreatesCommandLineModePanel() {
		// Set that radio button for command line mode is selected
		welcomePanel.setCommandLineModeSelected(true);

		JButton buttonNextInteractionMode = welcomePanel.getButtonNextInteractionMode();

		// Click on next button
		buttonNextInteractionMode.doClick();

		CommandLineModePanel commandLineModePanel = welcomePanel.getCommandLinePanel();
		UserFriendlyModePanel userFriendlyModePanel = welcomePanel.getUserfriendlyPanel();

		assertNotNull(commandLineModePanel);
		assertNull(userFriendlyModePanel);
	}

	@Test
	public void checkIfClickNextButtonAndIsUserFriendlyModeSelected_ItCreatesUserFriendlyModePanel() {
		// Set that radio button for user-friendly mode is selected
		welcomePanel.setFriendlyModeSelected(true);

		JButton buttonNextInteractionMode = welcomePanel.getButtonNextInteractionMode();

		// Click on next button
		buttonNextInteractionMode.doClick();

		UserFriendlyModePanel userFriendlyModePanel = welcomePanel.getUserfriendlyPanel();
		CommandLineModePanel commandLineModePanel = welcomePanel.getCommandLinePanel();

		assertNotNull(userFriendlyModePanel);
		assertNull(commandLineModePanel);
	}

}
