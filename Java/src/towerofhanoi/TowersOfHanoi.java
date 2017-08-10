/*
 * The MIT License
 *
 * Copyright 2016 ArchiTechdemic <Techdemic.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package towerofhanoi;

import java.util.Scanner;

/**
 * This is a case study for the popular game Tower of Hanoi
 * This exercise is a perfect example on the use of recursion 
 * The simple concept is to simplify the problem to 2 parts:
 * 1) Move all the n-1 disc to the intermediate rod
 * 2) Move the n disc to the destination rod
 * The stopping condition is the most important concept in recursion
 * In this case, the stopping condition is when you are ready to move the 
 * smaller disc, disc #1.
 *
 * @author ArchiTechdemic <Techdemic.com>
 */
public class TowersOfHanoi {

    static int discs=0; // total number of discs
    static int moveNo=0; // move number
  
    public static void main(String[] args) {
        TowersOfHanoi toh = new TowersOfHanoi();
        System.out.print("Please enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        discs = scanner.nextInt();
        
        toh.process(discs, "A", "B", "C");
        
        System.out.println ("--- Conclusion ---");
        System.out.println ("Towers of Hanoi solution for " + discs + " discs.");
        System.out.println ("It took a total of " + moveNo + " moves to complete this puzzle.");
    }
    
    public void process (int n, String start, String intermediate, String end) {
        logProcess (n, start, intermediate, end);       
        
        if (n == 1) {
            // recursive stopping condition
            logMove (n, start, end); 
        } else {
            // first move n-1 discs from start rod to intermediate rod
            process (n-1, start, end, intermediate);
            // now it is ready to move the n disc from the start rod to the end rod
            logMove (n, start, end);
            // continue to move the n-1 discs from intermediate rod to the desire end rod
            process (n-1, intermediate, start, end);
        }
    }
    
    public void logMove (int n, String from, String to) {
        moveNo++;
        indent ((discs-n)*5);       
        System.out.println ("[moveNo " + moveNo + "]--> move disc " + n + " from " + from + " -> " + to + ")");
    }
    
    public void logProcess (int n, String start, String intermediate, String end) {
        indent ((discs-n)*5);   
        System.out.println ("process ( disc " + n + " , " + start + " , " + intermediate + " , " + end + " )");
    }
    
    public void indent (int n) {
        for (int i=0; i<n; i++) {
            System.out.print (" ");
        }
    }
}
