/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InClassPractice;

import java.util.Arrays;
import java.util.List;

class Computer implements Comparable<Computer>{
    private List<User> userList;
    private AdminUser admin;
    int year;
    int kbRam;
    int hz;
    boolean isOn;
    String manufacturer;
    
    /**
     * No Arg Constructor
     */
    Computer(){
        
    }
    
    /**
     * Generates 
     * @param year
     * @param kbRam
     * @param manufacturer 
     */
    Computer(int year, int kbRam, int hz, String manufacturer){
        this.year = year;
        this.kbRam = kbRam;
        this.manufacturer = manufacturer;
        this.hz = hz;
    }
    
    public void setAdmin(AdminUser admin){
        this.admin = admin;
    }
    public AdminUser getAdmin(){
        return this.admin;
    }
    
    @Override
    public int compareTo(Computer o) {
        int
        diff = this.year - o.year;
        return diff;
    }
    
    public void addUser(User user){
        this.userList.add(user);
    }

}

abstract class User{
    String name;
    String pass;
}

class AdminUser extends User{
    
}

class PublicUser extends User{
    
}

/**
 *
 * @author noah
 */
public class ClonePractice {
    public static void main(String[] args){
        
        Integer[] intArray = new Integer[5];
        intArray[0] = 5;
        intArray[1] = 4;
        intArray[2] = 3;
        intArray[3] = 2;
        intArray[4] = 1;
        for(Integer i : intArray)
            System.out.println(i);
        Arrays.sort(intArray);
        System.out.println();
        for(Integer i : intArray)
            System.out.println(i);
        
        //Computers
        Computer[] comps = new Computer[3];
        comps[0] = new Computer(1975, 256, 2, "Imasi");
        comps[2] = new Computer(2016, 8000000, 3400, "Dell");
        comps[1] = new Computer(2019, 32000000, 3400, "AlienWare");
        
        for(Computer c : comps){
            System.out.print(c.year + ", " + c.kbRam + ", " + c.manufacturer + "\n");
        }
        
        Arrays.sort(comps);
        System.out.println();
        
        for(Computer c : comps){
            System.out.print(c.year + ", " + c.kbRam + ", " + c.manufacturer + "\n");
        }
    }
            
}
