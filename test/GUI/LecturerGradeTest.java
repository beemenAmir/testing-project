/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package GUI;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LecturerGradeTest {
    LecturerGrade lecturerGrade;
    public LecturerGradeTest() {
    }

    @Before
    public void setUp() throws Exception{
        lecturerGrade = new LecturerGrade();
    }
    @After
    public void tearDown() throws Exception {
        lecturerGrade = null;
    }
    /*test for the method in the Logout button*/
    @Test
    public void testLogoutButton() {
        assertTrue(lecturerGrade.logoutButton());
    }
    // Testing if the labels are updated with lecturer info
    @Test
    public void testChangeLabel() {
        //Lecturer in database
        Login.setID("E123456");
        assertTrue(lecturerGrade.changeLabel());
        //Lecturer not in database
        Login.setID("2006");
        assertFalse(lecturerGrade.changeLabel());
    }
    // Testing if table has been filled with students' grades
    @Test
    public void testUpdateTable() {
        assertTrue(lecturerGrade.updateTable());
    }
    // Testing the add grades button
    @Test
    public void testAddGradeButton() {
        // True because student has taken the course
        
        lecturerGrade.setCourseText("CSE111");
        lecturerGrade.setStudentText("1808322");
        lecturerGrade.setGradeText("80");
        assertTrue(lecturerGrade.addGradeButton());
        
        // False because student hasn't taken the course
        
        lecturerGrade.setCourseText("CSE111");
        lecturerGrade.setStudentText("189876");
        lecturerGrade.setGradeText("85");
        assertFalse(lecturerGrade.addGradeButton());
    }
    // This test causes an error because no grade is specified when clicking add grades
    @Test
    public void testErrorAddGradeButton() {
        lecturerGrade.setCourseText("CSE111");
        lecturerGrade.setStudentText("1808322");
        assertTrue(lecturerGrade.addGradeButton());
    }
    /*Test for the close method*/
    @Test
    public void testClose() {
        assertFalse(lecturerGrade.close());
    }
    /*Test for the method in the Go Back Button*/
    @Test
    public void testGoBack() {
        Assert.assertTrue(lecturerGrade.goBackButton());
    }
}
