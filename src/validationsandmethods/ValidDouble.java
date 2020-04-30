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
public class ValidDouble {

    public static double validDouble() {

        double nextDouble = 0;
        do {
            if (sc.hasNextDouble()) {
                nextDouble = sc.nextDouble();
                break;
            } else {
                System.out.println("Wrong input. Please enter a valid input.");
                sc.next();
            }
        } while (true);
        return nextDouble;
    }
}
