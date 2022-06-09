/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GUI;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevin
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    Register register;
    @Before
    public void setUp() {
        register = new Register();
    }
    
    @After
    public void tearDown() {
        register = null;
    }

    /**
     * Test of getIDTxt method, of class Register.
     */
  
    @Test
    public void testClose() {
        assertFalse(register.close());
        
    }

    /**
     * Test of registerButton method, of class Register for students register.
     */
    @Test
    public void testStudentRegisterButton() {
       register.setNameTxt("test");
       register.setIDTxt("1235641");
       register.setPasswordTxt("password");
       assertTrue(register.registerButton());
    }
       @Test
    public void testFalseStudentRegisterButton() {
       register.setNameTxt("beemen amir");
       register.setIDTxt("1808322");
       register.setPasswordTxt("1234567");
       assertFalse(register.registerButton());
    }
    @Test
    public void testLecturerRegisterButton() {
       register.selectComboBoxItem(1);
       register.setNameTxt("test");
       register.setIDTxt("1235641");
       register.setPasswordTxt("password");
       assertTrue(register.registerButton());
    }
        @Test
    public void testFalseLecturerRegisterButton() {
       register.selectComboBoxItem(1);
       register.setNameTxt("a");
       register.setIDTxt("E123456");
       register.setPasswordTxt("1234567");
       assertTrue(register.registerButton());
    }
    /**
     * Test of goBack method, of class Register.
     */
    @Test
    public void testGoBack() {
        assertTrue(register.goBack());
    }
    
}
