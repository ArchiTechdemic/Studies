/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author ArchiTechdemic <Techdemic.com>
 */
public class MyBubbleSort {
    
    public static void bubble_sort(int numArray[]) {
        
        int cCount=0;  // how many time do we compare?
        int sCount=0;  // how many time do we swap?
        boolean swapped = true;
        int last = numArray.length - 2;
        
        while (swapped) {
            swapped = false; //if we go though this loop and never swap, the array is sorted
            
            for (int i=0; i<= last; i++) {
                cCount++;
                if (numArray[i] > numArray[i+1]) {
                    int temp = numArray[i];
                    numArray[i] = numArray[i+1];
                    numArray[i+1] = temp;
                    swapped = true;  //we did a swap, so the array is not sorted yet
                    sCount++;
                }  
            }    
            last--;
        }
        // print out some stastical data
        System.out.println("# of elements = " + numArray.length);
        System.out.println("Compare Count = " + cCount);
        System.out.println("Swap Count    = " + sCount);
    }
    
    /* In order to sort strings, we need to overload the class
     * to accept string array as input, and use specific string
     * comparison for evaluation
    */
    public static void bubble_sort(String[] strArray) {
        
        int iCount=0;
        int sCount=0;
        boolean swapped = true;
        int last = strArray.length - 2;
        
        while (swapped) {
            swapped = false;
            
            for (int i=0; i<= last; i++) {
                iCount++;
                if (strArray[i].compareTo(strArray[i+1]) > 0) {
                    String temp = strArray[i];
                    strArray[i] = strArray[i+1];
                    strArray[i+1] = temp;
                    swapped = true;
                    sCount++;
                }  
            }    
            last--;
        }
        // print out some stastical data
        System.out.println("Length= " + strArray.length);
        System.out.println("iCount= " + iCount);
        System.out.println("sCount= " + sCount);
    }
    
    public static void main (String [] args) {
        
        System.out.println ("--- Test Case 1 - random ordered numbers ---");
        int[] input1 = { 5, 10, 2, 8, -4, 7, 20, -6 };
        System.out.println ("Before Sorting = " + Arrays.toString(input1));
        bubble_sort (input1);
        System.out.println ("After Sorting = " + Arrays.toString(input1));
        System.out.println();
        
        System.out.println ("--- Test Case 2 - random ordered numbers ---");
        int[] input2 = { 3, 6, 8, 10, 2, 100, 1001, 5, 2, -6, 0};
        System.out.println ("Before Sorting = " + Arrays.toString(input2));
        bubble_sort (input2);
        System.out.println ("After Sorting = " + Arrays.toString(input2));
        System.out.println();
        
        System.out.println ("--- Test Case 3 - already sorted");
        int[] input3 = { 1, 3, 5, 7, 9, 11, 13, 15 };
        System.out.println ("Before Sorting = " + Arrays.toString(input3));
        bubble_sort (input3);
        System.out.println ("After Sorting = " + Arrays.toString(input3));
        System.out.println();
           
        System.out.println ("--- Test Case 4 - worse case");
        int[] input4 = { 100, 90, 80, 75, 60, 53, 42, 39, 27, 15, 5, 0};
        System.out.println ("Before Sorting = " + Arrays.toString(input4));
        bubble_sort (input4);
        System.out.println ("After Sorting = " + Arrays.toString(input4)); 
        System.out.println();
        
        System.out.println ("--- Test Case 5 - Sorting strings");
        String[] strInput1 = {"Elephant", "Dogs", "Zebra", "Cat", "Mouse" };
        System.out.println ("Before Sorting = " + Arrays.toString(strInput1));
        bubble_sort (strInput1);
        System.out.println ("After Sorting = " + Arrays.toString(strInput1)); 
        System.out.println();
    }
}
