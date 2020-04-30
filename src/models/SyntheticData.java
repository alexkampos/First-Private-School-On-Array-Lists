/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Trainer;
import models.Student;
import models.Course;
import models.Assignment;
import java.util.Date;
import static validationsandmethods.DatabaseCreation.listOfAssignments;
import static validationsandmethods.DatabaseCreation.listOfCourses;
import static validationsandmethods.DatabaseCreation.listOfStudents;
import static validationsandmethods.DatabaseCreation.listOfTrainers;

/**
 *
 * @author AlexKampos
 */
public class SyntheticData {

    public static void createSyntheticData() {

        /*
        Method for creating trainers with synthetic data.
         */
        Trainer trainer1 = new Trainer("Manos", "Kazakos", "Software Development");
        Trainer trainer2 = new Trainer("Xristos", "Zaniotis", "Methods");
        Trainer trainer3 = new Trainer("Nikos", "Zisis", "Loops");
        listOfTrainers.add(trainer1);
        listOfTrainers.add(trainer2);
        listOfTrainers.add(trainer3);
        /*
        Method for creating students with synthetic data  
         */
        Student student1 = new Student("Mixalis", "Papadopoulos", new Date("12/12/1995"), 2500.00);
        Student student2 = new Student("Giorgos", "Karlis", new Date("08/08/1990"), 2000.00);
        Student student3 = new Student("Fanis", "Dimitrakopoulos", new Date("06/06/1989"), 2500.00);
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);

        /*
        Method for creating assignments with synthetic data.
         */
        Assignment assignment1 = new Assignment("Private School", "Create a private school database containing students and trainers.", new Date("03/01/20"), 25.0, 100.0);
        Assignment assignment2 = new Assignment("Prime Numbers", "Create a program that locates all the prime numbers until 1000.", new Date("01/01/2020"), 15.0, 100.0);
        Assignment assignment3 = new Assignment("Site", "Create a site interface.", new Date("02/01/2020"), 10.0, 100.0);
        listOfAssignments.add(assignment1);
        listOfAssignments.add(assignment2);
        listOfAssignments.add(assignment3);
        assignment1.students.add(listOfStudents.get(0));
        student1.assignments.add(listOfAssignments.get(0));
        assignment1.students.add(listOfStudents.get(1));
        student2.assignments.add(listOfAssignments.get(0));
        assignment2.students.add(listOfStudents.get(0));
        student1.assignments.add(listOfAssignments.get(1));
        assignment2.students.add(listOfStudents.get(1));
        student2.assignments.add(listOfAssignments.get(1));
        assignment2.students.add(listOfStudents.get(2));
        student3.assignments.add(listOfAssignments.get(1));
        assignment3.students.add(listOfStudents.get(1));
        student2.assignments.add(listOfAssignments.get(2));
        assignment3.students.add(listOfStudents.get(2));
        student3.assignments.add(listOfAssignments.get(2));


        /*
        Method for creating courses with synthetic data.
         */
        Course course1 = new Course("Coding Bootcamp 10", "Java", "Part-time", new Date("02/10/2020"), new Date("09/10/2020"));
        Course course2 = new Course("Coding Bootcamp 10", "C#", "Full-time", new Date("02/01/2020"), new Date("05/01/2020"));
        Course course3 = new Course("Coding Bootcamp 9", "Java", "Full-time", new Date("08/01/2019"), new Date("02/01/2020"));
        listOfCourses.add(course1);
        listOfCourses.add(course2);
        listOfCourses.add(course3);
        course1.assignments.add(listOfAssignments.get(0));
        course1.assignments.add(listOfAssignments.get(1));
        course2.assignments.add(listOfAssignments.get(2));
        course3.assignments.add(listOfAssignments.get(1));
        course1.trainers.add(listOfTrainers.get(2));
        course3.trainers.add(listOfTrainers.get(2));
        course3.trainers.add(listOfTrainers.get(1));
        course3.trainers.add(listOfTrainers.get(0));
        course2.trainers.add(listOfTrainers.get(0));
        course1.students.add(listOfStudents.get(0));
        student1.courses.add(listOfCourses.get(0));
        course1.students.add(listOfStudents.get(1));
        student2.courses.add(listOfCourses.get(0));
        course2.students.add(listOfStudents.get(2));
        student3.courses.add(listOfCourses.get(1));
        course2.students.add(listOfStudents.get(1));
        student2.courses.add(listOfCourses.get(1));
        course3.students.add(listOfStudents.get(2));
        student3.courses.add(listOfCourses.get(2));
        course3.students.add(listOfStudents.get(0));
        student1.courses.add(listOfCourses.get(2));

    }
}
