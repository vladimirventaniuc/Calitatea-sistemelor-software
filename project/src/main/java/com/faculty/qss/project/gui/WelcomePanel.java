/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class WelcomePanel extends javax.swing.JPanel {

    private boolean isCommandLineModeSelected = false;
    private boolean isFriendlyModeSelected = false; 
    
    /**
     * Creates new form WelcomePanel
     */
    public WelcomePanel() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonNextInteractionMode = new javax.swing.JButton();
        labelWelcome = new javax.swing.JLabel();
        radioButtonCommandLineMode = new javax.swing.JRadioButton();
        labelnteractionMode = new javax.swing.JLabel();
        radioButtonUserFriendlyMode = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(495, 300));
        setSize(new java.awt.Dimension(495, 300));

        buttonNextInteractionMode.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonNextInteractionMode.setForeground(new java.awt.Color(102, 0, 0));
        buttonNextInteractionMode.setText("NEXT");
        buttonNextInteractionMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextInteractionModeActionPerformed(evt);
            }
        });

        labelWelcome.setFont(new java.awt.Font("Lucida Grande", 3, 16)); // NOI18N
        labelWelcome.setForeground(new java.awt.Color(51, 0, 102));
        labelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcome.setText("Welcome to DataTools!");

        buttonGroup1.add(radioButtonCommandLineMode);
        radioButtonCommandLineMode.setText("Command-line mode");
        radioButtonCommandLineMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCommandLineModeActionPerformed(evt);
            }
        });

        labelnteractionMode.setForeground(new java.awt.Color(153, 0, 0));
        labelnteractionMode.setText("Select interaction mode:");

        buttonGroup1.add(radioButtonUserFriendlyMode);
        radioButtonUserFriendlyMode.setText("User-friendly mode (selective)");
        radioButtonUserFriendlyMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonUserFriendlyModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNextInteractionMode, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelnteractionMode, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioButtonCommandLineMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioButtonUserFriendlyMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(radioButtonCommandLineMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnteractionMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(radioButtonUserFriendlyMode, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(buttonNextInteractionMode)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonCommandLineModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCommandLineModeActionPerformed
        isCommandLineModeSelected = true;
        isFriendlyModeSelected = false;
    }//GEN-LAST:event_radioButtonCommandLineModeActionPerformed

    private void radioButtonUserFriendlyModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonUserFriendlyModeActionPerformed
        isCommandLineModeSelected = false;
        isFriendlyModeSelected = true;
    }//GEN-LAST:event_radioButtonUserFriendlyModeActionPerformed

    private void buttonNextInteractionModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextInteractionModeActionPerformed
        if( isCommandLineModeSelected){
            this.setVisible(false);
            
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            CommandLineModePanel commandLinePanel = new CommandLineModePanel();
            topFrame.add(commandLinePanel);
            topFrame.pack();
            topFrame.setVisible(true);
        }else if(isFriendlyModeSelected){
            this.setVisible(false);
            
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            UserFriendlyModePanel userfriendlyPanel = new UserFriendlyModePanel();
            topFrame.add(userfriendlyPanel);
            topFrame.pack();
            topFrame.setVisible(true);
        }
    }//GEN-LAST:event_buttonNextInteractionModeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonNextInteractionMode;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JLabel labelnteractionMode;
    private javax.swing.JRadioButton radioButtonCommandLineMode;
    private javax.swing.JRadioButton radioButtonUserFriendlyMode;
    // End of variables declaration//GEN-END:variables
}
