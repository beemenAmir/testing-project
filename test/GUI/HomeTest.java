/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package GUI;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomeTest {
    Home home;
    public HomeTest() {
    }

    @Before
    public void setUp() throws Exception {
        home = new Home();
    }
    @After
    public void tearDown() throws Exception {
        home = null;
    }
    /*test for the method in the Login button*/
    @Test
    public void testLoginButton() {
        assertTrue(home.loginButton());
    }
    /*test for the method in the Register button*/
    @Test
    public void testRegisterButton() {
       assertTrue(home.registerButton());
        }
    /*Test for the close method*/
    @Test
    public void testClose() {
        assertFalse(home.close());
    }
}
