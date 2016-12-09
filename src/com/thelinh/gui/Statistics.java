/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.thelinh.controller.LoadTable;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author Admin
 */
public class Statistics extends javax.swing.JFrame {

    int k = 1;
    /**
     * Creates new form Statistics
     */
    public Statistics() {
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

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReport = new javax.swing.JTextArea();
        btnStatistic = new javax.swing.JButton();
        btnExportReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống kê");

        jLabel2.setText("Thống kê theo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject", "Question", "User", "Result", " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txtReport.setColumns(20);
        txtReport.setRows(5);
        jScrollPane1.setViewportView(txtReport);

        btnStatistic.setText("Thống kê");
        btnStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticActionPerformed(evt);
            }
        });

        btnExportReport.setText("Xuất báo cáo");
        btnExportReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportReport))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStatistic)
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStatistic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportReport)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "Subject"){
            k = 1;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "Question"){
            k = 2;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "User"){
            k = 3;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "Result"){
            k = 4;
        }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticActionPerformed
        if(k == 1){
            this.txtReport.setText("");
            this.txtReport.append("\t\t Thống kê môn học\n");
            String sqlSubject1 = "SELECT Count(SubjectId) AS subjectAll FROM Subjects";
            String sqlSubject2 = "SELECT SubjectId AS subjectChap, Count(*) AS subjectNumber FROM Chaps GROUP BY SubjectId";
            ResultSet rs1 = LoadTable.Display(sqlSubject1);
            ResultSet rs2 = LoadTable.Display(sqlSubject2);
            try {
                if(rs1.next()){
                    this.txtReport.append("Tổng số môn học là " + rs1.getInt("subjectAll") + "\n");
                    
                }
                while(rs2.next()){
                    this.txtReport.append("Tổng số chương của môn " + rs2.getString("subjectChap") + "là " + rs2.getInt("subjectNumber") + "\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(k == 2){
            try {
                this.txtReport.setText("");
                this.txtReport.append("\t\t Thống kê câu hỏi\n");
                String sqlQuestion1 = "SELECT Count(QuestionId) AS questionAll FROM Questions";
                String sqlQuestion2 = "SELECT SubjectId AS subjectName, Count(QuestionId) AS questionSubject FROM Questions GROUP BY SubjectId";
                ResultSet rs1 = LoadTable.Display(sqlQuestion1);
                ResultSet rs2 = LoadTable.Display(sqlQuestion2);
                if(rs1.next()){
                    this.txtReport.append("Tổng số câu hỏi là " + rs1.getInt("questionAll") + "\n");
                }
                while(rs2.next()){
                    this.txtReport.append("Tổng số câu hỏi của môn " + rs2.getString("subjectName") + " là " + rs2.getInt("questionSubject")+ "\n");
                            
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(k == 3){
            try {
                this.txtReport.setText("");
                this.txtReport.append("\t\t Thống kê người dùng\n");
                String sqlUser1 = "SELECT Count(UserId) AS userAll FROM Users";
                String sqlUser2 = "SELECT Class AS className, Count(UserId) AS userClass FROM Users GROUP BY Class";
                ResultSet rs1 = LoadTable.Display(sqlUser1);
                ResultSet rs2 = LoadTable.Display(sqlUser2);
                if(rs1.next()){
                    this.txtReport.append("Tổng số người dùng là " + rs1.getInt("userAll") + "\n");
                }
                while(rs2.next()){
                    this.txtReport.append("Tổng số người dùng của lớp " + rs2.getString("className") + " là " + rs2.getInt("userClass")+ "\n");
                            
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnStatisticActionPerformed

    private void btnExportReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportReportActionPerformed
        Document document = new Document(){};
        try {
            JFileChooser jfc = new JFileChooser("Save File");
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
              //  String content = this.txtReport.getText();
                jfc.setDialogTitle("Save File");
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile());
                PdfWriter.getInstance(document, fos);
//                Font rfont = FontFactory.getFont("resources/fonts/vuArial.ttf", IDENTITY_H, true);
                Font rfont = new Font(BaseFont.createFont("resources/fonts/vuTimesBold.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                document.open();
                document.add(new Paragraph("                                                    TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI", rfont));
                if(k == 1){ 
                    document.add(new Paragraph("\t\t                                                                   THỐNG KÊ MÔN HỌC\n", rfont));
                    String sqlSubject1 = "SELECT Count(SubjectId) AS subjectAll FROM Subjects";
                    String sqlSubject2 = "SELECT Subjects.SubjectName AS subjectChap, Count(*) AS subjectNumber FROM Chaps,Subjects WHERE Chaps.SubjectId = Subjects.SubjectId GROUP BY Subjects.SubjectName";
                    ResultSet rs1 = LoadTable.Display(sqlSubject1);
                    ResultSet rs2 = LoadTable.Display(sqlSubject2);
                    try {
                        if(rs1.next()){
                            document.add(new Paragraph("Tổng số môn học là " + rs1.getInt("subjectAll") + "\n", rfont));         
                        }
                        document.add(new Paragraph("Thống kê số chương của môn học: \n\n", rfont));
                        PdfPTable table = new PdfPTable(2);
                        PdfPCell header1 = new PdfPCell(new Paragraph("Môn học", rfont));
                        PdfPCell header2 = new PdfPCell(new Paragraph("Số chương", rfont));
                        table.addCell(header1);
                        table.addCell(header2);
                        while(rs2.next()){
                            PdfPCell header3 = new PdfPCell(new Paragraph(rs2.getString("subjectChap"), rfont));
                            table.addCell(header3);
                            PdfPCell header4 = new PdfPCell(new Paragraph("" + rs2.getInt("subjectNumber")));
                            table.addCell(header4);
                        }
                        document.add(table);
                    } catch (SQLException ex) {
                        Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(k == 2){
                    try {                       
                        document.add(new Paragraph("\t\t                                                                 THỐNG KÊ CÂU HỎI\n", rfont));
                        String sqlQuestion1 = "SELECT Count(QuestionId) AS questionAll FROM Questions";
                        String sqlQuestion2 = "SELECT SubjectName AS subjectName, Count(QuestionId) AS questionSubject FROM Questions,Subjects WHERE Subjects.SubjectId = Questions.SubjectId GROUP BY Subjects.SubjectName";
                        ResultSet rs1 = LoadTable.Display(sqlQuestion1);
                        ResultSet rs2 = LoadTable.Display(sqlQuestion2);
                        if(rs1.next()){
                            document.add(new Paragraph("Tổng số câu hỏi là " + rs1.getInt("questionAll") + "\n", rfont));
                        }
                        document.add(new Paragraph("Thống kê số câu hỏi của môn học: \n\n", rfont));
                        PdfPTable table = new PdfPTable(2);
                        PdfPCell header1 = new PdfPCell(new Paragraph("Môn học", rfont));
                        PdfPCell header2 = new PdfPCell(new Paragraph("Số câu hỏi", rfont));
                        table.addCell(header1);
                        table.addCell(header2);
                        while(rs2.next()){
                            PdfPCell header3 = new PdfPCell(new Paragraph(rs2.getString("subjectName"), rfont));
                            table.addCell(header3);
                            PdfPCell header4 = new PdfPCell(new Paragraph("" + rs2.getInt("questionSubject")));
                            table.addCell(header4);
                        }
                        document.add(table);
                    } catch (SQLException ex) {
                        Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(k == 3){
                    try {
                        document.add(new Paragraph("\t\t                                                                  THỐNG KÊ NGƯỜI DÙNG\n", rfont));
                        String sqlUser1 = "SELECT Count(UserId) AS userAll FROM Users";
                        String sqlUser2 = "SELECT Class AS className, Count(UserId) AS userClass FROM Users GROUP BY Class";
                        ResultSet rs1 = LoadTable.Display(sqlUser1);
                        ResultSet rs2 = LoadTable.Display(sqlUser2);
                        if(rs1.next()){
                            document.add(new Paragraph("Tổng số người dùng là " + rs1.getInt("userAll") + "\n", rfont));
                        }
                        document.add(new Paragraph("Thống kê số học sinh của lớp: \n\n", rfont));
                        PdfPTable table = new PdfPTable(2);
                        PdfPCell header1 = new PdfPCell(new Paragraph("Lớp", rfont));
                        PdfPCell header2 = new PdfPCell(new Paragraph("Số học sinh", rfont));
                        table.addCell(header1);
                        table.addCell(header2);
                        while(rs2.next()){
                            PdfPCell header3 = new PdfPCell(new Paragraph(rs2.getString("className"), rfont));
                            table.addCell(header3);
                            PdfPCell header4 = new PdfPCell(new Paragraph("" + rs2.getInt("userClass")));
                            table.addCell(header4);
                        }
                        document.add(table);
                        } catch (SQLException ex) {
                            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                else if(k == 4){
                    document.add(new Paragraph("\t\t                                                                        THỐNG KÊ KẾT QUẢ\n", rfont));
                    String sqlResult1 = "SELECT Count(*) AS resultAll FROM Results";
                    String sqlResult2 = "SELECT Count(*) AS exam1 FROM Results WHERE Result <= 4";
                    String sqlResult3 = "SELECT Count(*) AS exam2 FROM Results WHERE Result > 4 AND Result < 6";
                    String sqlResult4 = "SELECT Count(*) AS exam3 FROM Results WHERE Result >= 6 AND Result < 8";
                    String sqlResult5 = "SELECT Count(*) AS exam4 FROM Results WHERE Result >= 8";
                    ResultSet rs1 = LoadTable.Display(sqlResult1);
                    ResultSet rs2 = LoadTable.Display(sqlResult2);
                    ResultSet rs3 = LoadTable.Display(sqlResult3);
                    ResultSet rs4 = LoadTable.Display(sqlResult4);
                    ResultSet rs5 = LoadTable.Display(sqlResult5); 
                    if(rs1.next()){
                        document.add(new Paragraph("Tổng số bài thi là " + rs1.getInt("resultAll") + "\n", rfont));
                    }
                    document.add(new Paragraph("Thống kê điểm thi: \n\n", rfont));
                    PdfPTable table = new PdfPTable(2);
                    PdfPCell header1 = new PdfPCell(new Paragraph("Điểm", rfont));
                    PdfPCell header2 = new PdfPCell(new Paragraph("Số bài thi", rfont));
                    table.addCell(header1);
                    table.addCell(header2);
                    PdfPCell header3 = new PdfPCell(new Paragraph("<= 4"));
                    table.addCell(header3);
                    if(rs2.next()){
                        PdfPCell header4 = new PdfPCell(new Paragraph(rs2.getInt("exam1")));
                        table.addCell(header4);
                    }
                    PdfPCell header5 = new PdfPCell(new Paragraph("> 4 và < 6"));
                    table.addCell(header5);
                    if(rs3.next()){
                        PdfPCell header6 = new PdfPCell(new Paragraph(rs3.getInt("exam2")));
                        table.addCell(header6);
                    }
                    PdfPCell header7 = new PdfPCell(new Paragraph(">= 6 và < 8"));
                    table.addCell(header7);
                    if(rs4.next()){
                        PdfPCell header8 = new PdfPCell(new Paragraph(rs4.getInt("exam3")));
                        table.addCell(header8);
                    }
                    PdfPCell header9 = new PdfPCell(new Paragraph(">= 8"));
                    table.addCell(header9);
                    if(rs5.next()){
                        PdfPCell header10 = new PdfPCell(new Paragraph(rs5.getInt("exam4")));
                        table.addCell(header10);
                    }
                    document.add(table);
                }
                document.add(new Paragraph("                                                                                                  Hà Nội, ngày 09 tháng 12 năm 2016\n", rfont));
                document.add(new Paragraph("                                                                                                               Giáo Viên\n",rfont));
                document.add(new Paragraph("                                                                                                          (Ký và ghi rõ họ tên)\n", rfont));
                
                document.close();
                JOptionPane.showMessageDialog(null, "Save success");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportReportActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportReport;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReport;
    // End of variables declaration//GEN-END:variables
}
