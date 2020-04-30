/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import static projectparta.ProjectPartA.sc;

/**
 *
 * @author AlexKampos
 */
public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    Trainer() {}

    Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    /*
    Method to create a Trainer if user chooses to.
     */
    public static Trainer createTrainer() {
        Trainer newTrainer = new Trainer();
        System.out.print("\n First name: ");
        newTrainer.firstName = sc.next();
        System.out.print("\n Last name: ");
        newTrainer.lastName = sc.next();
        System.out.print("\n Subject: ");
        newTrainer.subject = sc.next();
        return newTrainer;
    }
    
    @Override
    public String toString() {
        return "Trainer's data: " + "First name= " + firstName + ",  Last name= " + lastName + ",  Subject= " + subject ;
    }

}
