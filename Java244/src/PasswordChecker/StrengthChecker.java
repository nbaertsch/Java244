/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordChecker;

/**
 *
 * @author noah.baertsch
 */
public class StrengthChecker {
    
    private final char[] reqChars;
    private int minLength;
    private int maxLength;
    
    public StrengthChecker(String reqChars){
        this.reqChars = reqChars.toCharArray();
    }
    
    public boolean checkPassword(String pass) throws ObjectMisconfiguredException{
        if(minLength <= 0 || maxLength <= 1 || reqChars.length <= 1){
            throw new ObjectMisconfiguredException();
        }
        
        if(pass.length()<this.minLength || pass.length()>this.maxLength){
            return false;
        }
        
        for(char c : this.reqChars){
            if(!pass.contains(Character.toString(c))){
                return false;
            }
        }
        
        return true;
    }

    public char[] getReqChars(){
        return this.reqChars;
    }
    
    /**
     * @return the minLength
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    
}
