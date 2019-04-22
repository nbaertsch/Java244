/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InClassPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noah
 */
public class WriteNames {
    public static void main(String[] args){
        File nameFile = new File("src/InClassPractice/WriteNames.txt");
        PrintWriter pw = null;
        try {
            nameFile.createNewFile();
            pw = new PrintWriter(nameFile);
            pw.write("I Dont Know The Names Of Any Of The People In This Class \n");
            pw.print(pw);
            pw.flush();
        } catch (IOException ex) {
            System.out.println("UH OH!");
        } finally{
            pw.close();
        }
        System.out.println(nameFile.getAbsolutePath());
        
        
    }
}
