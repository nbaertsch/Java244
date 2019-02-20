/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.time.LocalDate;

/**
 *
 * @author noah
 */
public class Computer extends TimelineItem{

    
    private int kbRam;
    private int hz;
    private String manufacturer;
    
    public Computer(LocalDate date, String title){
        super(date, title);
    }
    
    /**
     * @return the kbRam
     */
    public int getKbRam() {
        return kbRam;
    }

    /**
     * @param kbRam the kbRam to set
     */
    public void setKbRam(int kbRam) {
        this.kbRam = kbRam;
    }

    /**
     * @return the hz
     */
    public int getHz() {
        return hz;
    }

    /**
     * @param hz the hz to set
     */
    public void setHz(int hz) {
        this.hz = hz;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    
}
