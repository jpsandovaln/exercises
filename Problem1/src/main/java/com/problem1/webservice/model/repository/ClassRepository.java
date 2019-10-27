package com.problem1.webservice.model.repository;

import com.problem1.webservice.model.entity.Class;
import com.problem1.webservice.response.ClassResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Class repository.
 * @author Paolo Sandoval
 * @version 1.0
 */
public interface ClassRepository extends CrudRepository<Class, Long> {

    /**
     * Gets all classes.
     * @return a class list
     */
    @Query("SELECT NEW com.problem1.webservice.response.ClassResponse(c.classId, c.code, c.title, c.description) " +
            "FROM Class c")
    List<ClassResponse> findAllClass();

    /**
     * Gets a class by id.
     * @param classId the class's id.
     * @return a class by id.
     */
    @Query("SELECT NEW com.problem1.webservice.response.ClassResponse(c.classId, c.code, c.title, c.description) " +
            "FROM Class c WHERE c.classId = :classId")
    ClassResponse findByClassId(@Param("classId") Long classId);

    /**
     * Gets all classes by student id.
     * @param id the student's id.
     * @return a classes's list by student id.
     */
    @Query("SELECT NEW com.problem1.webservice.response.ClassResponse(c.classId, c.code, c.title, c.description) " +
            "FROM Class c JOIN c.studentList sc where sc.id = :id")
    List<ClassResponse> findAllClassesByStudent(@Param("id") Long id);

    /**
     * Gets a class list that comply with the filter.
     * @param code the class's code name sent by the client.
     * @param title the class's title name sent by the client.
     * @return a class's list.
     */
    @Query("SELECT NEW com.problem1.webservice.response.ClassResponse(c.classId, c.code, c.title, c.description) " +
            "FROM Class c where c.code LIKE :code || '%' AND c.title LIKE :title || '%'")
    List<ClassResponse> findByClassesFilter(@Param("code") String code, @Param("title") String title);
}
