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
import com.thelinh.controller.Controller;
import com.thelinh.controller.LoadTable;
import com.thelinh.model.Subject;
import com.thelinh.model.User;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author hoangkien
 */
public class UpdateUser extends javax.swing.JFrame {

    String sql = "SELECT * FROM Users ORDER BY UserId ASC";
    private static PreparedStatement ps = null;
    int k = 1;
    /**
     * Creates new form UpdateUser
     */
    public UpdateUser() {
        initComponents();
        LoadTable.loadDataUser(sql, tbUser);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFilterUserId = new javax.swing.JTextField();
        txtFilterName = new javax.swing.JTextField();
        txtFilterBirthday = new javax.swing.JTextField();
        txtFilterPassword = new javax.swing.JTextField();
        txtFilterClass = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnAddFile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbUser = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã người dùng", "Password", "Họ tên", "Ngày sinh", "Lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUser);

        jLabel1.setText("Mã người dùng");

        jLabel2.setText("Họ tên");

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Password");

        jLabel6.setText("Lớp");

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddFile.setText("Thêm File");
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm kiếm theo");

        cbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UserId", "Password", "UserName", "Class", "None", " " }));
        cbUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUserItemStateChanged(evt);
            }
        });

        jButton1.setText("Xuất ra PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFilterUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtFilterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilterBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(txtFilterClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch)
                                .addGap(554, 554, 554))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFilterBirthday, txtFilterClass, txtFilterName, txtFilterPassword, txtFilterUserId});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnAddFile)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilterUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilterClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFilterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFilterBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String sql1 = "SELECT * FROM Users";
        String sql2 = "SELECT * FROM Users WHERE UserId LIKE '%" + txtSearch.getText() + "%'"; 
        String sql3 = "SELECT * FROM Users WHERE Password LIKE '%" + txtSearch.getText() + "%'"; 
        String sql4 = "SELECT * FROM Users WHERE UserName LIKE '%" + txtSearch.getText() + "%'";
        String sql5 = "SELECT * FROM Users WHERE Class LIKE '%" + txtSearch.getText() + "%'";
        
        switch(k){
            case 1:
                LoadTable.loadDataUser(sql2, tbUser);
                break;
            case 2:
                LoadTable.loadDataUser(sql3, tbUser);
                break;
            case 3:
                LoadTable.loadDataUser(sql4, tbUser);
                break;
            case 4:
                LoadTable.loadDataUser(sql5, tbUser);
                break;
            case 5:
                LoadTable.loadDataUser(sql1, tbUser);
                break;
                
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtFilterUserId.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter UserId", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtFilterUserId.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "UserId have to less more than 10 characters", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String sql = "SELECT UserId FROM Users";
            ResultSet rs = LoadTable.Display(sql);
            try {
                while(rs.next()){
                    if(rs.getString("UserId") == txtFilterUserId.getText()){
                        JOptionPane.showMessageDialog(null, "This UserId already exists", "Notification", JOptionPane.INFORMATION_MESSAGE);
 
                    }
                        }
                // xu li chua chuan lam! :(
                Date dt = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(txtFilterBirthday.getText()).getTime());
                User user = new User(txtFilterUserId.getText(), txtFilterPassword.getText(), txtFilterName.getText(), dt, txtFilterClass.getText());
                Controller.insertUser(user);
                btnSearch.doClick();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR");
            } catch (ParseException ex) {
                Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         if(txtFilterUserId.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter UserId", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtFilterUserId.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "UserId have to less more than 10 characters", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int click = JOptionPane.showConfirmDialog(null, "Do you want to edit?");
            if(click == JOptionPane.YES_OPTION){
               
                try {
                    Date dt = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(txtFilterBirthday.getText()).getTime());
                    User user = new User(txtFilterUserId.getText(), txtFilterPassword.getText(), txtFilterName.getText(), dt, txtFilterClass.getText());
                    if(Controller.updateUser(user)){
                        JOptionPane.showMessageDialog(null, "Edit Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "UserId does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    btnSearch.doClick();
                } catch (ParseException ex) {
                    Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        int row = tbUser.getSelectedRow();
        String rowId = (tbUser.getModel().getValueAt(row, 0)).toString();
        
        String sql1 = "SELECT * FROM Users WHERE UserId = '" + rowId + "'";
        ResultSet rs = LoadTable.Display(sql1);
        try {
            if(rs.next()){
                txtFilterUserId.setText(rs.getString("UserId"));
                txtFilterPassword.setText(rs.getString("Password"));
                txtFilterName.setText(rs.getString("UserName"));
                txtFilterBirthday.setText(rs.getString("BirthDay"));
                txtFilterClass.setText(rs.getString("Class"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tbUserMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(txtFilterUserId.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "You have to enter UserId", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(txtFilterUserId.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "UserId have to less more than 10 characters", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int click = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
            if(click == JOptionPane.YES_OPTION){
                if(Controller.deleteUser(txtFilterUserId.getText())){
                    JOptionPane.showMessageDialog(null, "Delete Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "UserId does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
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
                    User user = new User(sheet.getCell(0, i).getContents(), sheet.getCell(1,i).getContents(),
                                          sheet.getCell(2, i).getContents(),Date.valueOf(sheet.getCell(3, i).getContents()),
                                          sheet.getCell(4, i).getContents());
                    Controller.insertUser(user);
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

    private void cbUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUserItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "UserId"){
            k = 1;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "Password"){
            k = 2;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "UserName"){
            k = 3;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "Class"){
            k = 4;
        }
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "None"){
            k = 5;
        }
    }//GEN-LAST:event_cbUserItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                document.add(new Paragraph("\t\t                                                                        KẾT QUẢ TÌM KIẾM NGƯỜI DÙNG\n", rfont));
                switch(k){
                        case 1:                           
                            document.add(new Paragraph("                Tìm kiếm theo mã người dùng : " + txtSearch.getText() + "\n\n", rfont)); 
                            break;    
                        case 2:                          
                            document.add(new Paragraph("                Tìm kiếm theo mật khẩu : " + txtSearch.getText() + "\n\n", rfont)); 
                            break;    
                        case 3:                           
                            document.add(new Paragraph("                Tìm kiếm theo tên người dùng : " + txtSearch.getText() + "\n\n", rfont)); 
                            break;                               
                        case 4:                           
                            document.add(new Paragraph("                Tìm kiếm theo lớp :" + txtSearch.getText() + "\n\n", rfont)); 
                            break;                                                                            
                    }
                PdfPTable table = new PdfPTable(5);
                PdfPCell header1 = new PdfPCell(new Paragraph("UserId", rfont));
                PdfPCell header2 = new PdfPCell(new Paragraph("Password", rfont));
                PdfPCell header3 = new PdfPCell(new Paragraph("UserName", rfont));
                PdfPCell header4 = new PdfPCell(new Paragraph("BirthDay", rfont));
                PdfPCell header5 = new PdfPCell(new Paragraph("Class", rfont));               
                table.addCell(header1);
                table.addCell(header2);
                table.addCell(header3);
                table.addCell(header4);
                table.addCell(header5);
               
                TableModel tableModel = tbUser.getModel();
                for(int i = 0; i < tableModel.getRowCount(); i++){
                        table.addCell(new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 0), rfont)));
                        table.addCell(new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 1), rfont)));
                        table.addCell(new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 2), rfont)));
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        table.addCell(new PdfPCell(new Paragraph(sdf.format(tableModel.getValueAt(i, 3)), rfont)));
                        table.addCell(new PdfPCell(new Paragraph((String) tableModel.getValueAt(i, 4), rfont)));                                      
                }  
                document.add(table);
                document.add(new Paragraph("\n                                                                                          Ha Noi, November 4th, 2016\n", rfont));
                document.add(new Paragraph("                                                                                                    Teacher\n", rfont));
                document.add(new Paragraph("                                                                                                (Signed and Sealed)\n", rfont));
                
                document.close();
                JOptionPane.showMessageDialog(null, "Save success");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddFile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField txtFilterBirthday;
    private javax.swing.JTextField txtFilterClass;
    private javax.swing.JTextField txtFilterName;
    private javax.swing.JTextField txtFilterPassword;
    private javax.swing.JTextField txtFilterUserId;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
