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

public class StudentHomepageTest {
    StudentHomepage studentHomepage;
    public StudentHomepageTest() {
    }

    @Before
    public void setUp() throws Exception {
        studentHomepage = new StudentHomepage();
    }
    @After
    public void tearDown() throws Exception {
        studentHomepage = null;
    }
    // Testing if the labels are updated with student info
    @Test
    public void testChangeLabel() {
        //Student in database
        Login.setID("1808322");
        assertTrue(studentHomepage.changeLabel());
        //Student not in database
        Login.setID("181234");
        assertFalse(studentHomepage.changeLabel());
    }
    // Testing if table has been filled with student's courses
    @Test
    public void testUpdateTable() {
        assertTrue(studentHomepage.updateTable());
    }
    // Testing if student's courses are added to the Combobox
    @Test
    public void testChangeComboBox() {
        //Student with no courses
        Login.setID("1810254");
        assertFalse(studentHomepage.changeCombobox());
        //Student with courses
        Login.setID("1808322");
        assertTrue(studentHomepage.changeCombobox());
    }
    /*test for the method in the Logout button*/
    @Test
    public void testLogoutButton() {
        assertTrue(studentHomepage.logoutButton());
    }
    /*test for the method in the Subjects button*/
    @Test
    public void testSubjectButton() {
        assertTrue(studentHomepage.subjectButton());
    }
    /*Test for the close method*/
    @Test
    public void testClose() {
        assertFalse(studentHomepage.close());
    }
}
