/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import static validationsandmethods.DatabaseCreation.listOfAssignments;
import static validationsandmethods.YesOrNoValidation.yesOrNoValidation;
import static validationsandmethods.NonCopiesAndInBoundsValidation.inBoundsAssignment;
import static validationsandmethods.NonCopiesAndInBoundsValidation.nonCopyAssignment;

/**
 *
 * @author AlexKampos
 */
public class AssignmentsPerCourse extends Course {

    public static Course assignmentsPerCourse(Course course) {
        System.out.print("\nWould you like to add any of the assignments to this course?(yes or no): ");
        boolean yesOrNo1=yesOrNoValidation();
        if (yesOrNo1) {
            System.out.println("");
            for (int i = 0; i < listOfAssignments.size(); i++) {
                System.out.println("   "+(i + 1) + ". " + listOfAssignments.get(i));
            }
            System.out.print("\nInsert the number of the assignment you want to add to this course(Choose from the list above): ");
            int numberOfAssignment=inBoundsAssignment();
            course.assignments.add(listOfAssignments.get(numberOfAssignment - 1));
            do {
                System.out.print("\nWould you like to add another assignment to this course?(yes or no): ");
                boolean yesOrNo2=yesOrNoValidation();
                if (yesOrNo2) {
                    System.out.print("\nInsert the number of the assignment you want to be added to this course(Choose from the list above): ");
                    int numberOfAssignment2=inBoundsAssignment();
                    nonCopyAssignment(course, numberOfAssignment2);
                } else if (!yesOrNo2) {
                    break;
                }
            } while (true);
        } else if (!yesOrNo1) {
        }
        return course;
    }
}
