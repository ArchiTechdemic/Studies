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
package Factorial;

import java.util.Scanner;

/**
 * This is a case study on Factorial, a comparison between using a for loop to a recursive function.
 * Factorial is a classic math problem that is very elegantly solved with recursion.  But this is
 * also a problem that can easily solved with a simple for loop as well.
 * 
 * A side note on factorial is that the result get very big very quickly.  So you will soon run into the
 * size limit of the data type.  The code here is only to illustrate as an example, if you do want 
 * a robust factorial code, you will need to invest some time in different data type as well as 
 * error handling in case the resulting number is too big for the data type.
 * 
 * @author ArchiTechdemic <Techdemic.com>
 */
public class Factorial {
    
    // calculating factorial using for loop
    static int factorial (int n) {
        int i, result = 1;
        for (i=n; i > 1; i--)
            result *= i;
        return result;
    }
    
    // calculating factorial using recursion
    static int factorialR (int n) {
        if (n == 0)
            return 1;
        else
            return n * factorialR(n-1);
    }
    
    public static void main(String[] args) {
        System.out.print("Please enter a positive number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int answer1, answer2;
       
        if (n>=0) {
            answer1 = factorial(n);
            System.out.println (n + "! (using for loop)  = " + answer1);

            answer2 = factorialR(n);
            System.out.println (n + "! (using recursion) = " + answer2);
            
            if (answer1 != answer2)  // both answer should be the same, alert if not
                System.out.println ("*** Error dectected, the 2 answers are not equal");
        } else {
            System.out.println ("Sorry, can't do factorial on negative number, please enter a positive number " + n);
        } 
    }
}
