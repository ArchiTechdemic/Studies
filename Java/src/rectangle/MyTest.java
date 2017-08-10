package rectangle;

/*
 * The MIT License
 *
 * Copyright 2017 ArchiTechdemic <Techdemic.com>.
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


import rectangle.Rect;
import java.util.Arrays;

/**
 *
 * @author ArchiTechdemic <Techdemic.com>
 */
public class MyTest {
    
    public static void main (String[] args){
        
        /* this is an implementation created for a special case study
         * that only require a boolean answer if the 2 rectangles 
         * intersect or not.
         * as rectangle definition is coming from the input console,
         * it is a bit complex to get the input and convert to int.
         * this was a quick implementation, so the input processing can
         * certainly use some improvement and error checking.
         */
        
        /*
        for (String arg : args) {
            System.out.println(arg);
        } */
        
        int[] argsInt = new int[8];
        
        // Test case 1: inputs are passed in as seperate arguments 
        System.out.println ("--- Test Case 1 ---");
        System.out.println ("--- Get user inputs from command line arguments ---");
        
        if (args.length > 0) {
            
            for (int i=0; i<args.length; i++) {
                argsInt[i] = Integer.parseInt(args[i]);
            }

            System.out.println("argsInt= " + Arrays.toString(argsInt));

            Rect r1 = new Rect (argsInt[0],argsInt[1],argsInt[2], argsInt[3]);
            Rect r2 = new Rect (argsInt[4],argsInt[5],argsInt[6], argsInt[7]);

            System.out.println (r1.toString());
            System.out.println (r2.toString());
            System.out.println("intersect1? " + r1.intersect1(r2));
            System.out.println("intersect2? " + r1.intersect2(r2));
        }
        else {
            System.out.println ("-- no input arguments found");
        }
        
        // test case #2, in case if the 8 numbers are coming in as 1 string
        System.out.println("--- Test Case 2 ---");
        System.out.println ("--- In case if inputs are sent in a 1 string with spaces ---");
        String s= "1 1 2 2 6 6 3 3";
       
        int i=0;
        //int[] numberInt = new int[8];
        
        String[] inputs = s.split(" ");
        for (String numberStr : inputs){
           //System.out.println ("i= " + i);
           //System.out.println(numberStr);
           argsInt[i] = Integer.parseInt(numberStr);
           i++;
        }
        
        System.out.println ("argsInt= "+ Arrays.toString(argsInt)); 
        
        Rect r3 = new Rect (argsInt[0],argsInt[1],argsInt[2], argsInt[3]);
        Rect r4 = new Rect (argsInt[4],argsInt[5],argsInt[6], argsInt[7]);
        
        System.out.println (r3.toString());
        System.out.println (r4.toString());
        System.out.println("intersect1? " + r3.intersect1(r4));
        System.out.println("intersect2? " + r3.intersect2(r4));
    }
}
