/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import GUI.Login;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class LecturerHomepage extends javax.swing.JFrame {

   
    /**
     * Creates new form LecturerHompage
     */
    public LecturerHomepage() {
        initComponents();
        changeLabel();
        changeCombobox();
        updateTable();
    }
      public boolean close(){
        this.dispose();
        return this.isVisible();
    }
      public boolean logoutButton(){
    Home home = new Home();
    home.setVisible(true);
    close();
    return home.isVisible();
    }
    public boolean gradeButton(){
        LecturerGrade lg = new LecturerGrade();
        lg.setVisible(true);
        close();
        return lg.isVisible();

    }
    public String getComboBoxValue(){
        try{
        Connection con1 =DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");

        Statement st = null;
        ResultSet rs = null;
        st = (Statement) con1.createStatement();
        String courseName = ComboBox1.getSelectedItem().toString();
        rs = st.executeQuery("SELECT COURSEID FROM APP.COURSES WHERE COURSENAME ='"+courseName+"'");
        if(rs.next()){
        String courseID = rs.getString(1);
        return courseID;

        }
        
    }catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
        return null;
    }
     
    public boolean updateTable(){
     try{
        Connection con1 =DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");

        Statement st = null;
        ResultSet rs = null;
        st = (Statement) con1.createStatement();
        rs = st.executeQuery("SELECT * FROM APP.RESOURCES");
        String columns[] = { "Course ID", "file path","file name"};
      String data[][] = new String[8][3];
      int i = 0;
      while (rs.next()) {
        String CID = rs.getString(1);
        String Filepath = rs.getString(2);
        String FileName = rs.getString(3);
        data[i][0] = CID;
        data[i][1] = Filepath;
        data[i][2] = FileName;
        i++;
      }
      
       DefaultTableModel model = new DefaultTableModel(data, columns);
       jTable1.setModel(model);
       jTable1.setShowGrid(true);
       jTable1.setShowVerticalLines(true);
       
       return jTable1.getRowCount()!= 0;
        }catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
     return false;
     }
    public boolean changeLabel(){
    try{
        String ID =Login.getID();
        Connection con1 =DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");
        Statement st = null;
        ResultSet rs = null;
        st = (Statement) con1.createStatement();
        rs = st.executeQuery("SELECT LECTURERNAME FROM APP.LECTURER WHERE LECTURERID = '"+ ID +"'");
        if(rs.next()){
        String lecturerName = rs.getString(1);
        lecturerNameTxt.setText(lecturerName);
         return !"".equals( lecturerNameTxt.getText());

        }
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      
    
        }
    return false;
    }
    boolean changeCombobox(){
        try{
        Connection con1 =DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");
        Statement st = null;
        ResultSet rs = null;
        st = (Statement) con1.createStatement();
        rs = st.executeQuery("SELECT COURSENAME FROM APP.COURSES");
        while(rs.next()){
        String courseName = rs.getString(1);
        ComboBox1.addItem(courseName);
         return ComboBox1.getSelectedIndex() != -1;
        
        }
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      
    
        }
        return false;
    
    }
    public boolean uploadButton(){
     try{
       Connection con1 =DriverManager.getConnection("jdbc:derby://localhost:1527/LMS","bebo","bebo");
        Statement st = null;
        st = (Statement) con1.createStatement();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        File l = new File(f.getAbsolutePath());
        String fileIn = l.getName();
        String path = "../src/resources/"+ fileIn +"";
        l.renameTo(new File(path));
        String courseID = getComboBoxValue();
        st.executeUpdate("INSERT INTO APP.RESOURCES (COURSEID_FK, FILEPATH, FILENAME) VALUES('"+courseID+"','"+path+"','"+fileIn+"')");
        return updateTable();
        
       
        
        
    }catch (SQLException ex) {
     Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      
    
        } 
     return false;
    }
public boolean gradesButton(){
    LecturerGrade g = new LecturerGrade();
       g.setVisible(true);
       close();
       return g.isVisible();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lecturerNameTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        lecturerNameTxt.setText("name");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lecturerNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(lecturerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("upload files");

        jLabel3.setText("please select a subject from the select field to upload files");

        jButton2.setText("upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("grades");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton21.setText("logout");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton21)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jButton21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)))))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   uploadButton();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
gradesButton();   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        logoutButton(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lecturerNameTxt;
    // End of variables declaration//GEN-END:variables
}
