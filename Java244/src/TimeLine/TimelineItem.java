/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

/**
 *
 * @author noah
 * 
 * 
 */

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Superclass for all TimelineItems
 * @author noah
 */
public class TimelineItem implements Comparable<TimelineItem>, Serializable{
    // base timelineItem attributes
    private LocalDateTime entryDate;
    private LocalDate eventDate;
    private String title;
    private String desc;
    private Image image;
    
    @Override
    public String toString(){
        return this.title;
    }
    
    /**
     * 
     * @param entryDate moment in time this event was created
     * @param title 
     */
    public TimelineItem(LocalDateTime entryDate){
        this.entryDate = entryDate;
        this.title = "TITLE";
        this.desc = "DESCRIPTION";
        this.eventDate = this.entryDate.toLocalDate();
    }
    
    
    /**
     * 
     * @param tli
     * @return 
     */
    @Override
    public int compareTo(TimelineItem tli) {
        return this.getEventDate().compareTo(tli.getEventDate());
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.eventDate);
        hash = 73 * hash + Objects.hashCode(this.title);
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimelineItem other = (TimelineItem) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.eventDate, other.eventDate)) {
            return false;
        }
        return true;
    }
    
    

    /**
     * @return the eventDate
     */
    public LocalDate getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the entryDate
     */
    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate the entryDate to set
     */
    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

}
