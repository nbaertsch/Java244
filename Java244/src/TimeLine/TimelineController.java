/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author noah
 * 
 * YOU WILL NEED TO RUN THIS TWICE FOR IT TO WORK>
 * IT WILL FAIL THE FIRST RUN BECAUSE IT NEEDS TO BUILD THE TIMELINE FILE
 */
public class TimelineController {
    private TimelineGUI gui;
    
    private Timeline activeTl;
    private final TimelineIntegrator tli;
    private TimelineItem activeItem;
    
    public TimelineController(){
        this.tli = new TimelineSerializer();
        this.loadTimeline();
        this.activeItem = this.activeTl.get(0);
        
    }
    
    public static void main(String[] args){
        TimelineController tlc = new TimelineController();
        TimelineGUI  gui = new TimelineGUI(tlc);
        
        
        
        // invoke later
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.guiMain();
            }
            
        });
        
    }
    
    protected void buildDefaultTimeline(){
        Timeline tl = new Timeline("Timeline");
        
        tl.add(new TimelineItem(LocalDateTime.now()));
        tl.get(0).setTitle("Macintosh IIfx");
        tl.get(0).setDesc("Released");
        tl.get(0).setEventDate(LocalDate.of(1990, 3, 19));
        
        tl.add(new TimelineItem(LocalDateTime.now()));
        tl.get(1).setTitle("Microsoft Office");
        tl.get(1).setDesc("Released");
        tl.get(1).setEventDate(LocalDate.of(1990, 11, 19));
        
        tl.add(new TimelineItem(LocalDateTime.now()));
        tl.get(2).setTitle("Linux 1.0");
        tl.get(2).setDesc("Linus Torvalds released version 1.0 of the Linux kernel");
        tl.get(2).setEventDate(LocalDate.of(1994, 3, 14));
        
        tl.add(new TimelineItem(LocalDateTime.now()));
        tl.get(3).setTitle("Playstation");
        tl.get(3).setDesc("Sony releases first consoles in Japan");
        tl.get(3).setEventDate(LocalDate.of(1994, 12, 3));
        
        tl.add(new TimelineItem(LocalDateTime.now()));
        tl.get(4).setTitle("Java");
        tl.get(4).setDesc("Sun Microsystems first announces Java at the SunWorld Conference");
        tl.get(4).setEventDate(LocalDate.of(1995, 5, 23));
        
        this.activeTl = tl;
        this.saveTimeline();
    }
    
    public void newTimeline(String name){
        activeTl = new Timeline(name);
    }
    
    public void addToTimeline(){
        //if(activeTl.equals(this.dumbyTl)) return;
        if(this.activeItem == null) return;
        this.activeTl.add(this.activeItem);
        Collections.sort(this.activeTl);
    }
    
    public void removeFromTimeline(){
        //if(activeTl.equals(this.dumbyTl)) return;
        if(this.activeItem == null) return;
        this.activeTl.remove(this.activeItem);
        Collections.sort(this.activeTl);
    }
    
    public void saveTimeline(){
        //if(activeTl.equals(this.dumbyTl)) return;
        try {
            this.tli.save(activeTl);
        } catch (IOException ex) {
            System.out.println("TimelineController | save failed");
            System.out.println(ex);
        }
    }
    
    public void loadTimeline(){
        try{
            this.activeTl = this.tli.load("Timeline");
        } catch (IOException | ClassNotFoundException ex) {
            buildDefaultTimeline();
            System.err.println("Default timline file built, try running again.");
        }
    }
    
    public void newItem(){
        this.activeItem = new TimelineItem(LocalDateTime.now());
    }

    /**
     * @return the activeItem
     */
    public TimelineItem getActiveItem() {
        return activeItem;
    }

    /**
     * @param activeItem the activeItem to set
     */
    public void setActiveItem(TimelineItem activeItem) {
        this.activeItem = activeItem;
    }

    /**
     * @return the activeTl
     */
    public Timeline getActiveTl() {
        return activeTl;
    }

    /**
     * @param activeTl the activeTl to set
     */
    public void setActiveTl(Timeline activeTl) {
        this.activeTl = activeTl;
    }
    
}
