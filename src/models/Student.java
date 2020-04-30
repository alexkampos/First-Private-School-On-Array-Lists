/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Course;
import models.Assignment;
import java.util.ArrayList;
import java.util.Date;
import static validationsandmethods.MethodsOfDate.dateToString;
import static projectparta.ProjectPartA.sc;
import static validationsandmethods.MethodsOfDate.isValidDate;
import static validationsandmethods.MethodsOfDate.reformDate;
import static validationsandmethods.ValidDouble.validDouble;

/**
 *
 * @author AlexKampos
 */
public class Student {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double tuitionFees;
    public ArrayList<Assignment> assignments;
    public ArrayList<Course> courses;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    Student() {
        this.assignments = new ArrayList<Assignment>();
        this.courses = new ArrayList<Course>();
    }

    Student(String firstName, String lastName, Date dateOfBirth, double tuitionFees) {
        this.assignments = new ArrayList<Assignment>();
        this.courses = new ArrayList<Course>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;

    }

    /*
    Method to input new Student data,
    if user decides to.
     */
    public static Student createStudent() {
        Student newStudent = new Student();
        System.out.print("\n First name: ");
        newStudent.firstName = sc.next();
        System.out.print("\n Last name: ");
        newStudent.lastName = sc.next();
        boolean loop1 = false;
        while (loop1 == false) {
            System.out.print("\n Date of birth(e.g. dd/mm/yyyy): ");
            String birthDate = sc.next();
            if (!isValidDate(birthDate)) {
                System.out.print("\nWrong input. Please give the right pattern of date as shown in the example.");
            } else {
                birthDate = reformDate(birthDate);
                newStudent.setDateOfBirth(new Date(birthDate));
                loop1 = true;
            }
        }
        System.out.print("\n Tuition fees: ");
        newStudent.tuitionFees = validDouble();
        return newStudent;
    }

    @Override
    public String toString() {

        return "Student's data: " + "First name= " + firstName + ", Last name= " + lastName + ", Date of birth= " + dateToString(dateOfBirth) + ", Tuition fees= " + tuitionFees;
    }

}
