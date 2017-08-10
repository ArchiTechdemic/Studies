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
    
    public static void bubble_sort(int array[]) {
        int n = array.length;
        int k;
        boolean isSorted = true;
        
        System.out.println ("\nInput array = " + Arrays.toString(array));
        
        for (int m = n; m >= 0; m--) {
            isSorted = true;
            
            for (int i = 0; i < m - 1; i++) {
                k = i + 1;
                
                System.out.print ("[" + i + "] " + array[i] + " " + array [k]);
                if (array[i] > array[k]) {
                    isSorted = false;
                    swapNumbers (i, k, array);
                    System.out.print (" --> " + array[i] + ", " + array [k]);
                }
                System.out.println();
            }
            printNumbers (array);
            
            if (isSorted) {
                System.out.println ("Array is sorted");
                break;
            }
        }
    }
    
    private static void swapNumbers (int i, int j, int[] array) {
        int t;
        
        t = array[i];
        array[i] = array [j];
        array[j] = t;
    }
    
    private static void printNumbers (int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print (input[i] + " ");
        }
        System.out.println();
    }
    
    public static void main (String [] args) {
        int[] input = { 5, 10, 2, 8, 9, -4, 7, 20, 15, 6, -6 };
        bubble_sort (input);
        int [] input2 = { 3, 6, 8, 10, 2, 100, 1001};
        bubble_sort (input2);
    }
}
