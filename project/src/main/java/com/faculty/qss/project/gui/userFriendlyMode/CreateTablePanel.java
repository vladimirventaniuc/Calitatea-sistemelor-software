/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode;

/**
 *
 * @author echilaboc
 */
public class CreateTablePanel extends javax.swing.JPanel {

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEnterTableName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        comboBoxDatabaseNames = new javax.swing.JComboBox<>();
        labelSelectDatabaseName1 = new javax.swing.JLabel();
        textFieldDatabaseName = new javax.swing.JTextField();
        labelEnterColumnNamesAndTypes = new javax.swing.JLabel();
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

        setMinimumSize(new java.awt.Dimension(469, 324));
        setPreferredSize(new java.awt.Dimension(469, 324));
        setSize(new java.awt.Dimension(469, 324));

        labelEnterTableName.setText("<html>Enter table name</html>");

        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane1.setViewportView(textAreaOutput);

        comboBoxDatabaseNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelSelectDatabaseName1.setText("<html>Select the database</html>");

        labelEnterColumnNamesAndTypes.setText("<html>Enter column names <br>and types</html>");

        scrollPaneColumns.setHorizontalScrollBar(null);

        textFieldColumnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColumnNameActionPerformed(evt);
            }
        });

        comboBoxColumnType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textFieldColumnName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColumnName1ActionPerformed(evt);
            }
        });

        comboBoxColumnType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textFieldColumnName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColumnName2ActionPerformed(evt);
            }
        });

        comboBoxColumnType2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textFieldColumnName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColumnName3ActionPerformed(evt);
            }
        });

        comboBoxColumnType3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelColumnsLayout = new javax.swing.GroupLayout(panelColumns);
        panelColumns.setLayout(panelColumnsLayout);
        panelColumnsLayout.setHorizontalGroup(
            panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColumnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColumnsLayout.createSequentialGroup()
                        .addComponent(textFieldColumnName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxColumnType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColumnsLayout.createSequentialGroup()
                        .addComponent(textFieldColumnName1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxColumnType1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColumnsLayout.createSequentialGroup()
                        .addComponent(textFieldColumnName2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxColumnType2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColumnsLayout.createSequentialGroup()
                        .addComponent(textFieldColumnName3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxColumnType3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelColumnsLayout.setVerticalGroup(
            panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColumnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldColumnName)
                    .addComponent(comboBoxColumnType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldColumnName1)
                    .addComponent(comboBoxColumnType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldColumnName2)
                    .addComponent(comboBoxColumnType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColumnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldColumnName3)
                    .addComponent(comboBoxColumnType3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrollPaneColumns.setViewportView(panelColumns);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelEnterColumnNamesAndTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(scrollPaneColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelEnterTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldDatabaseName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSelectDatabaseName1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxDatabaseNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxDatabaseNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSelectDatabaseName1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEnterTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEnterColumnNamesAndTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneColumns, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldColumnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldColumnNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldColumnNameActionPerformed

    private void textFieldColumnName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldColumnName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldColumnName1ActionPerformed

    private void textFieldColumnName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldColumnName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldColumnName2ActionPerformed

    private void textFieldColumnName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldColumnName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldColumnName3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxColumnType;
    private javax.swing.JComboBox<String> comboBoxColumnType1;
    private javax.swing.JComboBox<String> comboBoxColumnType2;
    private javax.swing.JComboBox<String> comboBoxColumnType3;
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
    private javax.swing.JTextField textFieldDatabaseName;
    // End of variables declaration//GEN-END:variables
}