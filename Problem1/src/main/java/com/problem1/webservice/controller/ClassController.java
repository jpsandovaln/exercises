package com.problem1.webservice.controller;

import com.problem1.webservice.common.constant.MessageConstant;
import com.problem1.webservice.exception.ParameterInvalidException;
import com.problem1.webservice.model.entity.Class;
import com.problem1.webservice.model.repository.ClassRepository;
import com.problem1.webservice.response.ClassResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class controller.
 * @author Paolo Sandoval
 * @version 1.0
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassRepository classRepo;

    /**
     * Gets all Classes.
     * @return a class list
     */
    @GetMapping
    public List<ClassResponse> getAllClasses() {
        return classRepo.findAllClass();
    }

    /**
     * Gets a class by id.
     * @param id the class's id.
     * @return a class by id.
     */
    @GetMapping("/{id}")
    public ClassResponse geClassById(@PathVariable( value = "id") Long id,
                                     HttpServletResponse response)  throws IOException {
        ClassResponse classResponse = classRepo.findByClassId(id);
        try {
            classResponse.validate();
        } catch (ParameterInvalidException ex) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        } catch (Exception ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }
        return classResponse;
    }

    /**
     * Create a new class.
     * @param newClass class object from client.
     * @return the class created.
     */
    @PostMapping
    public Class createClass(@RequestBody Class newClass) {
        return classRepo.save(newClass);
    }

    /**
     * Deletes a class by id
     * @param id the class's id.
     * @return a ok response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable(value = "id") Long id) {
        Class classRoom = classRepo.findById(id).orElseThrow(() ->
                new RuntimeException(MessageConstant.DELETE_ERROR_MSG));
        classRepo.delete(classRoom);
        return ResponseEntity.ok().build();
    }

    /**
     * Update class information.
     * @param id the class's id.
     * @param newClassData class object from client.
     * @return the class updated.
     */
    @PutMapping("{id}")
    public Class updateClass(@PathVariable(value = "id") Long id,
                             @RequestBody Class newClassData) {
        Class currentClass = classRepo.findById(id).orElseThrow(() ->
                new RuntimeException(MessageConstant.UPDATE_ERROR_MSG));
        currentClass.setCode(newClassData.getCode());
        currentClass.setDescription(newClassData.getDescription());
        currentClass.setTitle(newClassData.getTitle());
        currentClass.setStudentList(newClassData.getStudentList());

        Class updateClass = classRepo.save(currentClass);
        return updateClass;
    }

    /**
     * Gets all classes by student id.
     * @param id the student's id.
     * @return a class's list by student.
     */
    @GetMapping("/students/{id}")
    public List<ClassResponse> getAllClassesByStudentId(@PathVariable(value = "id") Long id) {
        return classRepo.findAllClassesByStudent(id);
    }

    /**
     * Gets a class list that comply with the filter.
     * @param code the class's code sent by the client.
     * @param title the class's title sent by the client.
     * @return a class's list.
     */
    @GetMapping("/filter")
    public  List<ClassResponse> getClassesByQueryParams(@RequestParam(required = true) String code,
                                                        @RequestParam(required = true) String title) {
        return classRepo.findByClassesFilter(code, title);
    }
}
