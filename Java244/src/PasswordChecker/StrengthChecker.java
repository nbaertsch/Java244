package PasswordChecker;

/**
 * Used to test a password against a given String of required characters/symbols
 * 
 * @author noah.baertsch
 */
public class StrengthChecker {
    
    private char[] reqChars;
    private int minLength;
    private int maxLength;
    private String[][] feedback; 
    
    /**
     * Builds a new StrengthChecker object, and instantiates a new String[][] for validation feedback
     * 
     * @param reqChars String of required characters/symbols
     */
    public StrengthChecker(String reqChars){
        this.reqChars = reqChars.toCharArray();
        this.feedback = new String[(this.reqChars.length + 2)][2];
        
        int i=0;
        while(i < this.reqChars.length){
            this.feedback[i][0] = Character.toString(this.reqChars[i]);
            i++;
        }
        
        //minLength
        this.feedback[i][0] = "minLength";
        i++;
        
        //maxLength
        this.feedback[i][0] = "maxLength";
    }
    
    /**
     * Checks a given String against the requirements
     * Builds onto the feedback String[][] for granular verification
     * 
     * @param pass the password to test
     * @return boolean representing whether this password passes the requirements
     * @throws ObjectMisconfiguredException thrown if the StringChecker is misconfigured
     */
    public boolean checkPassword(String pass) throws ObjectMisconfiguredException{
        boolean passed = true;
        if(minLength <= 0 || maxLength <= 1 || reqChars.length < 1 || minLength > maxLength){
            throw new ObjectMisconfiguredException();
        }
        
        if(pass.length()<this.minLength){
            this.feedback[(this.feedback.length-2)][1] = "failed";
            passed = false;
        } else{
            this.feedback[(this.feedback.length-2)][1] = "passed";
        }
        
        if(pass.length()>this.maxLength){
            this.feedback[(this.feedback.length-1)][1] = "failed";
            passed = false;
        } else{
            this.feedback[(this.feedback.length-1)][1] = "passed";
        }
        
        for(int i=0; i<this.feedback.length-2; i++){
            if(!pass.contains(this.feedback[i][0])){
                this.feedback[i][1] = "failed";
                passed = false;
            } else{
                this.feedback[i][1] = "passed";
            }
        }
        
        return passed;
    }
    
    /**
     * 
     * @return required characters/symbols
     */
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

    /**
     * @return the feedback for in-depth explanation of why a password passed or failed.  Parse it yourself.
     */
    public String[][] getFeedback() {
        return feedback;
    }
    
}
