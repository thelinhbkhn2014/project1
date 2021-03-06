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
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.thelinh.model.Chap;
import com.thelinh.controller.Controller;
import com.thelinh.controller.LoadTable;
import com.thelinh.model.Subject;
import com.thelinh.model.Connect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Admin
 */
public class UpdateChap extends javax.swing.JFrame {
    
    String sql = "SELECT Subjects.*, Chaps.Chapter, Chaps.ChapterName FROM Chaps, Subjects WHERE Subjects.SubjectId = Chaps.SubjectId";
    private static PreparedStatement ps = null;

    /**
     * Creates new form UpdateChap
     */
    public UpdateChap() {
        initComponents();
        LoadTable.loadDataChap(sql, tbChap);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtChapter = new javax.swing.JTextField();
        txtContent = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnAddFile = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChap = new javax.swing.JTable();
        txtSubjectId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UPDATE CHAP");

        jLabel1.setText("Mã môn học");

        jLabel2.setText("Chương");

        jLabel3.setText("Nội dung chương");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnAddFile.setText("Thêm từ file");
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tbChap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbChap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChap);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nhập mã môn học để tìm kiếm các chương");

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnPdf.setText("Xuất ra PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContent)
                            .addComponent(txtSubjectId)
                            .addComponent(txtChapter)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addGap(83, 83, 83)
                        .addComponent(btnAddFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFile)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String sql1 = "SELECT * FROM Subjects WHERE SubjectId = ?";
        Subject sj = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ps = Connect.getConnect().prepareStatement(sql1);
            ps.setString(1, txtSubjectId.getText());
            rs = ps.executeQuery();
            if(txtSubjectId.getText().length() == 0 || txtChapter.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter SubjectId and Chapter", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(rs.next() == false){
            JOptionPane.showMessageDialog(null, "SubjectId doesn't exist", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String sql2 = "SELECT SubjectId,Chapter FROM Chaps";
            ResultSet rs1 = LoadTable.Display(sql2);
            try {
                while(rs1.next()){
                    if(rs1.getString("SubjectId") == txtSubjectId.getText() && rs1.getInt("Chapter") == Integer.parseInt(txtChapter.getText())){
                        JOptionPane.showMessageDialog(null, "Chapter of Subject already exists", "Notification", JOptionPane.INFORMATION_MESSAGE);
 
                    }
                        }
                // xu li chua chuan lam! :(
                Chap chap = new Chap(txtSubjectId.getText(), Integer.parseInt(txtChapter.getText()), txtContent.getText());
                Controller.insertChap(chap);
                btnSearch.doClick();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR");
                ex.printStackTrace();
            }
        }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void tbChapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChapMouseClicked
        int row = tbChap.getSelectedRow();
        String rowId = (tbChap.getModel().getValueAt(row, 0)).toString();
        String rowId1 = (tbChap.getModel().getValueAt(row, 2)).toString();
        
        String sql1 = "SELECT * FROM Chaps WHERE SubjectId = '" + rowId + "' AND Chapter = " + Integer.parseInt(rowId1);
        ResultSet rs = LoadTable.Display(sql1);
        try {
            if(rs.next()){
                txtSubjectId.setText(rs.getString("SubjectId"));
                txtChapter.setText(String.valueOf(rs.getInt("Chapter")));
                txtContent.setText(rs.getString("ChapterName"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_tbChapMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String sql1 = "SELECT Subjects.*, Chaps.Chapter, Chaps.ChapterName FROM Chaps, Subjects WHERE Subjects.SubjectId = Chaps.SubjectId";
        String sql2 = "SELECT Subjects.*, Chaps.Chapter, Chaps.ChapterName FROM Chaps, Subjects WHERE Chaps.SubjectId LIKE '%" + txtSearch.getText() + "%' AND Subjects.SubjectId LIKE '%" + txtSearch.getText() + "%'";
        if(txtSearch.getText().length() == 0){
            LoadTable.loadDataChap(sql1, tbChap);
        }
        else{
            LoadTable.loadDataChap(sql2, tbChap);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(txtSubjectId.getText().length() == 0 || txtChapter.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter SubjectId and Chapter", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtSubjectId.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "SubjectId have to less more than 10 characters", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int click = JOptionPane.showConfirmDialog(null, "Do you want to edit?");
            if(click == JOptionPane.YES_OPTION){
                Chap chap = new Chap(txtSubjectId.getText(), Integer.parseInt(txtChapter.getText()), txtContent.getText());
                if(Controller.updateChap(chap)){
                    JOptionPane.showMessageDialog(null, "Edit Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "SubjectId does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
                btnSearch.doClick();
            } 
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(txtSubjectId.getText().length() == 0 || txtChapter.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter SubjectId and Chapter", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtSubjectId.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "SubjectId have to less more than 10 characters", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int click = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
            if(click == JOptionPane.YES_OPTION){
                if(Controller.deleteChap(txtSubjectId.getText(), Integer.parseInt(txtChapter.getText()))){
                    JOptionPane.showMessageDialog(null, "Delete Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "SubjectId or Chapter does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
                btnSearch.doClick();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFileActionPerformed
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            jfc.setDialogTitle("Open File");
            File file = jfc.getSelectedFile();
                try {
                Workbook wb = Workbook.getWorkbook(file);
                Sheet sheet = wb.getSheet(0);
                int rows = sheet.getRows();
                int columns = sheet.getColumns();
                for(int i = 0; i < rows; i++){
                    Chap chap = new Chap(sheet.getCell(0, i).getContents(), Integer.parseInt(sheet.getCell(1,i).getContents()), sheet.getCell(2,i).getContents());
                    Controller.insertChap(chap);
                }
                wb.close();
                btnSearch.doClick();
                
                } catch (IOException ex) {
                    System.out.println("File not found\n" + ex.toString());
                } catch (BiffException ex) {
                    ex.printStackTrace();
                }
        }
        
    }//GEN-LAST:event_btnAddFileActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        Document document = new Document() {};
        try {
            JFileChooser jfc = new JFileChooser("Save File");
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                jfc.setDialogTitle("Save File");
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile());
                PdfWriter.getInstance(document, fos);
                document.open();
                Font rfont = FontFactory.getFont("C:\\Windows\\Fonts\\Calibri.ttf", IDENTITY_H, true);
                document.add(new Paragraph("                                                                TRƯỜNG ĐẠI HỌC BÁCH KHOA HÀ NỘI", rfont));
                document.add(new Paragraph("                                                            KẾT QUẢ TÌM KIẾM CÁC CHƯƠNG CỦA MÔN HỌC\n", rfont));
                document.add(new Paragraph("                Tìm kiếm theo mã môn học : " + txtSearch.getText() + "\n\n", rfont));
             
                TableModel tableModel = tbChap.getModel();
                for(int i = 0; i < tableModel.getRowCount(); i++){
                    String subject = (String) tableModel.getValueAt(i, 0) + " : " + (String) tableModel.getValueAt(i, 1) + "\n\n";
                    String id = (String) tableModel.getValueAt(i, 0);
                    String id1 = id;
                    document.add(new Paragraph(subject, rfont));
                    PdfPTable table = new PdfPTable(2);                  
                    PdfPCell header1 = new PdfPCell(new Paragraph("Chapter", rfont));
                    PdfPCell header2 = new PdfPCell(new Paragraph("ChapterName", rfont));
                    table.addCell(header1);
                    table.addCell(header2);
                    while(id.equals(id1) && i < tableModel.getRowCount()){
                        table.addCell(new PdfPCell(new Paragraph(String.valueOf(tableModel.getValueAt(i, 2)), rfont))); 
                        table.addCell(new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 3), rfont)));
                        i++;
                        if(i < tableModel.getRowCount())
                            id1 = (String) tableModel.getValueAt(i, 0);
                    }                  
                    document.add(table);
                    document.add(new Paragraph("\n"));
                                                              
                }  
               
                document.add(new Paragraph("\n                                                                                                      Ha Noi, November 4th, 2016\n", rfont));
                document.add(new Paragraph("                                                                                                                Teacher\n", rfont));
                document.add(new Paragraph("                                                                                                            (Signed and Sealed)\n", rfont));
                
                document.close();
                JOptionPane.showMessageDialog(null, "Save success");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPdfActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateChap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateChap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateChap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateChap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateChap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddFile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbChap;
    private javax.swing.JTextField txtChapter;
    private javax.swing.JTextField txtContent;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSubjectId;
    // End of variables declaration//GEN-END:variables
}
