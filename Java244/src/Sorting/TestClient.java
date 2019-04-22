/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.ArrayList;

/**
 *
 * @author noah
 */
import java.util.Random;
public class TestClient {
    
    
    public static void main(String[] args) {
        int[] origin = initRandArray();
        Sorter s = new Sorter();
        
        for(int i =0; i<10; i++){
            System.out.print(origin[i] + ", ");
        }
        System.out.println();
        
        int[] heap = s.heapSort(origin);
        
        for(int i =0; i<10; i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
        
        long[] heaptime = s.getHeaptime();
        System.out.println("HeapSort returned in " + (heaptime[1] - heaptime[0]) + " miliseconds.");
        
    }
    
    private static int[] initRandArray(){
        int[] origin = new int[10000];
        Random ran = new Random();
        for(int i =0; i<origin.length; i++){
            origin[i] = ran.nextInt();
        }
        return origin;
    }
    
}
