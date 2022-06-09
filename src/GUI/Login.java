/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author kevin
 */
public class Login extends javax.swing.JFrame {
    
    
    public static String ID;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    public static void setID(String id) {
        Login.ID = id;
    }
    public static String getID(){
    return ID;
    }
    public boolean close(){
    this.setVisible(false);
    return this.isVisible();
    }
    public void setUsernameText(String text){
    userNameTxt.setText(text);
    }
    public void setPasswordText(String text){
    passwordTxt.setText(text);
    }
    public boolean loginButton(){
     String userName = userNameTxt.getText();
        String password = passwordTxt.getText();
        Connection con1;
        ResultSet rs = null;
        ResultSet res = null;
        Statement st = null;
        Statement stat = null;
        
        try{
            int log = 1;
            int logi = 1;
            con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");
            st = (Statement) con1.createStatement();
            stat = (Statement) con1.createStatement();
            rs = st.executeQuery("SELECT STUDENTID, PASSWORD FROM APP.STUDENTS");
            res = stat.executeQuery("SELECT LECTURERID, PASSWORD FROM APP.LECTURER");
            while(rs.next()){
             if (rs.getString(1).equals(userName) && rs.getString(2).equals(password)){
                 log = 0;
                 ID = rs.getString(1);
                 break;
             }
            }
            while(res.next()){
             if (res.getString(1).equals(userName) && res.getString(2).equals(password)){
                 logi = 0;
                 ID = res.getString(1);
                 break;
             }
            }
            if(log ==0){
               StudentHomepage h = new StudentHomepage();
               h.setVisible(true);
               close();
               return h.isVisible();

            }else if(logi ==0){
            LecturerHomepage l = new LecturerHomepage();
            l.setVisible(true);
            close();
            return l.isVisible();

            }else{
            JOptionPane.showConfirmDialog(null,"please enter a valid username and password", "Login", JOptionPane.DEFAULT_OPTION);
            return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    
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

        jLabel5 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("login");

        jLabel5.setText("username");

        userNameTxt.setText("please enter a username");
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });

        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });

        jLabel6.setText("password");

        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordTxt)
                    .addComponent(userNameTxt)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton3)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    loginButton();        
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userNameText;
    private javax.swing.JTextField userNameText1;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}