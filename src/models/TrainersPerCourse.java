/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Course;
import static validationsandmethods.DatabaseCreation.listOfTrainers;
import static validationsandmethods.YesOrNoValidation.yesOrNoValidation;
import static validationsandmethods.NonCopiesAndInBoundsValidation.inBoundsTrainer;
import static validationsandmethods.NonCopiesAndInBoundsValidation.nonCopyTrainer;

/**
 *
 * @author AlexKampos
 */
public class TrainersPerCourse extends Course {

    public static Course trainersPerCourse(Course course) {
        System.out.print("\nWould you like to add this course to any of the trainers?(yes or no): ");
        boolean yesOrNo1=yesOrNoValidation();
        if (yesOrNo1) {
            System.out.println("");
            for (int i = 0; i < listOfTrainers.size(); i++) {
                System.out.println("   "+(i + 1) + ". " + listOfTrainers.get(i));
            }
            System.out.print("\nInsert the number of the trainer you want to add this course(Choose from the list above): ");
            int numberOfTrainer = inBoundsTrainer();
            course.trainers.add(listOfTrainers.get(numberOfTrainer - 1));
            do {
                System.out.print("\nWould you like to add another trainer to this course?(yes or no): ");
                boolean yesOrNo2=yesOrNoValidation();
                if (yesOrNo2) {
                    System.out.print("\nInsert the number of the trainer you want this course to be added to(Choose from the list above): ");
                    int numberOfTrainer2 = inBoundsTrainer();
                    nonCopyTrainer(course, numberOfTrainer2);
                } else if (!yesOrNo2) {
                    break;
                }
            } while (true);
        } else if (!yesOrNo1) {
        }
        return course;
    }
}
