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
public class DeleteDatabasePanel extends javax.swing.JPanel {

    /**
     * Creates new form DeleteDatabasePanel
     */
    public DeleteDatabasePanel() {
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

        labelSelectDatabaseName = new javax.swing.JLabel();
        comboBoxDatabaseNames = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        buttonClearData = new javax.swing.JButton();
        buttonExecuteCommand = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(469, 369));
        setSize(new java.awt.Dimension(469, 369));

        labelSelectDatabaseName.setText("<html>Select database name <br>you want to be deleted</html>");

        comboBoxDatabaseNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane1.setViewportView(textAreaOutput);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonExecuteCommand))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSelectDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(comboBoxDatabaseNames, 0, 248, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxDatabaseNames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSelectDatabaseName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExecuteCommand)
                    .addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClearDataActionPerformed

    private void buttonExecuteCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonExecuteCommandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearData;
    private javax.swing.JButton buttonExecuteCommand;
    private javax.swing.JComboBox<String> comboBoxDatabaseNames;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSelectDatabaseName;
    private javax.swing.JTextArea textAreaOutput;
    // End of variables declaration//GEN-END:variables
}
