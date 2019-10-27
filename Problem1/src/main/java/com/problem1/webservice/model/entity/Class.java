package com.problem1.webservice.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * Class Entity.
 * @author Paolo Sandoval
 * @version 1.0
 */
@Entity
public class Class {

    @Id
    @GeneratedValue
    private long classId;

    @NotNull
    private String code;

    @NotNull
    private String title;

    private String description;

    @ManyToMany(mappedBy = "classes")
    private List<Student> studentList;

    /**
     * Constructor
     */
    public Class() {
    }

    /**
     * Constructor to create a Class.
     * @param classId the class's id.
     * @param code the class's code.
     * @param title the class's title.
     * @param description the class's description.
     * @param studentList student list on the class.
     */
    public Class(long classId, @NotNull String code, @NotNull String title, String description,
                 List<Student> studentList) {
        this.classId = classId;
        this.code = code;
        this.title = title;
        this.description = description;
        this.studentList = studentList;
    }

    /**
     * Gets the class's id.
     * @return a number representing the class's id.
     */
    public long getClassId() {
        return classId;
    }

    /**
     * Sets the Class's id.
     * @param classId the class's id.
     */
    public void setClassId(long classId) {
        this.classId = classId;
    }

    /**
     * Gets the class's code.
     * @return a string representing the class's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the Class's code.
     * @param code the class's code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the class's title.
     * @return a string representing the class's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the Class's title.
     * @param title the class's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the class's description.
     * @return a string representing the class's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Class's description.
     * @param description the class's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the student list on the class.
     * @return a student list.
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Sets the Class's student list.
     * @param studentList the class's student list.
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return classId == aClass.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }

    @Override
    public String toString() {
        return "Class{" +
                "iclassIdd=" + classId +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
