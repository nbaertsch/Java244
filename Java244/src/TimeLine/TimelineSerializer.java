/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noah
 */
public class TimelineSerializer implements TimelineIntegrator{

    @Override
    public void save(Timeline tl) throws IOException {
        ObjectOutputStream objectO;
        
        objectO = new ObjectOutputStream(new FileOutputStream(new File(TimelineIntegrator.ROOT + tl.getName() + ".tl")));
        objectO.writeObject(tl);
        objectO.flush();
        objectO.close();
    }

    @Override
    public Timeline load(String tlName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectI;
        
        objectI = new ObjectInputStream(new FileInputStream(new File(TimelineIntegrator.ROOT + tlName + ".tl")));
        Timeline tl = (Timeline)objectI.readObject();
        objectI.close();
        
        return tl;
    }

    
    
    private void writeToTracker(String tlName){
        //Scanner
        
    }
    
    private boolean trackerContains(String tlName){
        return true;
    }
    
}
