/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculty.qss.project.gui.userFriendlyMode;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.faculty.qss.project.gui.WelcomePanel;
import com.faculty.qss.project.gui.userFriendlyMode.alterTable.AlterTablePanel;

/**
 *
 * @author admin
 */
public class UserFriendlyModePanel extends javax.swing.JPanel {

    private boolean isButtonCreateDatabaseSelected = false;
    private boolean isButtonDeleteDatabaseSelected = false;
    private boolean isButtonCreateTableSelected = false;
    private boolean isButtonDeleteTableSelected = false;
    private boolean isButtonInsertRecordSelected = false;
    private boolean isButtonDeleteRecordSelected = false;
    private boolean isButtonUpdateRecordSelected = false;
    private boolean isButtonSelectRecordSelected = false;
    private boolean isButtonChangeTableNameSelected = false;
    private boolean isButtonAddColumnSelected = false;
    private boolean isButtonDeleteColumnSelected = false;
    private boolean isButtonChangeColumnNameSelected = false;

    /**
     * Creates new form UserFriendlyModePanel
     */
    public UserFriendlyModePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBackToWelcomePage = new javax.swing.JButton();
        scollPanelMenu = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        buttonCreateDatabase = new javax.swing.JButton();
        buttonCreateTable = new javax.swing.JButton();
        buttonDeleteTable = new javax.swing.JButton();
        buttonAlterTable = new javax.swing.JButton();
        buttonDeleteDatabase = new javax.swing.JButton();
        buttonSelectRecords = new javax.swing.JButton();
        buttonInsertRecord = new javax.swing.JButton();
        buttonUpdateRecord = new javax.swing.JButton();
        buttonDeleteRecord = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(600, 375));
        setPreferredSize(new java.awt.Dimension(600, 375));
        setSize(new java.awt.Dimension(600, 375));

        buttonBackToWelcomePage.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        buttonBackToWelcomePage.setForeground(new java.awt.Color(102, 0, 0));
        buttonBackToWelcomePage.setText("<Back");
        buttonBackToWelcomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToWelcomePageActionPerformed(evt);
            }
        });

        scollPanelMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(204, 255, 204));
        panelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMenu.setToolTipText("");

        buttonCreateDatabase.setBackground(new java.awt.Color(204, 255, 204));
        buttonCreateDatabase.setForeground(new java.awt.Color(19, 3, 248));
        buttonCreateDatabase.setText("<html>Create<br> database</html>");
        buttonCreateDatabase.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonCreateDatabase.setContentAreaFilled(false);
        buttonCreateDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCreateDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateDatabaseActionPerformed(evt);
            }
        });

        buttonCreateTable.setBackground(new java.awt.Color(204, 255, 204));
        buttonCreateTable.setForeground(new java.awt.Color(19, 3, 248));
        buttonCreateTable.setText("<html>Create<br> table</html>");
        buttonCreateTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonCreateTable.setContentAreaFilled(false);
        buttonCreateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateTableActionPerformed(evt);
            }
        });

        buttonDeleteTable.setBackground(new java.awt.Color(204, 255, 204));
        buttonDeleteTable.setForeground(new java.awt.Color(19, 3, 248));
        buttonDeleteTable.setText("<html>Delete<br> table</html>");
        buttonDeleteTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonDeleteTable.setContentAreaFilled(false);
        buttonDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteTableActionPerformed(evt);
            }
        });

        buttonAlterTable.setBackground(new java.awt.Color(204, 255, 204));
        buttonAlterTable.setForeground(new java.awt.Color(19, 3, 248));
        buttonAlterTable.setText("<html>Alter <br>table</html>");
        buttonAlterTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonAlterTable.setContentAreaFilled(false);
        buttonAlterTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAlterTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterTableActionPerformed(evt);
            }
        });

        buttonDeleteDatabase.setBackground(new java.awt.Color(204, 255, 204));
        buttonDeleteDatabase.setForeground(new java.awt.Color(19, 3, 248));
        buttonDeleteDatabase.setText("<html>Delete<br> database</html>");
        buttonDeleteDatabase.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonDeleteDatabase.setContentAreaFilled(false);
        buttonDeleteDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteDatabaseActionPerformed(evt);
            }
        });

        buttonSelectRecords.setBackground(new java.awt.Color(204, 255, 204));
        buttonSelectRecords.setForeground(new java.awt.Color(19, 3, 248));
        buttonSelectRecords.setText("<html>Select <br>record(s)</html>");
        buttonSelectRecords.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonSelectRecords.setContentAreaFilled(false);
        buttonSelectRecords.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSelectRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectRecordsActionPerformed(evt);
            }
        });

        buttonInsertRecord.setBackground(new java.awt.Color(204, 255, 204));
        buttonInsertRecord.setForeground(new java.awt.Color(19, 3, 248));
        buttonInsertRecord.setText("<html>Insert<br> record(s)</html>");
        buttonInsertRecord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonInsertRecord.setContentAreaFilled(false);
        buttonInsertRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonInsertRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertRecordActionPerformed(evt);
            }
        });

        buttonUpdateRecord.setBackground(new java.awt.Color(204, 255, 204));
        buttonUpdateRecord.setForeground(new java.awt.Color(19, 3, 248));
        buttonUpdateRecord.setText("<html>Update<br> record</html>");
        buttonUpdateRecord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonUpdateRecord.setContentAreaFilled(false);
        buttonUpdateRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateRecordActionPerformed(evt);
            }
        });

        buttonDeleteRecord.setBackground(new java.awt.Color(204, 255, 204));
        buttonDeleteRecord.setForeground(new java.awt.Color(19, 3, 248));
        buttonDeleteRecord.setText("<html>Delete <br>record(s)</html>");
        buttonDeleteRecord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonDeleteRecord.setContentAreaFilled(false);
        buttonDeleteRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonDeleteDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(buttonCreateDatabase)
                    .addComponent(buttonCreateTable)
                    .addComponent(buttonDeleteTable)
                    .addComponent(buttonAlterTable)
                    .addComponent(buttonInsertRecord)
                    .addComponent(buttonUpdateRecord)
                    .addComponent(buttonDeleteRecord)
                    .addComponent(buttonSelectRecords))
                .addGap(5, 5, 5))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(buttonCreateDatabase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteDatabase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCreateTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAlterTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonInsertRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdateRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSelectRecords)
                .addContainerGap())
        );

        scollPanelMenu.setViewportView(panelMenu);

        panelContent.setBackground(new java.awt.Color(255, 255, 225));
        panelContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelContent.setSize(new java.awt.Dimension(469, 369));

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scollPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(buttonBackToWelcomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scollPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBackToWelcomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteDatabaseActionPerformed
        unsetBorderForMenuButtons();
        buttonDeleteDatabase.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        DeleteDatabasePanel deleteDatabasePanel = new DeleteDatabasePanel();
        panelContent.add(deleteDatabasePanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonDeleteDatabaseActionPerformed

    private void buttonCreateDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateDatabaseActionPerformed
        unsetBorderForMenuButtons();
        buttonCreateDatabase.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        CreateDatabasePanel createDatabasePanel = new CreateDatabasePanel();
        panelContent.add(createDatabasePanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonCreateDatabaseActionPerformed

    private void buttonCreateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateTableActionPerformed
        unsetBorderForMenuButtons();
        buttonCreateTable.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        CreateTablePanel createTablePanel = new CreateTablePanel();
        panelContent.add(createTablePanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonCreateTableActionPerformed

    private void buttonDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteTableActionPerformed
        unsetBorderForMenuButtons();
        buttonDeleteTable.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        DeleteTablePanel deleteTablePanel = new DeleteTablePanel();
        panelContent.add(deleteTablePanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonDeleteTableActionPerformed

    private void buttonInsertRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertRecordActionPerformed
        unsetBorderForMenuButtons();
        buttonInsertRecord.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        InsertRecordPanel insertRecordPanel = new InsertRecordPanel();
        panelContent.add(insertRecordPanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonInsertRecordActionPerformed

    private void buttonBackToWelcomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackToWelcomePageActionPerformed
        this.setVisible(false);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        WelcomePanel welcomePanel = new WelcomePanel();
        topFrame.add(welcomePanel);
        topFrame.pack();
        topFrame.setVisible(true);
    }//GEN-LAST:event_buttonBackToWelcomePageActionPerformed

    private void buttonAlterTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterTableActionPerformed
        unsetBorderForMenuButtons();
        buttonAlterTable.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        AlterTablePanel alterTablePanel = new AlterTablePanel();
        panelContent.add(alterTablePanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonAlterTableActionPerformed

    private void buttonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateRecordActionPerformed
        unsetBorderForMenuButtons();
        buttonUpdateRecord.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        UpdateRecordPanel updateRecordPanel = new UpdateRecordPanel();
        panelContent.add(updateRecordPanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonUpdateRecordActionPerformed

    private void buttonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteRecordActionPerformed
        unsetBorderForMenuButtons();
        buttonDeleteRecord.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        DeleteRecordPanel deleteRecordPanel = new DeleteRecordPanel();
        panelContent.add(deleteRecordPanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonDeleteRecordActionPerformed

    private void buttonSelectRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectRecordsActionPerformed
        unsetBorderForMenuButtons();
        buttonSelectRecords.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        panelContent.removeAll();
        panelContent.revalidate();
        panelContent.repaint();

        SelectRecordPanel selectRecordPanel = new SelectRecordPanel();
        panelContent.add(selectRecordPanel);

        panelContent.setVisible(true);
    }//GEN-LAST:event_buttonSelectRecordsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterTable;
    private javax.swing.JButton buttonBackToWelcomePage;
    private javax.swing.JButton buttonCreateDatabase;
    private javax.swing.JButton buttonCreateTable;
    private javax.swing.JButton buttonDeleteDatabase;
    private javax.swing.JButton buttonDeleteRecord;
    private javax.swing.JButton buttonDeleteTable;
    private javax.swing.JButton buttonInsertRecord;
    private javax.swing.JButton buttonSelectRecords;
    private javax.swing.JButton buttonUpdateRecord;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scollPanelMenu;
    // End of variables declaration//GEN-END:variables

    private void unsetBorderForMenuButtons() {
        Component[] panelMenuComponents = panelMenu.getComponents();
        for (int i = 0; i < panelMenuComponents.length; i++) {
            if (panelMenuComponents[i] instanceof javax.swing.JButton) {
                JButton button = (JButton) panelMenuComponents[i];
                button.setBorder(BorderFactory.createEtchedBorder());

                panelMenuComponents[i] = button;
            }
        }
    }
}
