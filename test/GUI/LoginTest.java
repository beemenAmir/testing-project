/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
     Login login;
        
    public LoginTest() {
    }
    @Before
    public void setUp() {
     login = new Login();
    }
    
    @After
    public void tearDown() {
        login = null;
    }
    @Test
    public void testStudentLoginButton(){
    login.setUsernameText("1808322");
    login.setPasswordText("1234567");
    assertTrue(login.loginButton());
    }

    @Test
    public void testLecturerLoginButton(){
    login.setUsernameText("E123456");
    login.setPasswordText("1234567");
    assertTrue(login.loginButton());
    }
    @Test
    public void testWrongLoginButton(){
    login.setUsernameText("1");
    login.setPasswordText("1");
    assertFalse(login.loginButton());
    }
   
    @Test
    public void testClose() {
    assertFalse(login.close());
    }
    
}
