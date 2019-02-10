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
 * I did not implement expanding the requirements beyond the original constructor string,
 * mostly because it was added as a requirement after I had finished the day one requirements.
 * 
 * @author noah.baertsch
 */
public class TestClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        // enter sc params
        System.out.print("Enter required characters, followed by [ENTER]: ");
        StrengthChecker sc = new StrengthChecker(in.nextLine());
        System.out.print("Enter max pass length, followed by [ENTER]: ");
        sc.setMaxLength(in.nextInt());
        System.out.print("Enter min pass length, followed by [ENTER]: ");
        sc.setMinLength(in.nextInt());
        
        // Enter pass
        System.out.println("Required chars: " + Arrays.toString(sc.getReqChars()));
        System.out.println("Minimum length: " + sc.getMinLength());
        System.out.println("Maximum length: " + sc.getMaxLength());
        System.out.println("\nEnter pass: ");
        String pass = in.next();
        
        System.out.println("Password = " + pass);
        
        // Test pass
        try{
            if(sc.checkPassword(pass)){
                System.out.println("Password passed!");
            }else{
                System.out.println("Password failed!");
            }
            System.out.println();
        
            String[][] fb = sc.getFeedback();
        
            // this is hacky and for any real use should be considered broken
            for(int i=0; i<(sc.getReqChars().length+2); i++){
                for(int j=0; j<2; j++){
                    System.out.print(fb[i][j]+"\t");
                
                }
                System.out.println();
            }
        } catch (ObjectMisconfiguredException ex) {
            System.out.println("ObjectMisconfiguredException | " + ex);
        }
        
        
        
        in.close();
    }
}
