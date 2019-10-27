package com.problem1.webservice.controller;

import com.problem1.webservice.model.entity.Student;
import com.problem1.webservice.model.repository.StudentRepository;
import com.problem1.webservice.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student controller.
 * @author Paolo Sandoval
 * @version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepo;

    /**
     * Gets all students.
     * @return a student list
     */
    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentRepo.findAllStudent();
    }

    /**
     * Gets a student by id.
     * @param id the student's id.
     * @return a student by id.
     */
    @GetMapping("/{id}")
    public StudentResponse geStudentById(@PathVariable( value = "id") Long id) {
        return studentRepo.findByStudentId(id);
    }

    /**
     * Create a new student.
     * @param student student object from client.
     * @return the student created.
     */
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    /**
     * Deletes a student by id
     * @param id the student's id.
     * @return a ok response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("no found"));
        studentRepo.delete(student);
        return ResponseEntity.ok().build();
    }

    /**
     * Update student information.
     * @param id the student's id.
     * @param newStudentData student object from client.
     * @return the student updated.
     */
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable(value = "id") Long id,
                                 @RequestBody Student newStudentData) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("no found"));
        student.setFirstName(newStudentData.getFirstName());
        student.setLastName(newStudentData.getLastName());
        student.setClasses(newStudentData.getClasses());
        Student updateStudent = studentRepo.save(student);
        return updateStudent;
    }

    /**
     * Gets all students bu class id.
     * @param id the class's id.
     * @return a students's list on the class.
     */
    @GetMapping("/classes/{id}")
    public List<StudentResponse> getAllClassesByStudentId(@PathVariable(value = "id") Long id) {
        return studentRepo.findAllStudentsByClass(id);
    }

    /**
     * Gets a student list that comply with the filter.
     * @param firstName the student's first name sent by the client.
     * @param lastName the student's last name sent by the client.
     * @return a student's list.
     */
    @GetMapping("/filter")
    public  List<StudentResponse> getStudentByQueryParams(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName) {
        return studentRepo.findByStudentNames(firstName, lastName);
    }
}
