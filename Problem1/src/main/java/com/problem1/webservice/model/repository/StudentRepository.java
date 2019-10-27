package com.problem1.webservice.model.repository;

import com.problem1.webservice.model.entity.Student;
import com.problem1.webservice.response.StudentResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Student repository.
 * @author Paolo Sandoval
 * @version 1.0
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

    /**
     * Gets all students.
     * @return a student list
     */
    @Query("SELECT NEW com.problem1.webservice.response.StudentResponse(s.id, s.firstName, s.lastName) " +
            "FROM Student s")
    List<StudentResponse> findAllStudent();

    /**
     * Gets a student by id.
     * @param id the student's id.
     * @return a student by id.
     */
    @Query("SELECT NEW com.problem1.webservice.response.StudentResponse(s.id, s.firstName, s.lastName) " +
            "FROM Student s WHERE s.id = :id")
    StudentResponse findByStudentId(@Param("id") Long id);

    /**
     * Gets all students bu class id.
     * @param class_id the class's id.
     * @return a students's list on the class.
     */
    @Query("SELECT NEW com.problem1.webservice.response.StudentResponse(s.id, s.firstName, s.lastName) " +
            "FROM Student s JOIN s.classes sc where sc.id = :class_id")
    List<StudentResponse> findAllStudentsByClass(@Param("class_id") Long class_id);

    /**
     * Gets a student list that comply with the filter.
     * @param firstName the student's first name sent by the client.
     * @param lastName the student's last name sent by the client.
     * @return a student's list.
     */
    @Query("SELECT NEW com.problem1.webservice.response.StudentResponse(s.id, s.firstName, s.lastName) " +
            "FROM Student s where s.firstName LIKE :firstName || '%' AND s.lastName LIKE :lastName || '%'")
    List<StudentResponse> findByStudentNames(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
