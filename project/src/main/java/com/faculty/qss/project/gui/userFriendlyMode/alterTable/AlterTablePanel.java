/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode.alterTable;

/**
 *
 * @author echilaboc
 */
public class AlterTablePanel extends javax.swing.JPanel {

    /**
     * Creates new form AlterTablePanel
     */
    public AlterTablePanel() {
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

        buttonGroupAlterTable = new javax.swing.ButtonGroup();
        radioButtonChangeTableName = new javax.swing.JRadioButton();
        radioButtonDeleteColumn = new javax.swing.JRadioButton();
        radioButtonAddColumn = new javax.swing.JRadioButton();
        radioButtonChangeColumnName = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        panelAlterTableOperation = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(469, 324));
        setSize(new java.awt.Dimension(469, 324));

        buttonGroupAlterTable.add(radioButtonChangeTableName);
        radioButtonChangeTableName.setText("Change table name");
        radioButtonChangeTableName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonChangeTableNameActionPerformed(evt);
            }
        });

        buttonGroupAlterTable.add(radioButtonDeleteColumn);
        radioButtonDeleteColumn.setText("Delete column");
        radioButtonDeleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonDeleteColumnActionPerformed(evt);
            }
        });

        buttonGroupAlterTable.add(radioButtonAddColumn);
        radioButtonAddColumn.setText("Add new column");
        radioButtonAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAddColumnActionPerformed(evt);
            }
        });

        buttonGroupAlterTable.add(radioButtonChangeColumnName);
        radioButtonChangeColumnName.setText("Change column name");
        radioButtonChangeColumnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonChangeColumnNameActionPerformed(evt);
            }
        });

        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane1.setViewportView(textAreaOutput);

        panelAlterTableOperation.setBackground(new java.awt.Color(255, 255, 225));
        panelAlterTableOperation.setPreferredSize(new java.awt.Dimension(462, 159));
        panelAlterTableOperation.setSize(new java.awt.Dimension(462, 159));

        javax.swing.GroupLayout panelAlterTableOperationLayout = new javax.swing.GroupLayout(panelAlterTableOperation);
        panelAlterTableOperation.setLayout(panelAlterTableOperationLayout);
        panelAlterTableOperationLayout.setHorizontalGroup(
            panelAlterTableOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAlterTableOperationLayout.setVerticalGroup(
            panelAlterTableOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioButtonDeleteColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addComponent(radioButtonChangeTableName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonChangeColumnName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioButtonAddColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAlterTableOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonChangeTableName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioButtonChangeColumnName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonDeleteColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioButtonAddColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlterTableOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonChangeTableNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonChangeTableNameActionPerformed
        // TODO add your handling code here:
        panelAlterTableOperation.removeAll();
        panelAlterTableOperation.revalidate();
        panelAlterTableOperation.repaint();

        ChangeTableNamePanel changeTableNamePanel = new ChangeTableNamePanel();
        panelAlterTableOperation.add(changeTableNamePanel);

        panelAlterTableOperation.setVisible(true);
    }//GEN-LAST:event_radioButtonChangeTableNameActionPerformed

    private void radioButtonChangeColumnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonChangeColumnNameActionPerformed
        // TODO add your handling code here:
        panelAlterTableOperation.removeAll();
        panelAlterTableOperation.revalidate();
        panelAlterTableOperation.repaint();

        ChangeColumnNamePanel changeColumnNamePanel = new ChangeColumnNamePanel();
        panelAlterTableOperation.add(changeColumnNamePanel);

        panelAlterTableOperation.setVisible(true);
    }//GEN-LAST:event_radioButtonChangeColumnNameActionPerformed

    private void radioButtonDeleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonDeleteColumnActionPerformed
        // TODO add your handling code here:
        panelAlterTableOperation.removeAll();
        panelAlterTableOperation.revalidate();
        panelAlterTableOperation.repaint();

        DeleteColumnPanel deleteColumnPanel = new DeleteColumnPanel();
        panelAlterTableOperation.add(deleteColumnPanel);

        panelAlterTableOperation.setVisible(true);
    }//GEN-LAST:event_radioButtonDeleteColumnActionPerformed

    private void radioButtonAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAddColumnActionPerformed
        // TODO add your handling code here:
        panelAlterTableOperation.removeAll();
        panelAlterTableOperation.revalidate();
        panelAlterTableOperation.repaint();

        AddNewColumnPanel addNewColumnPanel = new AddNewColumnPanel();
        panelAlterTableOperation.add(addNewColumnPanel);

        panelAlterTableOperation.setVisible(true);
    }//GEN-LAST:event_radioButtonAddColumnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAlterTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAlterTableOperation;
    private javax.swing.JRadioButton radioButtonAddColumn;
    private javax.swing.JRadioButton radioButtonChangeColumnName;
    private javax.swing.JRadioButton radioButtonChangeTableName;
    private javax.swing.JRadioButton radioButtonDeleteColumn;
    private javax.swing.JTextArea textAreaOutput;
    // End of variables declaration//GEN-END:variables
}
