/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode;

import com.faculty.qss.project.comands.Implementation.DatabaseImpl;
import com.faculty.qss.project.comands.Interfaces.Database;

/**
 *
 * @author echilaboc
 */
public class CreateDatabasePanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -340391579324209352L;
	
	/**
     * Creates new form CreateDatabasePanel
     */
    public CreateDatabasePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEnterDatabaseName = new javax.swing.JLabel();
        textFieldDatabaseName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        buttonClearData = new javax.swing.JButton();
        buttonExecuteCommand = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(469, 369));
        setSize(new java.awt.Dimension(469, 369));

        labelEnterDatabaseName.setText("<html>Enter the name <br>of the new database</html>");

        textAreaOutput.setEditable(false);
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
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEnterDatabaseName, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldDatabaseName)
                    .addComponent(labelEnterDatabaseName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExecuteCommand)
                    .addComponent(buttonClearData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearDataActionPerformed
        // TODO add your handling code here:
        textFieldDatabaseName.setText("");
        textAreaOutput.setText("");
    }//GEN-LAST:event_buttonClearDataActionPerformed

    private void buttonExecuteCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteCommandActionPerformed
        // TODO add your handling code here:
        String dbName = textFieldDatabaseName.getText();
        if( dbName.length() == 0){
            textAreaOutput.setText("The database name can\'t be empty.");
        }else if(dbName.contains(" ")){
            textAreaOutput.setText("The database name can\'t contain spaces.");
        }else{
            Database database = new DatabaseImpl();
            String returnMessage = database.createDatabase(dbName);
            textAreaOutput.setText(returnMessage);
            database = null;
        }
    }//GEN-LAST:event_buttonExecuteCommandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearData;
    private javax.swing.JButton buttonExecuteCommand;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEnterDatabaseName;
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField textFieldDatabaseName;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getButtonClearData() {
		return buttonClearData;
	}

	public javax.swing.JButton getButtonExecuteCommand() {
		return buttonExecuteCommand;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public javax.swing.JLabel getLabelEnterDatabaseName() {
		return labelEnterDatabaseName;
	}

	public javax.swing.JTextArea getTextAreaOutput() {
		return textAreaOutput;
	}

	public javax.swing.JTextField getTextFieldDatabaseName() {
		return textFieldDatabaseName;
	}
}
