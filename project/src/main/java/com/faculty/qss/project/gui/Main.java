package com.faculty.qss.project.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

//	public static void main(String[] args) throws IOException {
//	QueryReader queryReader = new QueryReader();
//	queryReader.readQuery();
//}

	private JFrame frmDataTool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmDataTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDataTool = new JFrame();
		frmDataTool.setMinimumSize(new Dimension(500, 300));
		frmDataTool.setTitle("Data Tool");
		frmDataTool.setBounds(100, 100, 1000, 500);
		frmDataTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frmDataTool.setContentPane(panel);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 100, 0};
		gbl_panel.rowWeights = new double[] { 0.0, 0.0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		JLabel lblWelcomeToDatatool = new JLabel("Welcome to DataTool!");
		lblWelcomeToDatatool.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWelcomeToDatatool.setAlignmentY(Component.TOP_ALIGNMENT);
		lblWelcomeToDatatool.setPreferredSize(new Dimension(200, 20));
		lblWelcomeToDatatool.setVerticalTextPosition(SwingConstants.TOP);
		lblWelcomeToDatatool.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToDatatool.setMinimumSize(new Dimension(200, 20));
		lblWelcomeToDatatool.setMaximumSize(new Dimension(400, 40));
		lblWelcomeToDatatool.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblWelcomeToDatatool.setForeground(new Color(0, 0, 139));
		lblWelcomeToDatatool.setVerticalAlignment(SwingConstants.TOP);
		lblWelcomeToDatatool.setVerticalTextPosition(SwingConstants.TOP);

		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		gbc_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_title.insets = new Insets(2, 2, 5, 2);
		gbc_title.gridwidth = 4;
		panel.add(lblWelcomeToDatatool, gbc_title);

		JLabel lblInteractionMode = new JLabel("Select interaction mode");
		lblInteractionMode.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblInteractionMode.setAlignmentY(Component.LEFT_ALIGNMENT);
		lblInteractionMode.setPreferredSize(new Dimension(100, 20));
		lblInteractionMode.setHorizontalAlignment(SwingConstants.LEFT);
		lblInteractionMode.setMinimumSize(new Dimension(100, 20));
		lblInteractionMode.setMaximumSize(new Dimension(200, 40));
		lblInteractionMode.setVerticalAlignment(SwingConstants.CENTER);

		GridBagConstraints gbc_interactionMode = new GridBagConstraints();
		gbc_interactionMode.fill = GridBagConstraints.HORIZONTAL;
		gbc_interactionMode.anchor = GridBagConstraints.SOUTH;
		gbc_interactionMode.gridx = 0;
		gbc_interactionMode.gridy = 2;
		gbc_interactionMode.insets = new Insets(2, 10, 2, 5);
		panel.add(lblInteractionMode, gbc_interactionMode);
		gbc_interactionMode.gridx++;

		JButton btnCommandlineMode = new JButton("Command-line mode");
		btnCommandlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnCommandlineMode = new GridBagConstraints();
		gbc_btnCommandlineMode.insets = new Insets(0, 0, 0, 5);
		gbc_btnCommandlineMode.gridx = 1;
		gbc_btnCommandlineMode.gridy = 2;
		panel.add(btnCommandlineMode, gbc_btnCommandlineMode);

		JButton btnFriendlyMode = new JButton("Friendly mode");
		btnFriendlyMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnFriendlyMode = new GridBagConstraints();
		gbc_btnFriendlyMode.insets = new Insets(0, 0, 0, 5);
		gbc_btnFriendlyMode.gridx = 2;
		gbc_btnFriendlyMode.gridy = 2;
		panel.add(btnFriendlyMode, gbc_btnFriendlyMode);

		JPanel panelButtons = new JPanel();
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.rowWeights = new double[] {};
		gbl_panel_buttons.columnWeights = new double[] {};
		panelButtons.setLayout(gbl_panel_buttons);

		GridBagConstraints gbc_selectInteractionMode = new GridBagConstraints();
		gbc_selectInteractionMode.fill = GridBagConstraints.BOTH;
		gbc_selectInteractionMode.anchor = GridBagConstraints.CENTER;
		gbc_selectInteractionMode.gridx = 3;
		gbc_selectInteractionMode.gridy = 2;
		gbc_selectInteractionMode.insets = new Insets(2, 2, 2, 2);
		panel.add(panelButtons, gbc_selectInteractionMode);
		gbc_interactionMode.gridx++;

		frmDataTool.pack();
		frmDataTool.setVisible(true);
	}

}
