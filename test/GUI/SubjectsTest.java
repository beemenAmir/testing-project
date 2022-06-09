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

public class SubjectsTest {
    Subjects subjects;
    public SubjectsTest() {
    }

    @Before
    public void setUp() throws Exception {
        subjects = new Subjects();
    }
    @After
    public void tearDown() throws Exception {
        subjects = null;
    }
    /*test for the method in the Logout button*/
    @Test
    public void testLogoutButton() {
        assertTrue(subjects.logoutButton());
    }
    /*test for the method in the Go Back button*/
    @Test
    public void testGoBackButton() {
        assertTrue(subjects.goBackButton());
    }
    /*Test for the close method*/
    @Test
    public void testClose() {
        assertFalse(subjects.close());
    }
}
