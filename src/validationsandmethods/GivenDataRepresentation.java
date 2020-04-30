/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validationsandmethods;

import models.Student;
import java.util.ArrayList;
import static validationsandmethods.AssignmentsOnSameCalendarWeek.sameWeekAssignments;
import static validationsandmethods.MethodsOfDate.dateToString;
import static validationsandmethods.DatabaseCreation.listOfAssignments;
import static validationsandmethods.DatabaseCreation.listOfCourses;
import static projectparta.ProjectPartA.sc;
import static validationsandmethods.DatabaseCreation.listOfStudents;
import static validationsandmethods.DatabaseCreation.listOfTrainers;

/**
 *
 * @author AlexKampos
 */
public class GivenDataRepresentation {

    public static void choicesRepresentation() {
        String[] choices = new String[11];
        choices[0] = "A list of all the students.";
        choices[1] = "A list of all the trainers.";
        choices[2] = "A list of all the assignments.";
        choices[3] = "A list of all the courses.";
        choices[4] = "All the students per course.";
        choices[5] = "All the trainers per course.";
        choices[6] = "All the assignments per course.";
        choices[7] = "All the assignments per student.";
        choices[8] = "A list of students that belong to more than one courses.";
        choices[9] = "A list of students who need to submit one or more assignments on the same calendar week as the given date. (You have to give a date after you pick this choice!)";
        choices[10] = "Terminate the program.";
        do {
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ". " + choices[i]);
            }
            System.out.print("\nType the number of the presentation you would like from the list above: ");
            String usersAnswer = sc.next().trim().toLowerCase();
            if (usersAnswer.equals("1") || usersAnswer.equals("1.") || usersAnswer.equals("one")) {
                System.out.println("");
                studentsRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("2") || usersAnswer.equals("2.") || usersAnswer.equals("two")) {
                System.out.println("");
                trainersRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("3") || usersAnswer.equals("3.") || usersAnswer.equals("three")) {
                System.out.println("");
                assignmentsRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("4") || usersAnswer.equals("4.") || usersAnswer.equals("four")) {
                System.out.println("");
                coursesRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("5") || usersAnswer.equals("5.") || usersAnswer.equals("five")) {
                System.out.println("");
                studentsPerCourseRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("6") || usersAnswer.equals("6.") || usersAnswer.equals("six")) {
                System.out.println("");
                trainersPerCourseRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("7") || usersAnswer.equals("7.") || usersAnswer.equals("seven")) {
                System.out.println("");
                assignmentsPerCourseRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("8") || usersAnswer.equals("8.") || usersAnswer.equals("eight")) {
                System.out.println("");
                assignmentsPerStudentRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("9") || usersAnswer.equals("9.") || usersAnswer.equals("nine")) {
                System.out.println("");
                moreThanOneCourseStudentsRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("10") || usersAnswer.equals("10.") || usersAnswer.equals("ten")) {
                System.out.println("");
                sameWeekAssignmentsStudentsRepresentation();
                System.out.println("");
            } else if (usersAnswer.equals("11") || usersAnswer.equals("11.") || usersAnswer.equals("eleven")) {
                System.out.println("");
                break;
            } else {
                System.out.println("Wrong Input. Try again.");
                System.out.println("");
            }
        } while (true);
    }

    /*
    method to output the students
     */
    public static void studentsRepresentation() {

        System.out.println("The students are:");
        for (int x = 0; x < listOfStudents.size(); x++) {
            System.out.println(listOfStudents.get(x).toString());
        }
    }

    /*
    method to output the trainers
     */
    public static void trainersRepresentation() {

        for (int x = 0; x < listOfTrainers.size(); x++) {
            System.out.println(listOfTrainers.get(x).toString());
        }
    }

    /*
    method to output the assignments
     */
    public static void assignmentsRepresentation() {

        for (int x = 0; x < listOfAssignments.size(); x++) {
            System.out.println(listOfAssignments.get(x).toString());
        }
    }

    /*
    method to output the courses
     */
    public static void coursesRepresentation() {

        for (int x = 0; x < listOfCourses.size(); x++) {
            System.out.println(listOfCourses.get(x).toString());
        }
    }

    /*
    method to output the students per course
     */
    public static void studentsPerCourseRepresentation() {
        for (int i = 0; i < listOfCourses.size(); i++) {
            System.out.println("The students of the " + listOfCourses.get(i).getTitle() + " course are: ");
            for (int j = 0; j < listOfCourses.get(i).students.size(); j++) {
                System.out.println(listOfCourses.get(i).students.get(j).toString());
            }
        }
    }

    /*
    method to output the trainers per course
     */
    public static void trainersPerCourseRepresentation() {
        for (int i = 0; i < listOfCourses.size(); i++) {
            System.out.println("The trainers of the " + listOfCourses.get(i).getTitle() + " course are: ");
            for (int j = 0; j < listOfCourses.get(i).trainers.size(); j++) {
                System.out.println(listOfCourses.get(i).trainers.get(j).toString());
            }
        }
    }

    /*
    method to output the assignments per course
     */
    public static void assignmentsPerCourseRepresentation() {
        for (int i = 0; i < listOfCourses.size(); i++) {
            System.out.println("The assignments of the " + listOfCourses.get(i).getTitle() + " course are: ");
            for (int j = 0; j < listOfCourses.get(i).assignments.size(); j++) {
                System.out.println(listOfCourses.get(i).assignments.get(j).toString());
            }
        }
    }

    /*
    method to output the assignments per student
     */
    public static void assignmentsPerStudentRepresentation() {
        for (int i = 0; i < listOfStudents.size(); i++) {
            System.out.println("The assignments for " + listOfStudents.get(i).getLastName() + " " + listOfStudents.get(i).getFirstName() + " (Date of Birth: " + dateToString(listOfStudents.get(i).getDateOfBirth()) + ", Tuition Fees: "
                    + listOfStudents.get(i).getTuitionFees() + ") are:");
            for (int j = 0; j < listOfStudents.get(i).assignments.size(); j++) {
                System.out.println(listOfStudents.get(i).assignments.get(j).toString());
            }
        }
    }

    /*
    method to output students that attend more than one courses
     */
    public static void moreThanOneCourseStudentsRepresentation() {
        System.out.println("The students that belong to more than one course are:");
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).courses.size() > 1) {
                System.out.println(listOfStudents.get(i).toString());
            }
        }
    }

    /*
    method to output students that have to submission one or  more assignments on the same calendar week
     */
    public static void sameWeekAssignmentsStudentsRepresentation() {
        ArrayList<Student> studentsWithSameWeekAssignments = sameWeekAssignments();
        System.out.println("Students that have to submit one or more assignments on that date are:");
        for (Student stud : studentsWithSameWeekAssignments) {
            System.out.println(stud.toString());
        }
    }
}
