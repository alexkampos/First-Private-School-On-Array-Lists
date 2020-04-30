/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Assignment;
import java.util.ArrayList;
import java.util.Date;
import static models.AssignmentsPerCourse.assignmentsPerCourse;
import static validationsandmethods.MethodsOfDate.dateToString;
import static projectparta.ProjectPartA.sc;
import static validationsandmethods.MethodsOfDate.isValidDate;
import static validationsandmethods.MethodsOfDate.reformDate;
import static models.StudentsPerCourse.studentsPerCourse;
import static models.TrainersPerCourse.trainersPerCourse;

/**
 *
 * @author AlexKampos
 */
public class Course {

    private String title;
    private String stream;
    private String type;
    private Date courseStartDate;
    private Date courseEndDate;
    public ArrayList<Student> students;
    public ArrayList<Trainer> trainers;
    public ArrayList<Assignment> assignments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    Course() {
        this.assignments = new ArrayList();
        this.trainers = new ArrayList();
        this.students = new ArrayList();
    }

    Course(String title, String stream, String type, Date startDate, Date endDate) {
        this.assignments = new ArrayList();
        this.students = new ArrayList();
        this.trainers = new ArrayList();
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.courseStartDate = startDate;
        this.courseEndDate = endDate;
    }

    /*
    Method to create a new course, if user chooses to.
     */
    public static Course createCourse() {
        Course newCourse = new Course();
        System.out.print("\n Title: ");
        sc.nextLine();
        newCourse.title=sc.nextLine();
        System.out.print("\n Stream: ");
        newCourse.stream = sc.next();
        System.out.print("\n Type: ");
        sc.nextLine();
        newCourse.type=sc.nextLine();
        while (true) {
            System.out.print("\n Start date(e.g. dd/mm/yyyy): ");
            String startDate = sc.next();
            if (!isValidDate(startDate)) {
                System.out.print("\nWrong input. Please give the right pattern of date as shown in the example: ");
            } else {
                startDate = reformDate(startDate);
                newCourse.courseStartDate = new Date(startDate);
                break;
            }
        }
        while (true) {
            System.out.print("\n End date(e.g. dd/mm/yyyy): ");
            String endDate = sc.next();
            if (!isValidDate(endDate)) {
                System.out.print("\nWrong input. Please give the right pattern of date as shown in the example: ");
            } else {
                endDate = reformDate(endDate);
                newCourse.courseEndDate = new Date(endDate);
                break;
            }
        }
        /*
         the part where i link the course i am creating to trainers, 
         via a list of trainers and letting the user choose who them trainers are
         */
        newCourse = trainersPerCourse(newCourse);
        /*
        connecting assignments to courses
         */
        newCourse = assignmentsPerCourse(newCourse);

        /*
        connecting students to courses,
        courses to students,
        students to assignments
        and assignments to students
         */
        newCourse = studentsPerCourse(newCourse);
        return newCourse;
    }

    @Override
    public String toString() {
        return "Course's data: " + "Title= " + title + ", Stream= " + stream + ", Type= " + type + ", Course start date= " + dateToString(courseStartDate) + ", Course end date= " + dateToString(courseEndDate);
    }

}
