package com.problem2.geolocation.model;

import com.problem2.geolocation.NullListException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AttendTest {

    public AttendTest() {
    }

    @Test
    public void getStudentInClassA() throws NullListException {
        List<Student> studentList = loadStudentFirsTest();
        List<Classroom> classList = loadClassroom();

        Attend attend = new Attend();
        List<Student> studentFound = attend.getStudentInClass(studentList, classList);

        // TO DO: remove this logic from unit test only used to see the results.
        // I understand that the unit tests ares atomic and should not be has logic.
        /*
        System.out.println("----getStudentInClassA----");
        for (Student stu : studentFound) {
            System.out.println(stu.toString());
        }*/

        assertEquals( 3, studentFound.size());
    }

    @Test
    public void getStudentInClassB() throws NullListException {
        List<Student> studentList = loadStudentSecondTest();
        List<Classroom> classList = loadClassroom();

        Attend attend = new Attend();
        List<Student> studentFound = attend.getStudentInClass(studentList, classList);
        Student student = studentFound.get(0);
        Student expectedStudent = new Student("Pam Bam", 34.071523,  -118.441171);

        // TO DO: remove this logic from unit test only used to see the results.
        // I understand that the unit tests ares atomic and should not be has logic.
        /*
        System.out.println("----getStudentInClassB----");
        for (Student stu : studentFound) {
            System.out.println(stu.toString());
        }*/

        assertTrue(expectedStudent.equals(student));
    }

    @Test(expected = NullListException.class)
    public void getStudentInClassC() throws NullListException {
        Attend attend = new Attend();
        List<Student> studentFound = attend.getStudentInClass(null, null);
    }

    private List<Student> loadStudentFirsTest() {
        List<Student> studentList = new ArrayList<>();
        Student stu1 = new Student("John Wilson", 34.069149,  -118.442639);
        Student stu2 = new Student("Jane Graham", 34.069601,  -118.441862);
        Student stu3 = new Student("Pam Bam", 34.071513,  -118.441181);
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        return studentList;
    }

    private List<Classroom> loadClassroom() {
        List<Classroom> classList = new ArrayList<>();
        Classroom class1 = new Classroom("Principles of computational geo-location analysis", 34.069140,  -118.442689);
        Classroom class2 = new Classroom("Sedimentary Petrology", 34.069585,  -118.441878);
        Classroom class3 = new Classroom("Introductory Psycobiology", 34.069742,  -118.441312);
        Classroom class4 = new Classroom("Art of Listening", 34.070223,  -118.440193);
        Classroom class5 = new Classroom("Art Hitory", 34.071528,  -118.441211);
        classList.add(class1);
        classList.add(class2);
        classList.add(class3);
        classList.add(class4);
        classList.add(class5);
        return classList;
    }

    private List<Student> loadStudentSecondTest() {
        List<Student> studentList = new ArrayList<>();
        Student stu1 = new Student("John Wilson", 34.069849,  -118.443539);
        Student stu2 = new Student("Jane Graham", 34.069901,  -118.441562);
        Student stu3 = new Student("Pam Bam", 34.071523,  -118.441171);
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        return studentList;
    }
}