/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.classController;
import controllers.studentController;
import java.awt.Color;
import models.Student;

/**
 *
 * @author myPC
 */
public class addFrame extends javax.swing.JFrame {
    classController classCTL = new classController();
    studentController stuCTL = new studentController();
    Student studentM = new Student();
    String stID;
    String stName;
    String stBirth;
    String stPhone;
    String stPoint;
    String stPoint_R ;
    String stGender;
    String stClass;

    
    
    /**
     * 
     * Creates new form editFrame
     */
    public addFrame() {
        initComponents();
        inforBonus();
    }
//Ham cai dat bo sung
    public void inforBonus(){
        classCTL.setModelCBB(editClassComboBox);
    }
//Ham dua ve trang thai ban dau
    public void refresh(){
        stID =  String.valueOf(studentM.getStID());
        stName = studentM.getStName();
        stBirth = studentM.getStBirth();//String.valueOf(studentM.getStAge());
        stPhone = String.valueOf(studentM.getStPhone());
        stPoint = String.valueOf(studentM.getStPoint());
        stPoint_R = String.valueOf(studentM.getStPonit_R());
        stGender = String.valueOf(studentM.getStGender());
        stClass = String.valueOf(classCTL.getClassIDInfor(studentM.getStClass()));
        
        messageDLable.setForeground(Color.red);
        idDField.setText(stID);
        birthDField.setText("2001-01-01");
        pointDField.setText("4");
    }
//ham gan gia tri cho model
    public void studentMUpdate(){
        try{
            studentM.setStName(NameDField.getText());
            //Chu y cho tuoi
            studentM.setStBirth(birthDField.getText());
            studentM.setStGender(stuCTL.convertGenderToF(editGenderComboBox.getItemAt(0)));
            studentM.setStPhone(Integer.parseInt(phoneDField.getText()));
            studentM.setStClass(String.valueOf(editClassComboBox.getSelectedItem()));
            studentM.setStPoint(Float.parseFloat(pointDField.getText()));
            studentM.setStPonit_R(point_RDScorllBar.getValue());
        }catch(Exception e){
            messageDLable.setText("Failed! Some information is not correct!");
        }
    }
//Ham lay gia tri scroll
    public void setValueOfPR(){
        int value = point_RDScorllBar.getValue();
        point_RDLabel.setText(String.valueOf(value));
        studentM.setStPonit_R(value);
    }
 //Ham checkNull
    public boolean isNullField(){
        
        if(stID.equals("0") || stName.equals("") || stBirth.equals("0")
                || stPhone.equals("0")){
            return true;
        }
        return false;
    }
 //Ham xu ly nut ADD
    public void addNewStudent(){
        studentMUpdate();
        refresh();
        if(isNullField()){
            messageDLable.setText("Failed! Some information is not correct!");
        }
        else{
            try{
                stuCTL.insertDB(stID, stName, stBirth, stGender, stPhone, Integer.parseInt(stClass), stPoint, stPoint_R);
                messageDLable.setText("Student + " + idDField.getText() + " was added!");
                messageDLable.setForeground(Color.BLUE);
            }catch(Exception e){
                messageDLable.setText("Student + " + idDField.getText() + " was added!");
            }
            int idNext = Integer.parseInt(idDField.getText())+1;
            studentM.setStID(idNext);
            idDField.setText(String.valueOf(idNext));
            NameDField.setText("");
            birthDField.setText("");
            phoneDField.setText("");
            pointDField.setText("");
        }
    }
    /**

     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailLabel = new javax.swing.JLabel();
        NameDField = new javax.swing.JTextField();
        birthDField = new javax.swing.JTextField();
        phoneDField = new javax.swing.JTextField();
        pointDField = new javax.swing.JTextField();
        editGenderComboBox = new javax.swing.JComboBox<>();
        idDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saveBTN = new javax.swing.JButton();
        messageDLable = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        editClassComboBox = new javax.swing.JComboBox<>();
        point_RDScorllBar = new javax.swing.JSlider();
        point_RDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        detailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        detailLabel.setForeground(new java.awt.Color(0, 51, 51));
        detailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailLabel.setText("ADD INFORMATION");

        editGenderComboBox.setEditable(true);
        editGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        idDField.setEnabled(false);

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Birth of day");

        jLabel5.setText("Gender");

        jLabel6.setText("Phone");

        jLabel7.setText("Point");

        saveBTN.setBackground(new java.awt.Color(204, 102, 0));
        saveBTN.setForeground(new java.awt.Color(255, 255, 255));
        saveBTN.setText("ADD");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        messageDLable.setForeground(new java.awt.Color(204, 0, 0));
        messageDLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setText("Point_R");

        jLabel10.setText("Class");

        editClassComboBox.setEditable(true);

        point_RDScorllBar.setValue(0);
        point_RDScorllBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                point_RDScorllBarStateChanged(evt);
            }
        });

        point_RDLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(detailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageDLable, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(point_RDScorllBar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(point_RDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idDField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneDField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthDField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NameDField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(editClassComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(editGenderComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pointDField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(detailLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(point_RDScorllBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(point_RDLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(messageDLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBTN)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        // TODO add your handling code here:
        addNewStudent();
    }//GEN-LAST:event_saveBTNActionPerformed

    private void point_RDScorllBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_point_RDScorllBarStateChanged
        // TODO add your handling code here:
        setValueOfPR();
    }//GEN-LAST:event_point_RDScorllBarStateChanged

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
            java.util.logging.Logger.getLogger(addFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameDField;
    private javax.swing.JTextField birthDField;
    private javax.swing.JLabel detailLabel;
    private javax.swing.JComboBox<String> editClassComboBox;
    private javax.swing.JComboBox<String> editGenderComboBox;
    private javax.swing.JTextField idDField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel messageDLable;
    private javax.swing.JTextField phoneDField;
    private javax.swing.JTextField pointDField;
    private javax.swing.JLabel point_RDLabel;
    private javax.swing.JSlider point_RDScorllBar;
    private javax.swing.JButton saveBTN;
    // End of variables declaration//GEN-END:variables
}
