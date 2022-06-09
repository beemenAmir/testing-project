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

public class LecturerHomepageTest {
    LecturerHomepage lecturerHomepage;
    public LecturerHomepageTest() {
    }

    @Before
    public void setUp() throws Exception {
        lecturerHomepage = new LecturerHomepage();
    }
    @After
    public void tearDown() throws Exception {
        lecturerHomepage = null;
    }
    /*test for the method in the Logout button*/
    @Test
    public void testLogoutButton() {
        assertTrue(lecturerHomepage.logoutButton());
    }
    // Testing if the labels are updated with lecturer info
    @Test
    public void testChangeLabel() {
        //Lecturer in database
        Login.setID("E123456");
        assertTrue(lecturerHomepage.changeLabel());
        //Lecturer not in database
        Login.setID("2006");
        assertFalse(lecturerHomepage.changeLabel());
    }
    // Testing if table has been filled with courses's resources
    @Test
    public void testUpdateTable() {
        Login.setID("E123456");

        assertTrue(lecturerHomepage.updateTable());
    }
    // Testing if Combobox has been filled with courses
    @Test
    public void testChangeCombobox() {
        assertTrue(lecturerHomepage.changeCombobox());
    }
    /*test for the method in the Grades button*/
    @Test
    public void testGradeButton() {
        assertTrue(lecturerHomepage.gradeButton());
    }
    /*Test for the close method*/
    @Test
    public void testClose() {
        assertFalse(lecturerHomepage.close());
    }
}
