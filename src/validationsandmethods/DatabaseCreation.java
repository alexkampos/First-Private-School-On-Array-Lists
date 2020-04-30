/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validationsandmethods;

import models.Trainer;
import models.Student;
import models.Course;
import models.Assignment;
import java.util.ArrayList;
import static models.Assignment.createAssignment;
import static models.Course.createCourse;
import static validationsandmethods.GivenDataRepresentation.choicesRepresentation;
import static models.Student.createStudent;
import static models.SyntheticData.createSyntheticData;
import static models.Trainer.createTrainer;
import static validationsandmethods.YesOrNoValidation.yesOrNoValidation;

/**
 *
 * @author AlexKampos
 */
public class DatabaseCreation {
    public static ArrayList<Student> listOfStudents = new ArrayList();
    public static ArrayList<Trainer> listOfTrainers = new ArrayList();
    public static ArrayList<Assignment> listOfAssignments = new ArrayList();
    public static ArrayList<Course> listOfCourses = new ArrayList();

    /*
    method for creating multiple courses
    and adding them to a list
     */
    public static ArrayList<Course> addCourses() {
        System.out.println("\nAdd a course!");
        do {
            listOfCourses.add(createCourse());
            System.out.print("\n Would you like to add a new course?(yes or no): ");
            boolean yesOrNo = yesOrNoValidation();
            if (yesOrNo) {
            } else if (!yesOrNo) {
                break;
            }
        } while (true);
        return listOfCourses;
    }

    /*
    method for creating multiple students
    and adding them to a list
     */
    public static ArrayList<Student> addStudents() {
        System.out.println("\nAdd a student!");
        do {
            listOfStudents.add(createStudent());
            System.out.print("\nWould you like to add a new student?(yes or no): ");
            boolean yesOrNo = yesOrNoValidation();
            if (yesOrNo) {
            } else if (!yesOrNo) {
                break;
            }
        } while (true);
        return listOfStudents;
    }

    /*
    method for creating multiple trainers
    and adding them to a list
     */
    public static ArrayList<Trainer> addTrainers() {
        System.out.println("\nAdd a trainer!");
        do {
            listOfTrainers.add(createTrainer());
            System.out.print("\nWould you like to add a new trainer?(yes or no): ");
            boolean yesOrNo = yesOrNoValidation();
            if (yesOrNo) {
            } else if (!yesOrNo) {
                break;
            }
        } while (true);

        return listOfTrainers;
    }

    /*
    method for creating multiple assignments
    and adding them to a list
     */
    public static ArrayList<Assignment> addAssignments() {
        System.out.println("\nAdd an assignment!");
        do {
            listOfAssignments.add(createAssignment());
            System.out.print("\n Would you like to add a new assignment?(yes or no): ");
            boolean yesOrNo=yesOrNoValidation();
            if (yesOrNo) {
            } else if (!yesOrNo) {
                break;
            }
        } while (true);
        return listOfAssignments;
    }

    public static void databaseCreation() {
        System.out.print("Hello. \nWould you like to create a database for your school?(yes or no): ");
        boolean yesOrNo = yesOrNoValidation();
        if (yesOrNo) {
            addStudents();
            addTrainers();
            addAssignments();
            addCourses();
        } else if (!yesOrNo) {
            System.out.println("Then we are adding some synthetic data for you.");
            createSyntheticData();
        }
        choicesRepresentation();
        System.out.println("See you again next time!!!");
    }
}
