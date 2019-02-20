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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Superclass for all TimelineItems
 * @author noah
 */
public class TimelineItem implements Comparable<TimelineItem>, Serializable{
    // base timelineItem attributes
    private LocalDate date;
    private String title;
    private String desc;
    private Image image;
    
    public TimelineItem(LocalDate date, String title){
        this.date = date;
        this.title = title;
    }
    
    @Override
    public int compareTo(TimelineItem tli) {
        return this.getDate().compareTo(tli.getDate());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.date);
        hash = 73 * hash + Objects.hashCode(this.title);
        return hash;
    }

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
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
    
}
