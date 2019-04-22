/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author noah
 */
public class TimelineCLI {
    
    private static final String[] OPT = {"Load Timeline", "View Timeline" , "Add Timeline Event", "Delete Timeline Event", "Save & Close Timeline"};
    private static File tlDir;
    private static boolean mngFlag;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        mngFlag = true;
        print("\n");
        
        // Timeline management loop
        while(mngFlag){
            print("********************\n" 
                + "* Manage Timelines *\n"
                + "********************\n"
                + "\n"
                + "1. load TL from file\n"
                + "2. Display TL\n"
                + "3. Add to TL\n"
                + "4. Delete\n"
                + "5. Save TL to selected file");
            
            for(int i=0; i<OPT.length; i++)
                print((i+1) + ".\t" + OPT[i] + "\n");
            print("\n");
            switch(in.nextInt()){
                case 1: // load tl from file
                    
                    
                    break;
                case 2: // Sort and Print the tl
                    
                    break;
                case 3: // Add tl event
                    
                    break;
                case 4: // Delete tl event
                    
                    break;
                case 5: // Sort, Save tl to file, and exit management loop
                    mngFlag = false;
                    break;
            }
        }
        
    }
    
    //laziness
    static private void print(String s){
        System.out.print(s);
    }
    
    /**
     * 
     * @param file a .tl text file that represents the timeline
     */
    static private void loadTlFromFile(File file){
        
    }
    
    /**
     * Sort the tl and print it to the screen in a meaningful way
     * @param tl a List of TimelineItem's that represent a timeline when sorted.
     */
    static private void printTl(List<TimelineItem> tl){
        
    }
    
}
