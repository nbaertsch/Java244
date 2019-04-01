/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import TimeLine.Computer;
import TimeLine.Person;
import TimeLine.TimelineItem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noah
 */
public class SerializeSaveTest {
    
    static List<TimelineItem> tl;
    static final String filename = "SerializeTest.ser";
    
    public static void main(String args[]){
        tl = new ArrayList();
        tl.add(new Computer(LocalDate.of(2005, 1, 28), "Computer"));
        tl.add(new Person(LocalDate.of(1996, 1, 28), "Noah"));
        
        for(TimelineItem tli : tl)
            System.out.println("Title: " + tli.getTitle() + "   Date: " + tli.getEventDate().toString());
        
        Collections.sort(tl);
        
        FileOutputStream fileO;
        ObjectOutputStream objectO;
        try {
            fileO = new FileOutputStream(filename);
            objectO = new ObjectOutputStream(fileO);
            objectO.writeObject(tl);
            objectO.close();
        } catch (IOException ex) {
            System.out.println("SerializeSaveTest | failed to serialize object \n");
            ex.printStackTrace();
        }
        
        System.out.println("Sorting.. Serializing.. Deserializing..");
        tl = null;
        
        FileInputStream fileI;
        ObjectInputStream objectI;
        try {
            fileI = new FileInputStream(filename);
            objectI = new ObjectInputStream(fileI);
            tl = (ArrayList<TimelineItem>) objectI.readObject();
            objectI.close();
        } catch (IOException ex) {
            System.out.println("SerializeSaveTest | failed to serialize object \n");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializeSaveTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(TimelineItem tli : tl)
            System.out.println("Title: " + tli.getTitle() + "   Date: " + tli.getEventDate().toString());
        
    }
    
}
