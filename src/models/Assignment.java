/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.util.ArrayList;
import java.util.Date;
import static validationsandmethods.MethodsOfDate.dateToString;
import static projectparta.ProjectPartA.sc;
import static validationsandmethods.MethodsOfDate.isValidDate;
import static validationsandmethods.MethodsOfDate.reformDate;
import static validationsandmethods.MethodsOfDate.subValidDate;
import static validationsandmethods.ValidDouble.validDouble;

/**
 *
 * @author AlexKampos
 */
public class Assignment {

    private String title;
    private String description;
    private Date subDateTime;
    private double oralMark;
    private double totalMark;
    public ArrayList<Student> students;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }

    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    Assignment() {
       this.students = new ArrayList();
    }

    Assignment(String title, String description, Date subDateTime, double oralMark, double totalMark) {
        this.students = new ArrayList();
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    /*
    method to create an assignment if user chooses to
     */
    public static Assignment createAssignment() {
        Assignment newAssignment = new Assignment();
        System.out.print("\n Title: ");
        sc.nextLine();
        newAssignment.title = sc.nextLine();
        System.out.print("\n Description: ");
        newAssignment.description = sc.nextLine();
        while (true) {
            System.out.print("\n Submission date(e.g. dd/mm/yyyy): ");
            String subDate = sc.next();
            if (!isValidDate(subDate)) {
                System.out.print("\nWrong input. Please give the right pattern of date as shown in the example.");
            } else if (!subValidDate(subDate)) {
                System.out.print("\nWrong input. The date you have inserted falls upon a weekend. Please give a valid date: ");
            } else {
                subDate = reformDate(subDate);
                newAssignment.subDateTime = new Date(subDate);
                break; 
            }
        }
        System.out.print("\n Oral mark: ");
        newAssignment.oralMark = validDouble();
        System.out.print("\n Total mark: ");
        newAssignment.totalMark = validDouble();
        return newAssignment;
    }
    
    @Override
    public String toString() {
        return "Assignment's data: " + "Title= " + title + ", Description= " + description + ", Submission date= " + dateToString(subDateTime) + ", Oral mark= " + oralMark + ", Total mark= " + totalMark;
    }

}
