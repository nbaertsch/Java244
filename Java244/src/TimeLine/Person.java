/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeLine;

import java.time.LocalDate;


public class Person extends TimelineItem {
    
    private LocalDate bornOn, diedOn;  // diedOn should be NULL if this person is still alive

    public Person(LocalDate date, String title) {
        super(date, title);
    }

    /**
     * @return the bornOn
     */
    public LocalDate getBornOn() {
        return bornOn;
    }

    /**
     * @param bornOn set the LocalDate when this person was born
     */
    public void setBornOn(LocalDate bornOn) {
        this.bornOn = bornOn;
    }

    /**
     * @return the diedOn
     */
    public LocalDate getDiedOn() {
        return diedOn;
    }

    /**
     * @param diedOn set the LocalDate this person died, set to NULL if still alive
     */
    public void setDiedOn(LocalDate diedOn) {
        this.diedOn = diedOn;
    }
    
}
