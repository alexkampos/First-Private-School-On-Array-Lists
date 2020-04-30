/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validationsandmethods;

import models.Student;
import models.Assignment;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import static validationsandmethods.DatabaseCreation.listOfAssignments;
import static projectparta.ProjectPartA.sc;
import static validationsandmethods.MethodsOfDate.isValidDate;
import static validationsandmethods.MethodsOfDate.reformDate;

/**
 *
 * @author AlexKampos
 */
public class AssignmentsOnSameCalendarWeek {

    public static ArrayList sameWeekAssignments() {
        ArrayList<Student> sameWeekAssignments = new ArrayList();
        while (true) {
            System.out.print("\nInsert a date to see the students who need to submit one or more assignments on the same calendar week(dd/mm/yyyy): ");
            String dateGiven = sc.next();
            if (!isValidDate(dateGiven)) {
                System.out.print("\nWrong input. Please give the right pattern of date as shown in the example: ");
            } else {
                /*
                Method where I change Date to LocalDate and check via TemporalField the weekOfYear so i can find
                the students that have one or more assignments at the same week
                 */
                dateGiven = reformDate(dateGiven);
                Date date = new Date(dateGiven);
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                WeekFields week = WeekFields.of(DayOfWeek.MONDAY, 7);
                TemporalField weekOfYear = week.weekOfYear();
                for (Assignment assignment : listOfAssignments) {
                    LocalDate assignmentLocalDate = assignment.getSubDateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    if (localDate.get(weekOfYear) == assignmentLocalDate.get(weekOfYear)) {
                        for (Student stud : assignment.students) {
                            sameWeekAssignments.add(stud);
                        }
                    }
                }
            }
            break;
        }
        return sameWeekAssignments;
    }
}
