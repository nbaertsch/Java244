/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import TimeLine.TimelineItem;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author noah
 */
public class TextSavableTest {
    
    public static void main(String[] args) throws IOException{
        File file = new File("test/TLI_State_Save_Test.txt");
        TimelineItem tli = new TimelineItem(LocalDate.of(1996,1,28), "Noah Baertsch");
        tli.setDesc("The date noah was born");
        System.out.println("Saving to file " + file.getName());
        tli.saveToFile(file);
        System.out.println("Loading from file...");
        tli = new TimelineItem(file);
        System.out.println("Title = " + tli.getTitle());
        System.out.println("Date = " + tli.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("Description = " + tli.getDesc());
    }
    
}
