/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.io.IOException;


/**
 * interface for Timeline integration
 * @author noah
 */
public interface TimelineIntegrator {
    final String ROOT = ("Timelines/");
    final String TRACKER = ("Timelines/tracker.txt");
    
    public void save(Timeline tl) throws IOException;
    
    public Timeline load(String tlName) throws IOException, ClassNotFoundException;
    
   // public Timeline getNewTimeline(String tlName);
    
}
