/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.comands.Interfaces.Database;
import com.faculty.qss.project.comands.Interfaces.Table;

/**
 *
 * @author echilaboc
 */
public class CreateTablePanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1677336359594936351L;

	private final String[] columnTypes = new String[] { "String", "Integer", "Long", "Double" };

	/**
	 * Creates new form CreateTablePanel
	 */
	public CreateTablePanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		labelEnterTableName = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		textAreaOutput = new javax.swing.JTextArea();
		comboBoxDatabaseNames = new javax.swing.JComboBox<>();
		labelSelectDatabaseName1 = new javax.swing.JLabel();
		textFieldTableName = new javax.swing.JTextField();
		labelEnterColumnNamesAndTypes = new javax.swing.JLabel();
		buttonClearData = new javax.swing.JButton();
		buttonExecuteCommand = new javax.swing.JButton();
		scrollPaneColumns = new javax.swing.JScrollPane();
		panelColumns = new javax.swing.JPanel();
		textFieldColumnName = new javax.swing.JTextField();
		comboBoxColumnType = new javax.swing.JComboBox<>();
		textFieldColumnName1 = new javax.swing.JTextField();
		comboBoxColumnType1 = new javax.swing.JComboBox<>();
		textFieldColumnName2 = new javax.swing.JTextField();
		comboBoxColumnType2 = new javax.swing.JComboBox<>();
		textFieldColumnName3 = new javax.swing.JTextField();
		comboBoxColumnType3 = new javax.swing.JComboBox<>();
		textFieldColumnName4 = new javax.swing.JTextField();
		comboBoxColumnType4 = new javax.swing.JComboBox<>();
		textFieldColumnName5 = new javax.swing.JTextField();
		comboBoxColumnType5 = new javax.swing.JComboBox<>();
		textFieldColumnName6 = new javax.swing.JTextField();
		comboBoxColumnType6 = new javax.swing.JComboBox<>();
		textFieldColumnName7 = new javax.swing.JTextField();
		comboBoxColumnType7 = new javax.swing.JComboBox<>();
		textFieldColumnName8 = new javax.swing.JTextField();
		comboBoxColumnType8 = new javax.swing.JComboBox<>();
		textFieldColumnName9 = new javax.swing.JTextField();
		comboBoxColumnType9 = new javax.swing.JComboBox<>();

		setMinimumSize(new java.awt.Dimension(469, 369));
		setPreferredSize(new java.awt.Dimension(469, 369));
		setSize(new java.awt.Dimension(469, 369));

		labelEnterTableName.setText("<html>Enter table name</html>");

		textAreaOutput.setEditable(false);
		textAreaOutput.setColumns(20);
		textAreaOutput.setRows(5);
		jScrollPane1.setViewportView(textAreaOutput);

		comboBoxDatabaseNames.setModel(new javax.swing.DefaultComboBoxModel<>(getAllDatabaseNames()));

		labelSelectDatabaseName1.setText("<html>Select the database</html>");

		labelEnterColumnNamesAndTypes.setText("<html>Enter column names <br>and types</html>");

		buttonClearData.setForeground(new java.awt.Color(153, 153, 0));
		buttonClearData.setText("Clear");
		buttonClearData.setMaximumSize(new java.awt.Dimension(68, 27));
		buttonClearData.setMinimumSize(new java.awt.Dimension(68, 27));
		buttonClearData.setPreferredSize(new java.awt.Dimension(68, 27));
		buttonClearData.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonClearDataActionPerformed(evt);
			}
		});

		buttonExecuteCommand.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		buttonExecuteCommand.setForeground(new java.awt.Color(0, 102, 0));
		buttonExecuteCommand.setText("Execute");
		buttonExecuteCommand.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonExecuteCommandActionPerformed(evt);
			}
		});

		scrollPaneColumns.setHorizontalScrollBar(null);

		comboBoxColumnType.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType1.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType2.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType3.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType4.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType5.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType6.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType7.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType8.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		comboBoxColumnType9.setModel(new javax.swing.DefaultComboBoxModel<>(columnTypes));

		javax.swing.GroupLayout panelColumnsLayout = new javax.swing.GroupLayout(panelColumns);
		panelColumns.setLayout(panelColumnsLayout);
		panelColumnsLayout.setHorizontalGroup(panelColumnsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelColumnsLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(panelColumnsLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(textFieldColumnName, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addComponent(textFieldColumnName1).addComponent(textFieldColumnName2)
						.addComponent(textFieldColumnName3).addComponent(textFieldColumnName4)
						.addComponent(textFieldColumnName5).addComponent(textFieldColumnName6)
						.addComponent(textFieldColumnName7).addComponent(textFieldColumnName8)
						.addComponent(textFieldColumnName9))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(comboBoxColumnType, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType2, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType3, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType4, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType5, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType6, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType7, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType8, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxColumnType9, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12)));
		panelColumnsLayout.setVerticalGroup(panelColumnsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelColumnsLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName).addComponent(comboBoxColumnType,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName1).addComponent(comboBoxColumnType1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName2).addComponent(comboBoxColumnType2,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName3).addComponent(comboBoxColumnType3,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName4).addComponent(comboBoxColumnType4,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName5).addComponent(comboBoxColumnType5,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName6).addComponent(comboBoxColumnType6,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName7).addComponent(comboBoxColumnType7,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName8).addComponent(comboBoxColumnType8,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textFieldColumnName9).addComponent(comboBoxColumnType9,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(8, 8, 8)));

		scrollPaneColumns.setViewportView(panelColumns);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(buttonExecuteCommand))
						.addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addComponent(labelSelectDatabaseName1, javax.swing.GroupLayout.PREFERRED_SIZE,
												134, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(comboBoxDatabaseNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(labelEnterTableName,
														javax.swing.GroupLayout.PREFERRED_SIZE, 134,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(labelEnterColumnNamesAndTypes,
														javax.swing.GroupLayout.PREFERRED_SIZE, 134,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addGap(6, 6, 6)
																.addComponent(scrollPaneColumns))
												.addComponent(textFieldTableName))))))
						.addGap(25, 25, 25)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(22, 22, 22)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(labelSelectDatabaseName1).addComponent(comboBoxDatabaseNames))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(textFieldTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(labelEnterTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(8, 8, 8)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(labelEnterColumnNamesAndTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 89, Short.MAX_VALUE))
						.addComponent(scrollPaneColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonExecuteCommand))
				.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	private void buttonClearDataActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonClearDataActionPerformed
		textAreaOutput.setText("");
		comboBoxDatabaseNames.setSelectedIndex(0);

		textFieldTableName.setText("");

		Component[] panelColumnComponents = panelColumns.getComponents();
		for (int i = 0; i < panelColumnComponents.length; i++) {
			if (panelColumnComponents[i] instanceof JTextField) {
				((JTextField) panelColumnComponents[i]).setText("");
			} else if (panelColumnComponents[i] instanceof JComboBox) {
				((JComboBox) panelColumnComponents[i]).setSelectedIndex(0);
			}
		}
	}// GEN-LAST:event_buttonClearDataActionPerformed

	private void buttonExecuteCommandActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonExecuteCommandActionPerformed
		String dbName = comboBoxDatabaseNames.getSelectedItem().toString().trim();
		String tableName = textFieldTableName.getText();

		if (dbName.contains("Choose database...")) {
			textAreaOutput.setText("You have to select a database name from list");
		} else {
			if (tableName.length() == 0 || tableName.contains(" ")) {
				textAreaOutput.setText("Table name can\'t be empty or to contain spaces.");
			} else {
				List<JTextField> columnTextFields = new ArrayList<JTextField>();
				List<JComboBox> columnsComboBoxes = new ArrayList<JComboBox>();

				Component[] panelColumnComponents = panelColumns.getComponents();
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
						completedColumnsNumber++;
						columnsNamesAndTypes.put(columnName, columnType);
					}
				}

				if (completedColumnsNumber == 0) {
					textAreaOutput.setText("You need to have at least a column created");
				} else {
					Table table = getTable();
					String result = table.createTable(dbName, tableName, columnsNamesAndTypes);
					textAreaOutput.setText(result);
					table = null;
				}
			}
		}
	}// GEN-LAST:event_buttonExecuteCommandActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonClearData;
	private javax.swing.JButton buttonExecuteCommand;
	private javax.swing.JComboBox<String> comboBoxColumnType;
	private javax.swing.JComboBox<String> comboBoxColumnType1;
	private javax.swing.JComboBox<String> comboBoxColumnType2;
	private javax.swing.JComboBox<String> comboBoxColumnType3;
	private javax.swing.JComboBox<String> comboBoxColumnType4;
	private javax.swing.JComboBox<String> comboBoxColumnType5;
	private javax.swing.JComboBox<String> comboBoxColumnType6;
	private javax.swing.JComboBox<String> comboBoxColumnType7;
	private javax.swing.JComboBox<String> comboBoxColumnType8;
	private javax.swing.JComboBox<String> comboBoxColumnType9;
	private javax.swing.JComboBox<String> comboBoxDatabaseNames;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel labelEnterColumnNamesAndTypes;
	private javax.swing.JLabel labelEnterTableName;
	private javax.swing.JLabel labelSelectDatabaseName1;
	private javax.swing.JPanel panelColumns;
	private javax.swing.JScrollPane scrollPaneColumns;
	private javax.swing.JTextArea textAreaOutput;
	private javax.swing.JTextField textFieldColumnName;
	private javax.swing.JTextField textFieldColumnName1;
	private javax.swing.JTextField textFieldColumnName2;
	private javax.swing.JTextField textFieldColumnName3;
	private javax.swing.JTextField textFieldColumnName4;
	private javax.swing.JTextField textFieldColumnName5;
	private javax.swing.JTextField textFieldColumnName6;
	private javax.swing.JTextField textFieldColumnName7;
	private javax.swing.JTextField textFieldColumnName8;
	private javax.swing.JTextField textFieldColumnName9;
	private javax.swing.JTextField textFieldTableName;

	private Table table;
	// End of variables declaration//GEN-END:variables

	private String[] getAllDatabaseNames() {
		Database database = new DatabaseImpl();
		List<String> dbNames;
		try {
			dbNames = database.getAllDabaseNames();
			for (int i = 0; i < dbNames.size(); i++) {
				if (dbNames.get(i).equals(".DS_Store")) {
					dbNames.remove(i);
				}
			}
			dbNames.add(0, "Choose database...");
		} catch (Exception e) {
			dbNames = new ArrayList<String>();
			dbNames.add(0, "Choose database...");
		}
		String[] temp = dbNames.toArray(new String[dbNames.size()]);
		return temp;
	}

	public Table getTable() {
		if (table == null) {
			return new TableImpl();
		} else {
			return table;
		}
	}

	public void setTable(Table tbl) {
		table = tbl;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType() {
		return comboBoxColumnType;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType1() {
		return comboBoxColumnType1;
	}
	
	public javax.swing.JComboBox<String> getComboBoxColumnType2() {
		return comboBoxColumnType2;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType3() {
		return comboBoxColumnType3;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType4() {
		return comboBoxColumnType4;
	}
	
	public javax.swing.JComboBox<String> getComboBoxColumnType5() {
		return comboBoxColumnType5;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType6() {
		return comboBoxColumnType6;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType7() {
		return comboBoxColumnType7;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType8() {
		return comboBoxColumnType8;
	}

	public javax.swing.JComboBox<String> getComboBoxColumnType9() {
		return comboBoxColumnType9;
	}
	
	public javax.swing.JTextField getTextFieldColumnName() {
		return textFieldColumnName;
	}

	public javax.swing.JTextField getTextFieldColumnName1() {
		return textFieldColumnName1;
	}

	public javax.swing.JTextField getTextFieldColumnName2() {
		return textFieldColumnName2;
	}

	public javax.swing.JTextField getTextFieldColumnName3() {
		return textFieldColumnName3;
	}

	public javax.swing.JTextField getTextFieldColumnName4() {
		return textFieldColumnName4;
	}

	public javax.swing.JTextField getTextFieldColumnName5() {
		return textFieldColumnName5;
	}

	public javax.swing.JTextField getTextFieldColumnName6() {
		return textFieldColumnName6;
	}

	public javax.swing.JTextField getTextFieldColumnName7() {
		return textFieldColumnName7;
	}

	public javax.swing.JTextField getTextFieldColumnName8() {
		return textFieldColumnName8;
	}

	public javax.swing.JTextField getTextFieldColumnName9() {
		return textFieldColumnName9;
	}

	public javax.swing.JButton getButtonClearData() {
		return buttonClearData;
	}

	public javax.swing.JButton getButtonExecuteCommand() {
		return buttonExecuteCommand;
	}

	public javax.swing.JComboBox<String> getComboBoxDatabaseNames() {
		return comboBoxDatabaseNames;
	}

	public javax.swing.JTextArea getTextAreaOutput() {
		return textAreaOutput;
	}

	public javax.swing.JTextField getTextFieldTableName() {
		return textFieldTableName;
	}

	public javax.swing.JPanel getPanelColumns() {
		return panelColumns;
	}
}
