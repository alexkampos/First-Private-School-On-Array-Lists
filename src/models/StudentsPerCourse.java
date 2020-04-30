/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Course;
import models.Assignment;
import static validationsandmethods.DatabaseCreation.listOfStudents;
import static validationsandmethods.YesOrNoValidation.yesOrNoValidation;
import static validationsandmethods.NonCopiesAndInBoundsValidation.inBoundsStudent;
import static validationsandmethods.NonCopiesAndInBoundsValidation.nonCopyStudent;

/**
 *
 * @author AlexKampos
 */
public class StudentsPerCourse extends Course {

    public static Course studentsPerCourse(Course course) {
        System.out.print("\nWould you like to add this course to any of the students?(yes or no): ");
        boolean yesOrNo1=yesOrNoValidation();
        if (yesOrNo1) {
            System.out.println("");
            for (int i = 0; i < listOfStudents.size(); i++) {
                System.out.println("   "+(i + 1) + ". " + listOfStudents.get(i));
            }
            System.out.print("\nInsert the number of the student you want to add this course to(Choose from the list above): ");
            int numberOfStudent = inBoundsStudent();
            course.students.add(listOfStudents.get(numberOfStudent - 1));
            listOfStudents.get(numberOfStudent - 1).courses.add(course);
            for (Assignment assignment : course.assignments) {
                listOfStudents.get(numberOfStudent - 1).assignments.add(assignment);
                assignment.students.add(listOfStudents.get(numberOfStudent - 1));
            }
            do {
                System.out.print("\nWould you like to add another student to this course?(yes or no): ");
                boolean yesOrNo2=yesOrNoValidation();
                if (yesOrNo2) {
                    System.out.print("\nInsert the number of the student you want this course to be added to(Choose from the list above): ");
                    int numberOfStudent2 = inBoundsStudent();
                    nonCopyStudent(course, numberOfStudent2);
                } else if (!yesOrNo2) {
                    break;
                }
            } while (true);
        } else if (!yesOrNo1) {
        }
        return course;
    }
}
