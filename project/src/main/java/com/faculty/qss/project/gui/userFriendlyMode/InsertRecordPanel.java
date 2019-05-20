/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Implementation.TableImpl;
import com.faculty.qss.project.comands.Interfaces.Database;
import com.faculty.qss.project.comands.Interfaces.Table;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author echilaboc
 */
public class InsertRecordPanel extends javax.swing.JPanel {

    /**
     * Creates new form InsertRecordPanel
     */
    public InsertRecordPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSelectTableName1 = new javax.swing.JLabel();
        comboBoxTableNames = new javax.swing.JComboBox<>();
        labelSelectDatabaseName = new javax.swing.JLabel();
        comboBoxDatabaseNames = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInsert = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        buttonClearData = new javax.swing.JButton();
        buttonExecuteCommand = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(469, 369));
        setSize(new java.awt.Dimension(469, 369));

        labelSelectTableName1.setText("<html>Select the table</html>");

        comboBoxTableNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboBoxTableNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemStateChangedActionPerformedForTable(evt);
            }
        });

        labelSelectDatabaseName.setText("<html>Select the database</html>");

        comboBoxDatabaseNames.setModel(new javax.swing.DefaultComboBoxModel<>(getAllDatabaseNames()));
        comboBoxDatabaseNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemStateChangeActionPerformedForDatabase(evt);
            }
        });

        tableInsert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tableInsert);

        textAreaOutput.setEditable(false);
        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane2.setViewportView(textAreaOutput);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSelectDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxDatabaseNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSelectTableName1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTableNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonExecuteCommand)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelectDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDatabaseNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelectTableName1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTableNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExecuteCommand)
                    .addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearDataActionPerformed
        comboBoxDatabaseNames.setSelectedIndex(0);
        comboBoxTableNames.setModel(new DefaultComboBoxModel<>(new String[]{}));
        
        tableInsert.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "", "", "", ""
                }
        ));
        jScrollPane1.setViewportView(tableInsert);
        
        textAreaOutput.setText("");
    }//GEN-LAST:event_buttonClearDataActionPerformed

    private void buttonExecuteCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteCommandActionPerformed
        String dbName = comboBoxDatabaseNames.getSelectedItem().toString().trim();
        
        assert (!dbName.contains("Choose database...")): "You have to select a database name from list";
        
        String tableName;
        try {
            tableName = comboBoxTableNames.getSelectedItem().toString().trim();
        } catch (Exception e) {
            tableName = "";
        }
        
        assert (!tableName.contains("Choose table...")): "You have to select a table name from list";

        if (dbName.contains("Choose database...")) {
            textAreaOutput.setText("You have to select a database name from list");
        } else if (tableName.contains("Choose table...")) {
            textAreaOutput.setText("You have to select a table name from list");
        } else {
            String[] columnNames = getTableSchemaForDbAndTable(dbName, tableName);

            String result = "";
            table = getTable();
            TableModel tableRecs = tableInsert.getModel();
            for (int row = 0; row < 20; row++) {
                List<String> values = new ArrayList<String>();
                int nonNullVals = 0;
                for (int col = 0; col < columnNames.length; col++) {
                    System.out.println(tableRecs.getValueAt(row, col));
                    values.add((String) tableRecs.getValueAt(row, col));
                    if (tableRecs.getValueAt(row, col) != null) {
                        nonNullVals++;
                    }
                }
                if (nonNullVals != 0) {
                    result += row + ". " + table.insertRecords(dbName, tableName, values) + "\n";
                }
            }
            textAreaOutput.setText(result);
            table = null;
        }
    }//GEN-LAST:event_buttonExecuteCommandActionPerformed

    private void itemStateChangeActionPerformedForDatabase(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemStateChangeActionPerformedForDatabase
        String dbName = (String) comboBoxDatabaseNames.getSelectedItem();
        if (!dbName.equals("Choose database...")) {
            comboBoxTableNames.setModel(new DefaultComboBoxModel<>(getAllTableNamesForDb(dbName)));
        } else {
            comboBoxTableNames.setModel(new DefaultComboBoxModel<>(new String[]{}));

            tableInsert.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String[]{
                        "", "", "", ""
                    }
            ));
            jScrollPane1.setViewportView(tableInsert);
        }
    }//GEN-LAST:event_itemStateChangeActionPerformedForDatabase

    private void itemStateChangedActionPerformedForTable(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemStateChangedActionPerformedForTable
        String dbName = (String) comboBoxDatabaseNames.getSelectedItem();
        String tableName = (String) comboBoxTableNames.getSelectedItem();

        if (!tableName.equals("Choose table...")) {
            tableInsert.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    getTableSchemaForDbAndTable(dbName, tableName)
            ));

            jScrollPane1.setViewportView(tableInsert);
        } else {
            tableInsert.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String[]{
                        "", "", "", ""
                    }
            ));
            jScrollPane1.setViewportView(tableInsert);
        }
    }//GEN-LAST:event_itemStateChangedActionPerformedForTable


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearData;
    private javax.swing.JButton buttonExecuteCommand;
    private javax.swing.JComboBox<String> comboBoxDatabaseNames;
    private javax.swing.JComboBox<String> comboBoxTableNames;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelSelectDatabaseName;
    private javax.swing.JLabel labelSelectTableName1;
    private javax.swing.JTable tableInsert;
    private javax.swing.JTextArea textAreaOutput;
    
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

	public String[] getAllTableNamesForDb(String dbName) {
		Database database = new DatabaseImpl();
		List<String> tableNames = new ArrayList<String>();
		try {
			tableNames = database.getAllTableNamesForDb(dbName);
			for (int i = 0; i < tableNames.size(); i++) {
				if (tableNames.get(i).equals(".DS_Store")) {
					tableNames.remove(i);
				}
			}
			tableNames.add(0, "Choose table...");
		} catch (Exception ex) {
			tableNames = new ArrayList<String>();
			tableNames.add(0, "Choose table...");
		}
		String[] temp = tableNames.toArray(new String[tableNames.size()]);
		return temp;
	}

    private String[] getTableSchemaForDbAndTable(String dbName, String tableName) {
        Table table = new TableImpl();
        List<String> columnNames = table.getTableSchemaForDbAndTable(dbName, tableName);
        String[] temp = columnNames.toArray(new String[columnNames.size()]);
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

	public javax.swing.JButton getButtonClearData() {
		return buttonClearData;
	}

	public javax.swing.JButton getButtonExecuteCommand() {
		return buttonExecuteCommand;
	}

	public javax.swing.JComboBox<String> getComboBoxDatabaseNames() {
		return comboBoxDatabaseNames;
	}

	public javax.swing.JComboBox<String> getComboBoxTableNames() {
		return comboBoxTableNames;
	}

	public javax.swing.JTable getTableInsert() {
		return tableInsert;
	}

	public javax.swing.JTextArea getTextAreaOutput() {
		return textAreaOutput;
	}
}
