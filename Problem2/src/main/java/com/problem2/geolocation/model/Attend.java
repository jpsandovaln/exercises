package com.problem2.geolocation.model;

import com.problem2.geolocation.common.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Attend Class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class Attend {

    List<Student> studentList;
    List<Classroom> classroomList;
    List<Student> studentFoundList;

    /**
     * Due the classroom has 20m X 20m and the geolocation in on the middle
     * could divide by 2, example: 20 / 2 = 10.0 meters.
     */
    public static final Double CLASSROOM_METER = 10.0;

    /**
     * Constructor
     */
    public Attend() {
    }

    /**
     * Evaluates if a students are on the classroom.
     * @param studentList the students's list.
     * @param classroomList the classrooms's list.
     * @return students's list found into classroom.
     */
    public List<Student> getStudentInClass(List<Student> studentList, List<Classroom> classroomList) {
        studentFoundList = new ArrayList<>();
        for (Student student: studentList) {
            for (Classroom classroom : classroomList) {
                Double distance = Util.getDistanceInMeters(student.getLatitude(), student.getLongitude(),
                        classroom.getLatitude(), classroom.getLongitude());
                if (this.isInClassroom(distance)) {
                    studentFoundList.add(student);
                    break;
                }
            }
        }
        return studentFoundList;
    }

    /**
     * Verifies if the student's distance is over the classroom.
     * @param distance the student's distance
     * @return true if the student  is into classroom.
     */
    private boolean isInClassroom(Double distance) {
        return distance <= CLASSROOM_METER;
    }
}
