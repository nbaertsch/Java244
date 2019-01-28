/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordChecker;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noah.baertsch
 */
public class TestClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StrengthChecker sc = new StrengthChecker("123%");
        sc.setMaxLength(10);
        sc.setMinLength(5);
        
        // Enter pass
        System.out.println("Required chars: " + Arrays.toString(sc.getReqChars()));
        System.out.println("Minimum length: " + sc.getMinLength());
        System.out.println("Maximum length: " + sc.getMaxLength());
        System.out.println("\nEnter pass: ");
        String pass = in.nextLine();
        
        // Test pass
        try{
            if(sc.checkPassword(pass)){
                System.out.println("Password passed!");
            }else{
                System.out.println("Password failed!");
            }
        } catch (ObjectMisconfiguredException ex) {
            System.out.println("ObjectMisconfiguredException | " + ex);
        }
        
        in.close();
    }
}
