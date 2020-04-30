/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validationsandmethods;

import static projectparta.ProjectPartA.sc;

/**
 *
 * @author AlexKampos
 */
public class YesOrNoValidation {

    public static boolean yesOrNoValidation() {
        do {
            String answer = sc.next();
            if (answer.trim().toLowerCase().equals("yes")) {
                return true;
            } else if (answer.trim().toLowerCase().equals("no")) {
                return false;
            } else {
                System.out.println("\nWrong Input. Type yes for affirmation or no for refusal: ");
            }
        } while (true);
    }
}
