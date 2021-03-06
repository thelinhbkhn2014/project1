/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.gui;

import com.thelinh.model.ChapSql;
import com.thelinh.model.Question;
import com.thelinh.model.QuestionSql;
import com.thelinh.model.Subject;
import com.thelinh.model.SubjectSql;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoangkien
 */
public class MakeExam extends javax.swing.JFrame {

    private ArrayList<Subject> subjects;
    /**
     * Creates new form MakeExam
     */
    public MakeExam() {
        initComponents();
        this.tbQuestion.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRows = tbQuestion.getSelectedRow();
                if (selectedRows > -1) {
                    int chapterCount = cbChapter.getItemCount();
                    String selectedChapter = (String)tbQuestion.getValueAt(selectedRows, 0);
                    for (int i = 0; i < chapterCount; i++) {
                        if (selectedChapter.equals((String)cbChapter.getItemAt(i))){
                            cbChapter.setSelectedIndex(i);
                            break;
                        }
                    }
                    spLevelHigh.setValue((int)tbQuestion.getValueAt(selectedRows, 1));
                    spLevelMiddle.setValue((int)tbQuestion.getValueAt(selectedRows, 2));
                    spLevelLow.setValue((int)tbQuestion.getValueAt(selectedRows, 3));
                }
            }
        });
        this.btnCancel.setEnabled(false);
        subjects = SubjectSql.getAllSubject();
        for (Subject sub : subjects) {
            this.cbSubject.addItem(sub.getSubjectId().trim() + " - "
                    + sub.getSubjectName().trim());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        cbSubject = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spLevelHigh = new javax.swing.JSpinner();
        spLevelMiddle = new javax.swing.JSpinner();
        spLevelLow = new javax.swing.JSpinner();
        btnCreate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbChapter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuestion = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnSubjectChoice = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tạo đề ngẫu nhiên");

        jLabel1.setText("Môn");

        cbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubjectActionPerformed(evt);
            }
        });

        jLabel2.setText("Số câu khó");

        jLabel3.setText("Số câu trung bình");

        jLabel4.setText("Số câu dễ");

        spLevelHigh.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spLevelHigh.setEnabled(false);

        spLevelMiddle.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spLevelMiddle.setEnabled(false);

        spLevelLow.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spLevelLow.setEnabled(false);

        btnCreate.setText("Xem trước");
        btnCreate.setEnabled(false);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnExit.setText("Đóng");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel5.setText("Chương");

        cbChapter.setEnabled(false);

        tbQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chương", "Số câu khó", "Số câu trung bình", "Số câu dễ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbQuestion);

        btnUpdate.setText("Cập nhật");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSubjectChoice.setText("Chọn");
        btnSubjectChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectChoiceActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbChapter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spLevelHigh)
                                    .addComponent(spLevelMiddle)
                                    .addComponent(spLevelLow)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSubjectChoice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancel)))))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreate, btnExit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubjectChoice)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spLevelHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spLevelMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spLevelLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubjectActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        int rowCount = this.tbQuestion.getRowCount();
        Subject subject = this.subjects.get(this.cbSubject.getSelectedIndex());
        ArrayList<Question> list = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            int chapter = Integer.parseInt((String)this.tbQuestion.getValueAt(i, 0));
            int high = (int) this.tbQuestion.getValueAt(i, 1);
            int middle = (int) this.tbQuestion.getValueAt(i, 2);
            int low = (int) this.tbQuestion.getValueAt(i, 3);
            list.addAll(QuestionSql.getRandomListQuestion(
                    subject.getSubjectId(), chapter, "3", high));
            list.addAll(QuestionSql.getRandomListQuestion(
                    subject.getSubjectId(), chapter, "2", middle));
            list.addAll(QuestionSql.getRandomListQuestion(
                    subject.getSubjectId(), chapter, "1", low));
        }
        Collections.shuffle(list);
        PreviewExam preExam = new PreviewExam(this, true);
        preExam.setQuestionList(list);
        preExam.setSubject(subject);
        preExam.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSubjectChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjectChoiceActionPerformed
        int selected = this.cbSubject.getSelectedIndex();
        this.cbChapter.removeAll();
        this.btnSubjectChoice.setEnabled(false);
        this.cbSubject.setEnabled(false);
        this.cbChapter.setEnabled(true);
        this.btnCancel.setEnabled(true);
        this.spLevelHigh.setEnabled(true);
        this.spLevelMiddle.setEnabled(true);
        this.spLevelLow.setEnabled(true);
        this.btnUpdate.setEnabled(true);
        this.btnCreate.setEnabled(true);
        ArrayList<Integer> chaps = ChapSql.getAllChapsBySubject(
                subjects.get(selected).getSubjectId());
        for (int chap : chaps) {
            this.cbChapter.addItem(String.valueOf(chap));
        }
    }//GEN-LAST:event_btnSubjectChoiceActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String chapter = (String) this.cbChapter.getSelectedItem();
        int tbRows = this.tbQuestion.getRowCount();
        int i;
        for (i = 0; i < tbRows; i++) {
            if (((String) this.tbQuestion.getValueAt(i, 0)).equals(chapter)) {
                break;
            }
        }
        int high = (int) this.spLevelHigh.getValue();
        int middle = (int) this.spLevelMiddle.getValue();
        int low = (int) this.spLevelLow.getValue();
        if (i == tbRows) {
            DefaultTableModel model = (DefaultTableModel) this.tbQuestion.getModel();
            model.addRow(new Object[]{
                chapter, high, middle, low
            });
        } else {
            this.tbQuestion.setValueAt(high, i, 1);
            this.tbQuestion.setValueAt(middle, i, 2);
            this.tbQuestion.setValueAt(low, i, 3);
        }
        this.spLevelHigh.setValue(0);
        this.spLevelLow.setValue(0);
        this.spLevelMiddle.setValue(0);
        if (this.cbChapter.getSelectedIndex() < this.cbChapter.getItemCount() - 1) {
            this.cbChapter.setSelectedIndex(this.cbChapter.getSelectedIndex() + 1);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.btnSubjectChoice.setEnabled(true);
        this.cbSubject.setEnabled(true);
        this.cbChapter.setEnabled(false);
        this.btnCancel.setEnabled(false);
        this.spLevelHigh.setEnabled(false);
        this.spLevelMiddle.setEnabled(false);
        this.spLevelLow.setEnabled(false);
        this.btnUpdate.setEnabled(false);
        this.btnCreate.setEnabled(false);
        this.cbChapter.removeAllItems();
        DefaultTableModel dm = (DefaultTableModel) this.tbQuestion.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubjectChoice;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbChapter;
    private javax.swing.JComboBox<String> cbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JSpinner spLevelHigh;
    private javax.swing.JSpinner spLevelLow;
    private javax.swing.JSpinner spLevelMiddle;
    private javax.swing.JTable tbQuestion;
    // End of variables declaration//GEN-END:variables
}
