package com.problem1.webservice.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 * Student Entity.
 * @author Paolo Sandoval
 * @version 1.0
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @ManyToMany
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Class> classes;

    /**
     * Constructor
     */
    public Student() {
    }

    /**
     * Constructor to create a student.
     * @param id the student's id.
     * @param firstName the student's first name.
     * @param lastName the student's last name.
     * @param classes the student's class list.
     */
    public Student(long id, @NotNull String firstName, @NotNull String lastName,
                   Set<Class> classes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classes = classes;
    }

    /**
     * Gets the student's id.
     * @return a number representing the student's id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the student's id.
     * @param id the student's id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the student's first name.
     * @return a string representing the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     * @param firstName the student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     * @return a string representing the student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     * @param lastName the student's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student class list.
     * @return a class list.
     */
    public Set<Class> getClasses() {
        return classes;
    }

    /**
     * Sets the student class list.
     * @param classes the student class list.
     */
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classes=" + classes +
                '}';
    }
}
