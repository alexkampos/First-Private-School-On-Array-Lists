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
import static validationsandmethods.DatabaseCreation.listOfAssignments;
import static validationsandmethods.DatabaseCreation.listOfStudents;
import static validationsandmethods.DatabaseCreation.listOfTrainers;
import static projectparta.ProjectPartA.sc;
/**
 *
 * @author AlexKampos
 */
public class NonCopiesAndInBoundsValidation {

    /*
    Method for validating if the number of assignment user chooses is in bounds.
     */
    public static int inBoundsAssignment() {
        do {
            int numberOfAssignment = sc.nextInt();
            if (numberOfAssignment >= listOfAssignments.size() + 1 || numberOfAssignment < 1) {
                System.out.print("\n Wrong Input! Try again: ");
            } else {
                return numberOfAssignment;
            }
        } while (true);
    }

    /*
    Method created so the program won't take more copies of the chosen assignment object,
    if is already picked previously the same object. 
     */
    public static void nonCopyAssignment(Course course, int numberOfAssignment) {
        int counter = 0;
        for (Assignment assignment : course.assignments) {
            if (assignment.equals(listOfAssignments.get(numberOfAssignment - 1))) {
                counter = 1;
                break;
            }
        }
        if (counter == 0) {
            course.assignments.add(listOfAssignments.get(numberOfAssignment - 1));
        }
    }

    /*
    Method for validating if the number of trainer user chooses is in bounds.
     */
    public static int inBoundsTrainer() {
        do {
            int numberOfTrainer = sc.nextInt();
            if (numberOfTrainer >= listOfTrainers.size() + 1 || numberOfTrainer < 1) {
                System.out.print("\n Wrong Input! Try again: ");
            } else {
                return numberOfTrainer;
            }
        } while (true);
    }

    /*
    Method created so the program won't take more copies of the chosen trainer object,
    if is already picked previously the same object. 
     */
    public static void nonCopyTrainer(Course course, int numberOfTrainer) {
        int counter = 0;
        for (Trainer trainer : course.trainers) {
            if (trainer.equals(listOfTrainers.get(numberOfTrainer - 1))) {
                counter = 1;
                break;
            }
        }
        if (counter == 0) {
            course.trainers.add(listOfTrainers.get(numberOfTrainer - 1));
        }
    }

    /*
    Method for validating if the number of student user chooses is in bounds.
     */
    public static int inBoundsStudent() {
        do {
            int numberOfStudent = sc.nextInt();
            if (numberOfStudent >= listOfStudents.size() + 1 || numberOfStudent < 1) {
                System.out.print("\n Wrong Input! Try again: ");
            } else {
                return numberOfStudent;
            }
        } while (true);
    }

    /*
    Method created so the program won't take more copies of the chosen student object,
    if is already picked previously the same object, in both course and student. 
     */
    static int counterStud1 = 0;
    static int counterStud2 = 0;
    public static void nonCopyStudent(Course course, int numberOfStudent) {
        for (Student student : course.students) {
            if (student.equals(listOfStudents.get(numberOfStudent - 1))) {
                counterStud1 = 1;
                break;
            }
        }
        if (counterStud1 == 0) {
            course.students.add(listOfStudents.get(numberOfStudent - 1));
            listOfStudents.get(numberOfStudent - 1).courses.add(course);
            for (Assignment assignment1 : course.assignments) {
                for (Assignment assignment2 : listOfStudents.get(numberOfStudent - 1).assignments) {
                    if (assignment1.equals(assignment2)) {
                        counterStud2 = 1;
                        break;
                    }
                }
                if (counterStud2 == 0) {
                    listOfStudents.get(numberOfStudent - 1).assignments.add(assignment1);
                    assignment1.students.add(listOfStudents.get(numberOfStudent - 1));
                }
            }
        }
    }
}
